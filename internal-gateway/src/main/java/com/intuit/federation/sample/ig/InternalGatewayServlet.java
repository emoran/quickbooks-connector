/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

/**
  Copyright (c) 2009 Intuit, Inc. 

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.opensource.org/licenses/eclipse-1.0.php
 
  Contributors:

  Intuit Inc:  Initial submission.
 */
package com.intuit.federation.sample.ig;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.opensaml.DefaultBootstrap;
import org.opensaml.saml2.core.Assertion;
import org.opensaml.saml2.core.Attribute;
import org.opensaml.saml2.core.AttributeStatement;
import org.opensaml.saml2.core.EncryptedAttribute;
import org.opensaml.saml2.core.impl.ResponseImpl;
import org.opensaml.saml2.encryption.Decrypter;
import org.opensaml.security.SAMLSignatureProfileValidator;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.encryption.InlineEncryptedKeyResolver;
import org.opensaml.xml.io.Unmarshaller;
import org.opensaml.xml.io.UnmarshallerFactory;
import org.opensaml.xml.parse.BasicParserPool;
import org.opensaml.xml.security.credential.BasicCredential;
import org.opensaml.xml.security.keyinfo.KeyInfoCredentialResolver;
import org.opensaml.xml.security.keyinfo.StaticKeyInfoCredentialResolver;
import org.opensaml.xml.signature.SignatureValidator;
import org.opensaml.xml.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Demonstrates a simple Internal Gateway that a partner may build to make use
 * of Intuit federated identities.  Everything here is standards-based SAML
 * showing use of the OpenSAML library to crack the SAML coming from Intuit,
 * search for interesting information, and handle encrypted attributes that
 * Intuit sends.
 * 
 * This is one way to accomplish this task and should be enough to get partners
 * going in Java.
 * 
 * @author jruthenbeck
 * @date 2/2/2009
 */
public class InternalGatewayServlet extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
    private static Logger sLog = LoggerFactory.getLogger(InternalGatewayServlet.class);
    private static final int MAX_ENCODED_SAML_DATA_LENGTH = 8200;   // Base64 = ((Bytes + 3 - (Bytes MOD 3)) /3) x 4
    private static final String INTERNAL_GATEWAY_PROPS = "/internal-gateway.properties";
    private Properties properties;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InternalGatewayServlet() 
    {
        super();
        try 
        {
            loadProperties(INTERNAL_GATEWAY_PROPS);
        } 
        catch (Exception e) 
        {
            sLog.error("Can't locate properties file: " + INTERNAL_GATEWAY_PROPS, e);
        }
    }

    private void loadProperties(String resourceName) throws IOException 
    {
        this.properties = new Properties();
        InputStream fileInputStream = null;
        try 
        {
            fileInputStream = this.getClass().getResourceAsStream(resourceName);
            if (fileInputStream != null) 
            {
                this.properties.load(fileInputStream);
            } 
            else 
            {
                String name = resourceName.substring(1);
                fileInputStream = new FileInputStream(name);
                if (fileInputStream != null) 
                {
                    this.properties.load(fileInputStream);
                } 
                else 
                {
                    throw new IOException("Configuration resource " + resourceName + " not found");
                }
            }
        } 
        finally 
        {
            if (fileInputStream != null) 
            {
                fileInputStream.close();
                fileInputStream = null;
            }
        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        try 
        {
            //
            // Note: It's not shown here, but it's CRITICAL that you verify the XML 
            // signature of the SAML you receive to verify that it's from Intuit. If 
            // you don't, someone could spoof a request and access your user's data.
            // An example of doing this to get you started is in 
            // SignedSamlSamples.demoVerifyingXmlSignature().

            Map<String, String> valueMap = parseRequestForValues(request);
            sLog.debug("Parsed SAML and retrieved the following values:");
            for (String s : valueMap.keySet()) 
            {
                sLog.debug("  " + s + " -> " + valueMap.get(s));
            }

            // For now, just pull out the values individually.
            String intuitTicket = valueMap.get(WorkplaceAttributeType.TICKET.toString());
            String intuitAuthId = valueMap.get(WorkplaceAttributeType.AUTH_ID.toString());
            String intuitRealmIdPseudonym = valueMap.get(WorkplaceAttributeType.REALM_ID_PSEUDONYM.toString());
            String attrTargetUrl = valueMap.get(WorkplaceAttributeType.TARGET_URL.toString());

            System.out.println("Processed SAML.");
            System.out.println(" ++ intuitTicket: " + intuitTicket);
            System.out.println(" ++ intuitAuthId: " + intuitAuthId);
            System.out.println(" ++ intuitRealmIdPseudonym: " + intuitRealmIdPseudonym);
            //System.out.println(" ++ targetUrl: " + attrTargetUrl);    

//            if (!attrTargetUrl.contains("redirectInternal")) 
//            {
//                // We need to pass the SAML info to our application, which we'll do
//                // with URL params.
//                redirectToPartnerServiceApp(request, response, valueMap);
//            }
//            else
//            {
//                redirectToThisUsingIntuitAuthId(request, response, attrTargetUrl, intuitAuthId);
//            }
        } 
        catch (Exception e) 
        {
            sLog.error("Unable to process SAML request. " + e.getMessage(), e);
            System.out.println(e.getMessage());
            renderToErrorJsp(request, response, e.getMessage(), e);
        }
    }
    
    /**
     * The partner-service application is a second sample app that demonstrates how to use
     * the information sent in the SAML (and parsed by this internal-gateway) to call
     * back into Intuit to get data for the user of the app.
     * 
     * This app is separate from the internal-gateway code to make it clear that they
     * are independent (can be different languages, different domains, etc). 
     * 
     * @param request The request object containing the SAML content.
     * @param response The response object we'll use to send the 302 redirect.
     * @param intuitTicket User's authentication ticket which is required when calling
     *      back to Intuit to query data for this user.
     * @param intuitAuthId Unique identifier for the end user making this request.
     * @throws Exception
     */
    private void redirectToPartnerServiceApp(HttpServletRequest request,
                                             HttpServletResponse response, Map<String, String> values) throws Exception 
        {
        
        String redirectTo = values.get(WorkplaceAttributeType.TARGET_URL.toString());
        if (!redirectTo.contains("?")) 
        {
            redirectTo += "?";
        }
        else 
        {
            redirectTo += "&";
        }
        
        String urlParams = "i.authId=" + values.get(WorkplaceAttributeType.AUTH_ID.toString());
        urlParams += "&i.ticket=" + values.get(WorkplaceAttributeType.TICKET.toString());
        urlParams += "&i.realm=" + values.get(WorkplaceAttributeType.REALM_ID.toString());
        urlParams += "&i.peseudoRealm=" + values.get(WorkplaceAttributeType.REALM_ID_PSEUDONYM.toString());

        sLog.info("InternalGatewayServlet redirecting to: " + redirectTo + urlParams);
        response.sendRedirect(redirectTo + urlParams);
   }

    /**
     * For cases where internal-gateway is the only sample app installed, we provide
     * a way to gracefully demonstrate the federation success.
     */
    private void redirectToThisUsingIntuitAuthId(HttpServletRequest request, 
            HttpServletResponse response, String targetUrl, String intuitAuthId) throws Exception 
    {

        //
        // Service providers can take a couple different approaches here. The best
        // is probably to take the targetUrl value and redirect there. For demo
        // purposes, I'm checking the value included in the SAML to see if it's 
        // reasonable before redirecting there (the service provider gave this URL when
        // signing up with Workplace).  Alternately, the service provider could perform
        // arbitrary logic to choose the appropriate landing page based on the
        // service level of the user coming in. I'm hardcoding this to redirect
        // to THIS app just so it's all self contained - it wouldn't normally be
        // this way in the wild.
        // 

        String redirectTo = "serviceLanding.jsp";
        if (targetUrl != null && targetUrl.trim() != "")
        {
            redirectTo = targetUrl;
        }
        response.sendRedirect(redirectTo + "?i.authId=" + intuitAuthId);
    }

    /**
     * Loads this gateway's private key based on the keystore type property setting in the 
     * internal-gateway.properties file. Types include: JKS, PKCS12. If no value is set in the
     * properties file, JKS is used. For more information on standard keystore types see:
     * 
     * http://java.sun.com/j2se/1.5.0/docs/guide/security/CryptoSpec.html#AppA
     * 
     */
    private PrivateKey loadPrivateKey() throws Exception 
    {
        
        // Look up the keystore properties and fail if they do not exist.
        String val = (String) properties.get("keystore.password");
        if (val == null) 
        {
            throw new Exception("The properties file does not contain keystore.password.");
        }
        char[] keyStorePassword = val.toCharArray();
        
        val = (String) properties.get("keystore.privateKeyPassword");
        if (val == null) 
        {
            throw new Exception("The properties file does not contain keystore.privateKeyPassword.");
        }
		char[] privateKeyPassword = val.toCharArray();
		
		String privateKeyAlias = (String) properties.get("keystore.privateKeyAlias");
		if (privateKeyAlias == null) 
		{
		    throw new Exception("The properties file does not contain keystore.privateKeyAlias.");
		}
		
		String keystorePath = (String) properties.get("keystore.keystorePath");
		if (keystorePath == null) 
		{
		    throw new Exception("The properties file does not contain keystore.keystorePath.");
		}
		
		// Read the keystore type defaulting to JKS
		String keystoreType = (String) properties.get("keystore.keystoreType");
		if (keystoreType == null) 
		{
		    keystoreType = "JKS";
		}
		
		if ("JKS".equalsIgnoreCase(keystoreType)) 
		{
			return loadPrivateKeyFromJKSFile(keyStorePassword, privateKeyPassword, privateKeyAlias, keystorePath);
		}
		else if ("PKCS12".equalsIgnoreCase(keystoreType)) 
		{
			return loadPrivateKeyFromP12File(keyStorePassword, privateKeyPassword, privateKeyAlias, keystorePath);
		}
		
		throw new Exception("Unsupported keystore type:" + keystoreType);
	}

	/**
	 * Loads this gateway's private key from your local Java Keystore (JKS repository).
	 * 
	 * @param keystorePath The path to the keystore file.
	 * @param privateKeyAlias2 The private key alias.
	 * @param privateKeyPassword2 The private key password.
	 * @param keyStorePassword2 The keystore password.
	 * 
	 * @return The PrivateKey object to be used for decrypting the SAML message.
	 * @throws Exception
	 */
	private PrivateKey loadPrivateKeyFromJKSFile(char[] keyStorePassword, 
			char[] privateKeyPassword, String privateKeyAlias, String keystorePath) throws Exception 
	{
		
		//
		// XML-Security standard decryption setup. Note that I'm loading from
		// a .p12 file here - you can also load from an X.509 cert or JKS file
		// if you've got your key in that format. Since loading from .p12
		// (as generated by OpenSSL) is a little more involved, I'll show that.
		KeyStore ks = KeyStore.getInstance("JKS");
		ks.load(new FileInputStream(keystorePath), keyStorePassword);

		KeyStore.PasswordProtection pp = 
			new KeyStore.PasswordProtection(privateKeyPassword);
		
		KeyStore.PrivateKeyEntry entry = 
			(KeyStore.PrivateKeyEntry) ks.getEntry(privateKeyAlias, pp);

		for (Enumeration<String> alias = ks.aliases(); alias.hasMoreElements();)
		{
		    System.out.println(alias.nextElement());
		}
		// Sanity check to make sure the PKCS file contains the private key
		if (entry instanceof PrivateKeyEntry) 
		{
			// Good.
		} 
		else 
		{
			throw new Exception("p12 file does not contain private key as expected.");
		}
		PrivateKey pk = entry.getPrivateKey();
		return pk;
	}
	/**
	 * Loads this gateway's private key in whatever way is appropriate. For the
	 * sample, we load it from a .p12 file that came from OpenSSL. Other options
	 * include loading it direct from an X509 pub/priv cert (.der file), from your
	 * local Java Keystore (JKS repository), or others.
	 * 
	 * @param keystorePath The path to the keystore file.
	 * @param privateKeyAlias2 The private key alias.
	 * @param privateKeyPassword2 The private key password.
	 * @param keyStorePassword2 The keystore password.
	 * 
	 * @return The PrivateKey object to be used for decrypting the SAML message.
	 * @throws Exception
	 */
	public static PrivateKey loadPrivateKeyFromP12File(char[] keyStorePassword, 
			char[] privateKeyPassword, String privateKeyAlias, String keystorePath) throws Exception 
	{
		
		//
		// XML-Security standard decryption setup. Note that I'm loading from
		// a .p12 file here - you can also load from an X.509 cert or JKS file
		// if you've got your key in that format. Since loading from .p12
		// (as generated by OpenSSL) is a little more involved, I'll show that.
		KeyStore ks = KeyStore.getInstance("PKCS12");
		ks.load(new FileInputStream(keystorePath), keyStorePassword);
	      
	    for (Enumeration<String> en = ks.aliases(); en.hasMoreElements();) 
	    {
	        System.out.println(en.nextElement());
	    }
		
		KeyStore.PasswordProtection pp = 
			new KeyStore.PasswordProtection(privateKeyPassword);
		KeyStore.PrivateKeyEntry entry = 
			(KeyStore.PrivateKeyEntry) ks.getEntry(privateKeyAlias, pp);

		// Sanity check to make sure the PKCS file contains the private key
		if (entry instanceof PrivateKeyEntry) 
		{
			// Good.
		} 
		else 
		{
			throw new Exception("p12 file does not contain private key as expected.");
		}
		PrivateKey pk = entry.getPrivateKey();
		return pk;
	}
	
	
	/**
	 * <p>Single method that aggregates all potential information that our Serivce Provider
	 * App may want to know about this SAML request. This includes:
	 * <ul>
	 * 	<li>Encrypted SAML Attributes</li>
	 *  <li>Plain Text SAML Attributes</li>
	 *  <li>Value of the NameID SAML element (known as "AuthId")</li>
	 *  <li>All URL parameters passed to this internal-gateway servlet</li>
	 * </ul>
	 * You'll need to look at the contents of this Map to see what information is available,
	 * along with the keys to access it. Known (and expected) keys are stored in the
	 * WorkplaceAttributeType enum.</p>
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	private Map<String, String> parseRequestForValues(HttpServletRequest request) throws Exception 
	{
		String samlParamKey = "SAMLResponse";
		HashMap<String, String> valueMap = 
			new HashMap<String, String>();
		
		// Get our private key so we can decrypt any encrypted SAML attributes 
		PrivateKey pk = loadPrivateKey();
		
		// Read the encoded SAML from the request
		String encodedSaml = request.getParameter(samlParamKey);

		if (encodedSaml == null) 
		{
			// No SAML was sent. Probably because someone hit it directly.
			String message = "No SAML xml was provided in the request. ";
			message += "We expected to find the SAML xml in param: " + samlParamKey;
			throw new Exception(message);
		}

        // Check that the encoded SAML is a sane size. A valid signed assertion is ~1700 chars.
        if (encodedSaml.length() > MAX_ENCODED_SAML_DATA_LENGTH) 
        {
            // The SAML is abnormally large. This is probably not a valid request.
            String message = "The SAML xml provided in the request is too large: ";
            message += encodedSaml.length() + " chars.";
            throw new Exception(message);
        }
		
		// It's base64 encoded. Unencode it.
		byte[] base64DecodedByteArray = Base64.decode(encodedSaml);
		String encryptedSaml = new String(base64DecodedByteArray);
		sLog.debug("Encrypted SAML XML is:\n" + encryptedSaml);
		
		// Verify the signature in the SAML
		verifyXmlSignature(encryptedSaml);

		// We need to set the private key on our Credential because the symmetric
		// key was encrypting using our public key. This means we need to *decrypt*
		// it with our private key. 
		BasicCredential c = new BasicCredential();
		c.setPrivateKey(pk);
		
		KeyInfoCredentialResolver keyResolver = 
			new StaticKeyInfoCredentialResolver(c);

		// The symmetric key is encrypted and placed inside our SAML xml doc. Use
		// this resolver to ensure it gets loaded from the KeyInfo element.
		InlineEncryptedKeyResolver encryptionKeyResolver = new InlineEncryptedKeyResolver();
		
		Decrypter d = new Decrypter(null, keyResolver, encryptionKeyResolver);
		d.setRootInNewDocument(true);
		
		//
		// Now that we've got our decryption tool ready to go, we need to load
		// the SAML xml and parse it, searching for the xml element that is
		// encrypted.
		//
		
		//
		// Parse the whole SAML xml.
		ResponseImpl samlResponse = null;
		
		DefaultBootstrap.bootstrap();
		BasicParserPool ppMgr = new BasicParserPool();
		ppMgr.setNamespaceAware(true);
		
		ByteArrayInputStream bais = new ByteArrayInputStream(encryptedSaml.getBytes());
		Document inCommonMDDoc = ppMgr.parse(bais);
		
		Element metadataRoot = inCommonMDDoc.getDocumentElement();
		
		UnmarshallerFactory unmarshallerFactory = 
			org.opensaml.xml.Configuration.getUnmarshallerFactory();
		Unmarshaller unmarshaller = unmarshallerFactory.getUnmarshaller(metadataRoot);

		XMLObject xmlObject = unmarshaller.unmarshall(metadataRoot);
		samlResponse = (ResponseImpl) xmlObject;		

		// 
		// Alright, look through the SAML to get each piece of interesting information
		// we care about. This particular implementation is for a known set of
		// attributes and could/should be made more general if needed.
		Assertion a = samlResponse.getAssertions().get(0);
		AttributeStatement as = a.getAttributeStatements().get(0);
		List<EncryptedAttribute> eas = as.getEncryptedAttributes();
		List<Attribute> attributes = as.getAttributes();

		// The TICKET attribute comes across as encrypted
		String attrValue = null;
		for (EncryptedAttribute ea : eas) 
		{
			Attribute attr = d.decrypt(ea);
			if ("ticket".equals(attr.getName())) 
			{
				attrValue = attr.getAttributeValues().get(0).getDOM().getTextContent();
				valueMap.put(attr.getName(), attrValue);
				sLog.info("Decrypted value: " + attr.getName() + "|" + attrValue);
			}
		}

		// Load up the clear text attributes and values
		for (Attribute attr : attributes) 
		{
			attrValue = attr.getAttributeValues().get(0).getDOM().getTextContent();
			valueMap.put(attr.getName(), attrValue);
		}
		
		// Find the Intuit AuthId
		String authId = 
			samlResponse.getAssertions().get(0).getSubject().getNameID().getValue();
		valueMap.put(WorkplaceAttributeType.AUTH_ID.toString(), authId);

		// Any other params in the URL should probably get included as well (future proofing) 
		for (Object s : request.getParameterMap().keySet()) 
		{
			String pName = (String) s;
			String pValue = request.getParameter(pName);
			valueMap.put(pName, pValue);
		}
		
		return valueMap;
	}
	
	/**
	 * Recipients should always verify the XML signature contained in the SAML
	 * to ensure it came from Intuit as expected.  This method shows how
	 * to do this.  Note that the actual public key Credential you should use
	 * depends on the Intuit environment the request is coming from - different
	 * certificates are used for PRODUCTION and other envs. This method reads the path
	 * of the cert from the properties file. You can set the path to the appropriate 
	 * environment there. 
	 * 
	 * Keep in mind that any trivial changes to the SAML assertion, including
	 * whitespace or line ending changes, will throw the signature validation off. 
	 *  
	 * @throws Exception If the the path is invalid or the SAML does not verify.
	 */
	private void verifyXmlSignature(String uncryptedXML) throws Exception 
	{

		//
		// In this example, the sampleSignedSaml.xml file came from the Intuit
		// PROD environment.  I'll load the appropriate certificate for XML
		// signature verification.
		CertificateFactory cf = CertificateFactory.getInstance("X.509");

		// Look up the keystore properties and fail if they do not exist.
		String prdCrtFile = (String) properties.get("IPPPublicKeyPath");
		if (prdCrtFile == null) 
		{
			throw new Exception("The properties file does not contain IPPPublicKeyPath.");
		}
				
		Certificate intuitCert = cf.generateCertificate(new FileInputStream(prdCrtFile));
		PublicKey pk = intuitCert.getPublicKey();
		
		//
		// OpenSAML uses xml-tooling's infrastructure objects for cryptography
		BasicCredential credential = new BasicCredential();
		credential.setPublicKey(pk);
		
		ResponseImpl samlResponse = null;

		BasicParserPool ppMgr = new BasicParserPool();
		ppMgr.setNamespaceAware(true);

		ByteArrayInputStream bais = new ByteArrayInputStream(uncryptedXML.getBytes());
		Document inCommonMDDoc = ppMgr.parse(bais);

		Element metadataRoot = inCommonMDDoc.getDocumentElement();

		// Initializes OpenSAML to use the default config files packaged inside
		// the opensaml-x.y.z.jar
		DefaultBootstrap.bootstrap();

		UnmarshallerFactory unmarshallerFactory = org.opensaml.xml.Configuration.getUnmarshallerFactory();
		Unmarshaller unmarshaller = unmarshallerFactory.getUnmarshaller(metadataRoot);

		XMLObject xmlObject = unmarshaller.unmarshall(metadataRoot);
		samlResponse = (ResponseImpl) xmlObject;

		// The signed object is the Assertion.
		Assertion a = samlResponse.getAssertions().get(0);

		SAMLSignatureProfileValidator profileValidator = new SAMLSignatureProfileValidator();
		profileValidator.validate(a.getSignature());
		
		SignatureValidator sigValidator = new SignatureValidator(credential);
		    //sigValidator.validate(a.getSignature());	
	}
	
	private void renderToErrorJsp(HttpServletRequest req, HttpServletResponse response, String msg, Exception e) 
	{
		req.setAttribute("msg", msg);
		req.setAttribute("exceptionObject", e);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/showError.jsp");
		try 
		{
			rd.forward(req, response);
		} 
		catch (Exception ex) 
		{
			
			System.out.println("Unable to forward to showError.jsp.");
			ex.printStackTrace();
		}
	}

}
