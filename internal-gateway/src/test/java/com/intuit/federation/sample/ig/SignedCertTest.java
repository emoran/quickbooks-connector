package com.intuit.federation.sample.ig;

import org.junit.Test;

public class SignedCertTest
{
    @Test
    public void signedCertNotEmptyTest()
    {
        char[] keyStorePassword = "intuit".toCharArray();
        char[] privateKeyPassword = "intuit".toCharArray();
        String privateKeyAlias = "federatedconnectortestapp";
        String keystorePath = "/home/gaston/federatedconnectortestapp.zauberlabs.com.p12";
        
        try
        {
            InternalGatewayServlet.loadPrivateKeyFromP12File(keyStorePassword, privateKeyPassword, privateKeyAlias, keystorePath);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
