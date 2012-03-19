/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.quickbooks.schema.online.objectfactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.mule.modules.quickbooks.utils.MessageUtils;


/**
 * The MessageUtils helps to manage marshaling and unmarshaling of QBO objects.
 * getXMLDocument method converts the object to the XML String to send to IDS.
 * ParseResponse extracts the response CDM object or Error Object from the response XML.
 * 
 */
public class QBOMessageUtils extends MessageUtils {
    
    private static QBOMessageUtils qboMessageUtils = null;
    
    private QBOMessageUtils() {}
    
    public static QBOMessageUtils getInstance()
    {
        if (qboMessageUtils == null )
        {
            qboMessageUtils = new QBOMessageUtils();
        }
        
        return qboMessageUtils;
    }
    
    private static class QBOMessageUtilsHelper {
        private static ObjectFactory objectFactory = new ObjectFactory();
        private static JAXBContext privContext = null;
        
        /**
         * Create new or return existing JAXB context for QBO CdmBase classes.
         * @return JAXBContext to Marshall or Unmarshall object
         */
        public static JAXBContext getContext() {
            if (privContext == null) {
                try {
                    privContext =  JAXBContext.newInstance(ObjectFactory.class.getPackage().getName());
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
        return QBOMessageUtilsHelper.getContext();
    }

    @Override
    protected Object getObjectFactory()
    {
        return QBOMessageUtilsHelper.getObjectFactory();
    }
}
