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

import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;
import org.joda.time.format.ISODateTimeFormat;

public class QBDateAdapter extends XmlAdapter<String, Date> {

    private DateTimeFormatter dateTimeFormatter;

    public QBDateAdapter() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimeParser[] parsers = { 
                ISODateTimeFormat.dateTimeNoMillis().getParser(),
                ISODateTimeFormat.dateTime().getParser(),
                DateTimeFormat.forPattern( "yyyy-MM-ddZ" ).withZone(DateTimeZone.getDefault()).getParser()
                 };
        builder.append(ISODateTimeFormat.dateTimeNoMillis().getPrinter(), parsers);
        dateTimeFormatter = builder.toFormatter();
    }

    @Override
    public String marshal(Date date) throws Exception {
        return new DateTime(date).toString(dateTimeFormatter);
    }

    @Override
    public Date unmarshal(String date) throws Exception {
        if (date == null) {
            return null;
        }

        return dateTimeFormatter.parseDateTime(date).toDate();
    }
}