<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Get OID</name>
   <tag></tag>
   <elementGuidId>c502c917-b152-4722-ae77-77179ff8297e</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <katalonVersion>8.4.0</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${url}/get/${oid}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.oid_url</defaultValue>
      <description></description>
      <id>cdeee481-9184-4769-bb89-f9f0d3a3b5eb</id>
      <masked>false</masked>
      <name>url</name>
   </variables>
   <variables>
      <defaultValue>'1.3.6.1.4.1.50749.2.5.2.1.3.1.2.57.0'</defaultValue>
      <description></description>
      <id>2cbba044-0f6c-4816-9dcf-930de5cf6be2</id>
      <masked>false</masked>
      <name>oid</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
