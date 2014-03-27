/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.quickbooks.online.objectfactory;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import org.mule.modules.quickbooks.api.model.PlatformResponse;
import org.mule.modules.quickbooks.api.model.ReconnectResponse;
import org.mule.modules.quickbooks.api.model.UserInformation;
import org.mule.modules.quickbooks.api.model.UserResponse;

/**
* This object contains factory methods for each 
* Java content interface and Java element interface 
* generated in the org.mule.modules.quickbooks.schema package. 
* <p>An ObjectFactory allows you to programatically 
* construct new instances of the Java representation 
* for XML content. The Java representation of XML 
* content can consist of schema derived interfaces 
* and classes representing the binding of schema 
* type definitions, element declarations and model 
* groups.  Factory methods for each of these are 
* provided in this class.
* 
*/
@XmlRegistry
public class ObjectFactory {

 private final static QName _UserResponse_QNAME = new QName("http://platform.intuit.com/api/v1", "UserResponse");
 private final static QName _PlatformResponse_QNAME = new QName("http://platform.intuit.com/api/v1", "PlatformResponse");
 private final static QName _ReconnectResponse_QNAME = new QName("http://platform.intuit.com/api/v1", "ReconnectResponse");

 /**
  * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.mule.modules.quickbooks.schema
  * 
  */
 public ObjectFactory() {
 }

 /**
  * Create an instance of {@link UserResponse }
  * 
  */
 public UserResponse createUserResponse() {
     return new UserResponse();
 }
 
 /**
  * Create an instance of {@link UserResponse }
  * 
  */
 public UserInformation createUserInformation() {
     return new UserInformation();
 }

 /**
 * Create an instance of {@link org.mule.modules.quickbooks.api.model.PlatformResponse }
 *
 */
 public PlatformResponse createPlatformResponse() {
    return new PlatformResponse();
 }

 /**
 * Create an instance of {@link org.mule.modules.quickbooks.api.model.ReconnectResponse }
 *
 */
 public ReconnectResponse createReconnectResponse() {
    return new ReconnectResponse();
 }
 
 /**
  * Create an instance of {@link JAXBElement }{@code <}{@link UserResponse }{@code >}}
  * 
  */
 @XmlElementDecl(namespace = "http://platform.intuit.com/api/v1", name = "UserResponse")
 public JAXBElement<UserResponse> createUserResponse(UserResponse value) {
     return new JAXBElement<UserResponse>(_UserResponse_QNAME, UserResponse.class, null, value);
 }

 /**
 * Create an instance of {@link JAXBElement }{@code <}{@link PlatformResponse }{@code >}}
 *
 */
 @XmlElementDecl(namespace = "http://platform.intuit.com/api/v1", name = "PlatformResponse")
 public JAXBElement<PlatformResponse> createPlatformResponse(PlatformResponse value) {
    return new JAXBElement<PlatformResponse>(_PlatformResponse_QNAME, PlatformResponse.class, null, value);
 }

 /**
 * Create an instance of {@link JAXBElement }{@code <}{@link ReconnectResponse }{@code >}}
 *
 */
 @XmlElementDecl(namespace = "http://platform.intuit.com/api/v1", name = "ReconnectResponse")
 public JAXBElement<ReconnectResponse> createReconnectResponse(ReconnectResponse value) {
    return new JAXBElement<ReconnectResponse>(_ReconnectResponse_QNAME, ReconnectResponse.class, null, value);
 }
 
}

