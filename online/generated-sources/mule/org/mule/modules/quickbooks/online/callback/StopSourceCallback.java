
package org.mule.modules.quickbooks.online.callback;

import javax.annotation.Generated;


/**
 * Callback returned by methods that are annotated with @Source
 * <p/>
 * It will be executed when the MessageSource is being stopped.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-25T05:23:44-05:00", comments = "Build 3.4.3.1620.30ea288")
public interface StopSourceCallback {

    void stop() throws Exception;
}