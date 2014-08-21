
package org.mule.modules.quickbooks.windows.adapter;

import javax.annotation.Generated;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-21T02:51:05-05:00", comments = "Build 3.4.3.1620.30ea288")
public interface HttpCallbackAdapter {

      Integer getLocalPort();

    Integer getRemotePort();

    String getDomain();

    org.mule.api.transport.Connector getConnector();

    Boolean getAsync();

    String getPath();
}
