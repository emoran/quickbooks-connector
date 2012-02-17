/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.quickbooks.utils;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


/**
 * The MessageUtils helps to manage marshaling and unmarshaling of QBO objects.
 * getXMLDocument method converts the object to the XML String to send to IDS.
 * ParseResponse extracts the response CDM object or Error Object from the response XML.
 * 
 */
public class QBOMessageUtils {
    
    private QBOMessageUtils() {}
    
    /*
     * Inner class to enforce the proper initialization of the static variables in this utility class.
     * This relies on the fact that inner classes are not loaded until referenced. 
     * See: http://en.wikipedia.org/wiki/Double-checked_locking
     */
    private static class MessageUtilsHelper {
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
    }
        
    /**
     * Create Marshaller from the JAXB context. 
     * @return Marshaller 
     */
    public static Marshaller createMarshaller() {
        try {
            Marshaller marshaller = MessageUtilsHelper.getContext().createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            return marshaller;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Create UnMarshaller from the JAXB context. 
     * @return UnMarshaller 
     */
    public static Unmarshaller createUnmarshaller() {
        try {
            return MessageUtilsHelper.getContext().createUnmarshaller();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Get object of ObjectFactory class generated using JAXB and XSD
     * @return ObjectFactory Class object.
     */
    public static ObjectFactory getObjectFactory() {
        return MessageUtilsHelper.objectFactory;
    }
    
    /**
     * This method JAXBElement object to XML String.
     * IDS REST Services process XML string and Responds in XML.
     * @param objectToMarshall
     * @return
     * @throws JAXBException
     */
    public static String getXmlDocument(JAXBElement<? extends Object> objectToMarshall) throws JAXBException {
        StringWriter writer = new StringWriter();
        Marshaller marshaller = createMarshaller();
        marshaller.marshal(objectToMarshall, writer);
        String documentToPost = writer.toString();
        return documentToPost;
    }
    
    /**
     * Clients of this method must make their own determination as to the contents of the response.
     * Generally this can be safely achieved by checking the instanceof.
     * @param responseString
     * @return The unmarshalled response object.
     * @throws JAXBException If the response unmarshaling fails.
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static Object parseResponse(String responseString) throws JAXBException {
        Unmarshaller unmarshaller = QBOMessageUtils.createUnmarshaller();
        final Object unmarshalledObject = unmarshaller.unmarshal(new StringReader(responseString));
        JAXBElement<Object> jaxb = (JAXBElement<Object>)unmarshalledObject;

        return jaxb.getValue();

    }
    
    public static <T> JAXBElement<T> createJaxbElement(T obj)
    {
        try
        {
            return (JAXBElement<T>) MessageUtilsHelper.objectFactory.getClass()
                .getMethod("create" + obj.getClass().getSimpleName(), obj.getClass())
                .invoke(MessageUtilsHelper.objectFactory, obj);
        }
        catch (Exception e)
        {
            throw new AssertionError(e);
        }
    }
    
}
