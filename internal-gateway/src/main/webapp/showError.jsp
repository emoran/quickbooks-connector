<%--

    Mule QuickBooks Connector

    Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com

    The software in this package is published under the terms of the CPAL v1.0
    license, a copy of which has been included with this distribution in the
    LICENSE.txt file.

--%>

<!----------------------------------------------------------------------- 
   Copyright (c) 2009 Intuit, Inc.
   All rights reserved. This program and the accompanying materials
   are made available under the terms of the Eclipse Public License v1.0
   which accompanies this distribution, and is available at
   http://www.opensource.org/licenses/eclipse-1.0.php
 
   Contributors:
      Intuit Partner Platform  initial contribution
 ----------------------------------------------------------------------->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>You Got an Error</title>
</head>
<body>
<h2>We hit an error.</h2>
<p>
<%= request.getAttribute("msg") %>
</p>


<pre>
<% ((Exception)request.getAttribute("exceptionObject")).printStackTrace(); %>
</pre>

</body>
</html>