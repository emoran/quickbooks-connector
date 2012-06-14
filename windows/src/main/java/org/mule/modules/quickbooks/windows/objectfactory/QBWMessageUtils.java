/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.quickbooks.windows.objectfactory;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.mule.modules.quickbooks.utils.MessageUtils;
import org.mule.modules.quickbooks.windows.schema.RestResponse;


/**
 * The MessageUtils helps to manage marshaling and unmarshaling of QBO objects.
 * getXMLDocument method converts the object to the XML String to send to IDS.
 * ParseResponse extracts the response CDM object or Error Object from the response XML.
 * 
 */
public class QBWMessageUtils extends MessageUtils {
    
    private static QBWMessageUtils qbwMessageUtils = null;
    
    private QBWMessageUtils() {}
    
    public static QBWMessageUtils getInstance()
    {
        if (qbwMessageUtils == null )
        {
            qbwMessageUtils = new QBWMessageUtils();
        }
        
        return qbwMessageUtils;
    }
    
    private static class QBWMessageUtilsHelper {
        private static ObjectFactory objectFactory = new ObjectFactory();
        private static JAXBContext privContext = null;
        
        /**
         * Create new or return existing JAXB context for QBO CdmBase classes.
         * @return JAXBContext to Marshall or Unmarshall object
         */
        public static JAXBContext getContext() {
            if (privContext == null) {
                try {
                    privContext =  JAXBContext.newInstance(org.mule.modules.quickbooks.windows.schema.ObjectFactory.class.getPackage().getName());
                } catch (JAXBException e) {
                    throw new RuntimeException(e);
                }
            }
            return privContext;
        }
        
        public static Object getObjectFactory()
        {
            return objectFactory;
        }
    }

    @Override
    protected JAXBContext getJaxbContext()
    {
        return QBWMessageUtilsHelper.getContext();
    }

    @Override
    protected Object getObjectFactory()
    {
        return QBWMessageUtilsHelper.getObjectFactory();
    }
    
    @Override
    public Object parseResponse(String responseString) throws JAXBException
    {
        Unmarshaller unmarshaller = createUnmarshaller();
        final Object unmarshalledObject = unmarshaller.unmarshal(new StringReader(responseString));
        JAXBElement jaxb = ((RestResponse)unmarshalledObject).getSystemResponse();

        return jaxb.getValue();

    }
}
