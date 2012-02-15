package org.mule.modules;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;
import org.mule.modules.quickbooks.api.gateway.MuleOAuthCredentialStorage;
import org.mule.modules.quickbooks.api.gateway.oauth.OAuthGateway;

import com.intuit.ipp.oauth.signing.RsaSha1MessageSigner;
import com.intuit.ipp.oauth.signing.XoAuthAuthorizationHeaderSigningStrategy;

public class MinalTestDriver
{
    private static final String INTERNAL_GATEWAY_PROPS = "/internal-gateway/src/main/resources/internal-gateway.properties";
    private Properties properties;
    private PrivateKey privateKey;
    
    private MuleOAuthCredentialStorage storage;
    
    private String accessToken = null;
    private String accessSecret = null;
    
    @Test
    public void test()
    {
        try
        {
            loadProperties(INTERNAL_GATEWAY_PROPS);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        String appKey = "e53dxxcn2r6b2buxrgxgdujnd7v"; //appKey
        //String consumersecret = "6_bgyaev47g_bydszh_b_bq8pqkb675nvwbt6hjyf3k78cz_v4hwcrrfym7zywsctmgdymwkjrhkxtpi5kgrwyzikyi58569eeub_bgx85prpg"; //intuitTic
        
        String consumerkey = "qyprde4fyLtZkek51wU2E3hJ9ebEO9";
        String consumersecret = "LBCswYFjlEtck2zBVcxqm7tmx3XtDIPho9XfSHlW";
        String realmID = "212879793";
        //oauth_token_secret=cijLe10chzYALwWyFZs0scgx7FeyvpP6zusYTeWU&oauth_token=qyprdl5iCteW6kzzwxdW0tK7NvtOVO7K1afLvOr09Ziy2Qcr
        //String accesstoken = "qyprdl5iCteW6kzzwxdW0tK7NvtOVO7K1afLvOr09Ziy2Qcr";
        //String accesstokensecret = "cijLe10chzYALwWyFZs0scgx7FeyvpP6zusYTeWU";
        // TODO Auto-generated method stub
//        String consumerkey = "qyprdQHtGk7ELGpdo74xFlzTpbAsZf";
//        String consumersecret = "3eibtokzqn9bdk57Vqu3AjCfZelVZXebbCrgpLGt";
//        String accesstoken = "qyprdVCtec3vN8A0rsFjFZ1OOkxhve3MvK6Mpm7jGoQMHwwW";
//        String accessstokensecret = "KGAc3sZ1dtLQsaNkw1j7nsUwXIkeGn6IygZNP3Ys";
//        String realmID = "213816578";

        //https://oauth.intuit.com/oauth/v1/create_consumer?appToken=<APP_TOKEN>
        //oauth_consumer_secret=LBCswYFjlEtck2zBVcxqm7tmx3XtDIPho9XfSHlW&oauth_consumer_key=qyprde4fyLtZkek51wU2E3hJ9ebEO9
        
//        String dynamicConsumerKey = null;
//        String dynamicConsumerSecret = null;
//        StringTokenizer tokenizer = new StringTokenizer(str, "&");
//        while (tokenizer.hasMoreTokens()) {
//            String token = tokenizer.nextToken();
//            if (token.startsWith("oauth_consumer_secret=")) {
//                dynamicConsumerSecret = token.substring("oauth_consumer_secret=".length());
//            } else if (token.startsWith("oauth_consumer_key=")) {
//                dynamicConsumerKey = token.substring("oauth_consumer_key=".length());
//            }
//        }
        storage = new MuleOAuthCredentialStorage();
        storage.setConsumerKey(appKey);
        storage.setConsumerSecret("");
        
        getAccessTokensFromSaml();
        
      CommonsHttpOAuthConsumer postConsumer = new CommonsHttpOAuthConsumer(appKey, "");
        
                    postConsumer.setMessageSigner(new RsaSha1MessageSigner(privateKey));
        
                    postConsumer.setTokenWithSecret(accessToken, "");
                    
        // String GET_CUST_URL =
        // "https://qbo.intuit.com/qbo1/resource/customer/v2/"+realmID+"/2";
        // Using Http Cache Auth
//1        OAuthConsumer ouathconsumer = new CommonsHttpOAuthConsumer(consumerkey, consumersecret);
//1        ouathconsumer.setTokenWithSecret(accesstoken, accesstokensecret);

        // sample url
        String GET_CUST_URL = "https://services.intuit.com/sb/customer/v2/"+ realmID;
        // String GET_CUST_URL =
        // "https://qbo.intuit.com/qbo1/resource/customer/v2/213919304/3";

        try
        {

            // create an HTTP request to a protected resource
            // HttpPost request = new HttpPost(GET_CUST_URL);
            HttpGet request = new HttpGet(GET_CUST_URL);
            request.addHeader("Content-Type", "application/xml");
            // request.addHeader("Content-Type",
            // "application/x-www-form-urlencoded");
            // Filtering Sample , here I am filtering by FamilyName
            // List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            // nameValuePairs.add(new BasicNameValuePair("Filter",
            // "FAMILYNAME :EQUALS: Modified"));
            // request.setEntity(new UrlEncodedFormEntity(nameValuePairs));

//1            ouathconsumer.sign(request);
            postConsumer.sign(request);

            // ,making a request
            HttpClient httpclient = new DefaultHttpClient();
            try
            {
                HttpResponse response = httpclient.execute(request);
                if (response != null && response.getStatusLine().getStatusCode() == 200)
                {
                    InputStream is = response.getEntity().getContent();
                    // BufferedReader rd = new BufferedReader(new
                    // InputStreamReader(response.getEntity().getContent()));
                    String line = "";
                    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                    org.w3c.dom.Document doc = docBuilder.parse(is);
                    Transformer transformer = TransformerFactory.newInstance().newTransformer();
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                    // initialize StreamResult with File object to save to file
                    StreamResult result = new StreamResult(new StringWriter());
                    DOMSource source = new DOMSource(doc);
                    transformer.transform(source, result);

                    String xmlString = result.getWriter().toString();
                    System.out.println(xmlString);

                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();

            }
            // sign the request

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            System.out.println("Exception cought:\n" + ex.toString());
        }
    }
    
    private void getAccessTokensFromSaml()
    {   
        String keyStorePath = (String) properties.get("keystore.keystorePath");
        String keyStorePassword = (String) properties.get("keystore.password");
        String privateKeyPassword = (String) properties.get("keystore.privateKeyPassword");
        String privateKeyAlias = (String) properties.get("keystore.privateKeyAlias");
        String keyStoreType = (String) properties.get("keystore.keystoreType");
        String tokens = null;
        try 
        {
            KeyStore keyStore = KeyStore.getInstance(keyStoreType);
            keyStore.load(new FileInputStream(keyStorePath), keyStorePassword.toCharArray());
            privateKey = (PrivateKey) keyStore.getKey(privateKeyAlias, privateKeyPassword.toCharArray());
            tokens = new OAuthGateway(storage,
                                      new RsaSha1MessageSigner(privateKey),
                                      new XoAuthAuthorizationHeaderSigningStrategy())
                        .getOAuthToken(System.getenv("serviceProviderId"),
                                       System.getenv("authIdPseudonym"), 
                                       System.getenv("realmIdPseudonym"));
            
            accessToken = tokens.substring(tokens.indexOf("oauth_token_secret=") + "oauth_token_secret=".length(), tokens.indexOf("&"));
            accessSecret = tokens.substring(tokens.indexOf("oauth_token=") + "oauth_token=".length());
        } 
        catch (Exception e) 
        {
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
}
