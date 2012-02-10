<pre>
Intuit Identity Federation
Partner Internal Gateway sample

@author rlarson
@date 1-22-2010

Quick Start
===============================================================================
1. Edit src/main/resources/internal-gateway.properties to refer to the 
   ippsample-keystore.p12 keystore in your local filesystem. For example:
   
   #######################################################################
   #                The absolute path to the keystore file               #
   #######################################################################
   keystore.keystorePath=[your-workspace-path]/internal-gateway/src/main/resources/ippsample-keystore.p12
   
   This must be a path that can be read by your deployed war.
   
2. Edit src/main/resources/internal-gateway.properties to refer to the 
   IPP cert in your local filesystem. For example:
   
   #######################################################################
   #                The absolute path to the Intuit public key           #
   #######################################################################
   keystore.IPPPublicKeyPath=[your-workspace-path]/internal-gateway/src/main/resources/SAML-workplace.intuit.com.saml.crt
   
   This must be a path that can be read by your deployed war.

3. Ensure you can build the project using Maven 2.0.9: "mvn clean install"

4. Place the internal-gateway.war into your appserver's deployment directory.
     
5. Start your application server.

6. Navigate to http://<host>/internal-gateway-webapp ... you should see the release 
    notes document (src/main/webapp/index.jsp).
    
7. Load the code into Eclipse Ganymede or Galileo.

8. Run the JUnit tests in src/test/java. You should get green bars.

Notes:
   This project's maven build uses artifacts in the code.intuit.com nexus repo.
   If you have problems building with Maven, use this settings.xml file: 
   https://code.intuit.com/svn/repos/open-mvn-repo/buildtools/trunk/cic-dev-settings.xml
   
   If you run into trouble, try the Java FAQ and mailing list:
   
   https://code.intuit.com/sf/wiki/do/viewPage/projects.ipp_fed_auth/wiki/JavaFAQ
   https://code.intuit.com/sf/discussion/do/listForums/projects.ipp_fed_auth/discussion
   
===============================================================================

This sample demonstrates sample code to accept incoming identity federation
messages from Intuit's IPP Platform. See release notes (index.jsp) for more 
info.

</pre>
