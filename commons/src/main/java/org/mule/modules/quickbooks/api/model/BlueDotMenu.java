/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.quickbooks.api.model;

import java.util.List;

/**
 * Class for modeling BlueDotMenu information
 *
 * @author Mulesoft, inc
 */
public class BlueDotMenu {

    private List<AppMenuInformation> appMenuInformationList;
    private String blueDotHtml;

    public BlueDotMenu() {

    }

    public BlueDotMenu(List<AppMenuInformation> appMenuInformationList, String blueDotHtml) {
        this.appMenuInformationList = appMenuInformationList;
        this.blueDotHtml = blueDotHtml;
    }

    public List<AppMenuInformation> getAppMenuInformationList() {
        return appMenuInformationList;
    }

    public void setAppMenuInformationList(List<AppMenuInformation> appMenuInformationList) {
        this.appMenuInformationList = appMenuInformationList;
    }

    public String getBlueDotHtml() {
        return blueDotHtml;
    }

    public void setBlueDotHtml(String blueDotHtml) {
        this.blueDotHtml = blueDotHtml;
    }
}
