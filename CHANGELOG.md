5.0
===
- Migrated QuickBooks Online Connector to API v3
- Changed QBO Client to use Intuit Java v3 SDK 2.2.1 for QBO
- Added integration tests with the mule-connector-test framework for the QBO Connector
- Changed schema version for the QBO Connector to 5.0
- Added query, paginated-query and query-with-metadata operations for the QBO Connector
- Added delete-object-with-id operation for the QBO Connector
- Changed get-company-metadata to get-company-info for the QBO Connector
- Added retryCount, retryInterval, connectionTimeOut and requestTimeOut as configurable properties for the QBO Connector
- Removed commons-cert, internal-gateway, examples-online and examples-windows
- Added getters to QuickBooksRuntimeException

4.0
===
- Migrated to DevKit 3.3.2
- Migrated authentication to Intuit platform OAuth support (QBO and QBW)
- Added blueDotMenu API
- Added OpenID support
- More unit tests

3.0
===
- DataMapper version is now master branch
- Updated dependencies version
- Added ServiceProviderId as connector property
- Added companyMetadata operation
- Added currentUser API support
- Deleted deprecated model classes
- Added commons-cert
- Bug fixing

2.1
===
- DataMapper support
- New Studio demo
- Changed schema generation for QBO and QBW
- Improved search operations
- Bug fixing and unit tests
