<%--

    (c) 2003-2012 MuleSoft, Inc. This software is protected under international
    copyright law. All use of this software is subject to MuleSoft's Master
    Subscription Agreement (or other Terms of Service) separately entered
    into between you and MuleSoft. If such an agreement is not in
    place, you may not use the software.

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
<title>Service Provider Landing Page</title>
</head>
<body>
<div style="padding-left:30px; padding-top:30px;">
<div style="border: 1px solid; background-color:#DDDDDD; font-face:Arial; padding: 5px 5px 5px 5px; width:400px;">
The user is ultimately directed to this page after authenticating with the 
service provider's Internal Gateway. In our sample code, this page is hosted in
the same webapp as the Internal Gateway, but in the wild it would certainly 
point to an existing application that customers would want to use.<br/><br/>
intuit.authId=<%= request.getParameter("intuit.authId") %>
</div>
</div>
</body>
</html>