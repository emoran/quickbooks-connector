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
<html>
<head>
	<style>
		p {
			width: 500px;
			margin: 15px;
			padding: 5px;
		}
		
		.question {
			margin: 10px;
			padding-left: 20px;
			padding-top:10px;
			font-weight: bold;
		}
		
		.answer {
			margin: 10px;
			padding-left: 20px;
		}
		
		.shadeSection {
			padding: 5px;
			width: 800px;
			background-color: #EEEEEE;
		}
		
	</style>
</head>
<body>
<h1>Intuit Identity Federation</h1>
<h2>Partner Internal Gateway sample</h2>

<h3>What Does This Sample Show?</h3>
<div class="shadeSection">
This sample demonstrates sample code to accept incoming identity federation
messages from Intuit's Workplace Platform (<code>workplace.intuit.com</code>)
and can be used as a starting point to get your own Internal SAML Gateway running.
</div>

<h3>How Do I Build And Run This Sample?</h3>
<div class="shadeSection">
If you have successfully built and deployed the internal-gatewar.war and are reading this as served by your app server, nothing. Otherwise, 
follow the quickstart steps in the README.txt file this project's root directory. If you get stuck, ask for help in 
<a href="https://code.intuit.com/sf/discussion/do/listTopics/projects.ipp_fed_auth/discussion.developer_forum" target="_blank">
the IPP Federated Auth developer forum</a>.
</div>

<h3>What Does This Sample Contain?</h3>
<div class="shadeSection">
<ul>
<li>Includes Maven 2.0.9 pom and Eclipse project files.</li>
<li>Shipped configured to accept incoming SAML requests at 
		<code>http://host/internal-gateway/ig-secure</code></li>
<li>Makes use of open source OpenSAML - see pom.xml for version specifications.</li>
<li>Includes a number of unit tests (see SignedSamlSamples.java) demonstrating 
		example SAML processing for Intuit SAML messages. These tests should run correctly 
		for you out of the box.</li>
<li>Functionally working code, but make sure you enhance it to gracefully handle
		whatever errors may occur in your system.</li>
</ul>
</div>

<h3>How Can I Verify It's Working Properly?</h3>
<div class="shadeSection">
The best way is to use it end-to-end as part of your app's install in Workplace.
However, as a sanity check you can hit <a href="ig-secure">ig-secure</a>.
You should see a message indicating that No SAML xml was provided in the request.
If that doesn't work, see Troubleshooting section below.
</div>

<h3>How Do I Make This Work With My Federated App?</h3>
<div class="shadeSection">
<ol>
    <li>Review the <a href="http://codesharedocs.developer.intuit.com/ipp/wwhelp/wwhimpl/js/html/wwhelp.htm#href=TitlePage_3.html" target="_blank">
    IPP Federated Applications Guide</a>. The detailed instructions to set up your workplace application and service provider ID can be found there.</li>
	<li>Generate your own x509 certificate as described  
	<a href="http://ippblog.intuit.com/blog/2009/07/federated-applications-generating-your-x509-certificate.html" target="_blamk"> 
	in this blog post</a>. Make sure to add the keystore.p12 file you created to your app server working directory.
	<li>Modify the properties in <b>src/main/resources/internal-gateway.properties</b> for your environment and keystore.</li>
	<li>Rebuild and redeploy your war.</li> 
</ol>
</div>

<h3>What If I Find A Bug?</h3>
<div class="shadeSection">
Please report bugs and enhancement requests in the 
<a href="https://code.intuit.com/sf/tracker/do/listArtifacts/projects.ipp_fed_auth/tracker.issues" target="_blank">IPP Federated Authentication tracker</a>.
</div>

<h3>How Can I Help Improve This Sample Gateway?</h3>
<div class="shadeSection">
Join the <a href="https://code.intuit.com/sf/projects/ipp_fed_auth" target="_blank">IPP Federated Authentication project</a> and pitch in.
You can help improve documentation, write tests, create new key loaders, etc.
</div>

<h3>Troubleshooting</h3>
<div>
<div class="question">Why do I need to copy files to the working directory?</div>
<div class="answer">
Since the sample code tries to load the private key file from the current working 
directory, you need this.  For JBoss, this is $JBOSS_HOME/bin. For Tomcat, it's
$TOMCAT_HOME/bin.  Other appservers should be similar. We are working on alternative
ways to load the key and are always open to contributions.</div>

<div class="question">Why am I getting the error: java.lang.NoClassDefFoundError: org/slf4j/LoggerFactory</div>
<div class="answer">
The sample code uses the SLF4J interfaces for logging. Many appservers ship with
an implementation of these interfaces already, while others don't. If you're getting
this error, it means your appserver doesn't. Modify the internal-gateway.war file,
copying the jars in /src/main/lib-slf4j-impl into [internal-gateway.war]/WEB-INF/lib.

In the sample, these files are excluded from the war in the pom.xml file. In the pom, uncomment the exclusion:

<pre>
    &lt;warSourceExcludes&gt;
       WEB-INF/lib/*-over-slf4j-*.jar
    &lt;/warSourceExcludes&gt;
</pre>

</div>

<div class="question">When parsing the SAML, I get this: Cannot resolve 'xt:DEFAULT' as a QName: the prefix 'xt' is not declared.m. Why?</div>
<div class="answer">
The Sun JDK ships with an xml parser that doesn't inclue all the features that 
OpenSAML needs.  In short, you need to copy the files in /src/main/lib-endorsed into
your JRE's endorsed directory.  For me, that's a new directory called
<code>$JAVA_HOME/jre/lib/endorsed</code>.  For details, Google or see the
<a href="https://spaces.internet2.edu/display/OpenSAML/OSTwoUsrManJavaInstall">
OpenSAML wiki</a>.
</div>

<div class="question">What do I do with my certificate?</div>
<div class="answer">
This sample code ships with a certificate and private key that can be used to 
show how everything works.  You'll want to change the <b>src/main/resources/internal-gateway.properties</b> 
file and possibly the code to load your own private key instead. <b>Be sure the cert you give to Intuit corresponds 
to that private key</b>.
</div>

</div>

</body>
</html>
