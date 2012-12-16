CONFIGURING OPENID AND OAUTH
============================

OpenID
======

Starting OpenID flow
--------------------

The first step is to call OpenID provider and redirect the user to credentials page. The flow for this purpose is:

	<flow name="InitializeOpenID">
		<!-- INBOUND ENDPOINT -->
        <http:inbound-endpoint exchange-pattern="request-response" host="localhost" port="8081" />
        <quickbooks:open-id-initialize config-ref="Quickbooks_Online" callbackUrl="http://localhost:8090/openId" /> 
    </flow>

The callbackUrl parameter has to point to our callback inbound-endpoint.

Processing callback
-------------------

This connector provides an explicit processor to receive and process the callback.

	<flow name="VerifyResponseOpenID">
		<!-- INBOUND ENDPOINT -->
        <http:inbound-endpoint exchange-pattern="request-response" host="localhost" port="8090" path="openId"/>
        <quickbooks:verify-open-id config-ref="Quickbooks_Online" />
        <!-- REST_OF_YOUR_FLOW -->
    </flow>

The processor verify-open-id includes two optional parameters:

* receivingUrl: the callback url that was generated during initialize which is used for validating the response. By default it is extracted from the Mule message.

* responseParameters: a map with the query string parameters. By default it is extracted from the Mule message.

Using OAuth
===========

Intuit provides OAuth1.0a support for authenticating against QuickBooks Online applications. As the OpenID support this connector provides two operations -for initializing and processing the callback- in order to make it as flexible and configurable as possible. 

This connector includes multi-tenant support for OAuth based applications.

Starting OAuth dance
--------------------

The first step in OAuth dance is to obtain the request token from Intuit OAuth provider. The processor for this is:

	<flow name="Authorize">
		<!-- INBOUND ENDPOINT -->
        <http:inbound-endpoint exchange-pattern="request-response" host="localhost" port="8081"/>
        <quickbooks:auth-user config-ref="Quickbooks_Online" accessTokenUrl="https://oauth.intuit.com/oauth/v1/get_access_token" authorizationUrl="https://appcenter.intuit.com/Connect/Begin" callbackUrl="http://localhost:8090" requestTokenId="#[groovy:message.getSessionProperty('requestTokenIdentifier')]" requestTokenUrl="https://oauth.intuit.com/oauth/v1/get_request_token"/>
    </flow>

The parameters involved are:

* accessTokenUrl, authorizationUrl and requestTokenUrl: Intuit provider url's.

* callbackUrl: our callback inbound-endpoint address.

* requestTokenId: an unique identifier for the generated request token. This is used for multi-tenant support since the connector gets the request token and store it in the ObjectStore in order to exchange it in the future for an access token. This value has to be related to the tenant that calls the flow and it is concatenated to the callbackUrl using the variable name 'userId'.

Getting the access token
------------------------

This is the moment when the connector exchanges the authenticated token for an access token/secret. The flow for doing this is:

	<flow name="GetAccessToken">
        <!-- INBOUND ENDPOINT -->
        <http:inbound-endpoint exchange-pattern="one-way" host="localhost" port="8090"/>
        <quickbooks:get-access-token config-ref="Quickbooks_Online" />
        <!-- REST_OF_YOUR_FLOW -->
    </flow>

The processor get-access-token includes the following optional parameters:

* apiUrl: the tenant API url. If this is blank the connector gets it from Intuit.

* verifier: OAuth verifier. By default it is extracted from the Mule message using the inbound property 'oauth_verifier'.

* requestTokenId: the unique identifier for the authenticated request token. By default it is extracted from the Mule message using the inbound property 'userId'.

* userIdentifier: the value used for storing the OAuth credentials -access token and secret- in the ObjectStore. By default it is extracted from the Mule message using the inbound property 'realmId'.

Calling QBO operations
----------------------

Once the user is authenticated -or the credentials are available in the ObjectStore- it is possible to call the QuickBooks Online operations. The following is an example for list-accounts:

	<flow name="ListAccounts">
        <quickbooks:find-objects config-ref="Quickbooks_Online" accessTokenId="#[groovy:message.getSessionProperty('accessTokenIdentifier')]" queryFilter="LastUpdatedTime :AFTER: 2012-06-10T14:30:00-0700" type="ACCOUNT" />
        <json:object-to-json-transformer doc:name="Object to JSON"/>
        <logger level="INFO" doc:name="Logger"/>
    </flow>

accessTokenId is the parameter used by the operations for retrieving the corresponding credentials.