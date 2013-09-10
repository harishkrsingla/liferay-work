<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"  %>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<h2>Settings</h2>

<%
String portletResource = ParamUtil.getString(request, "portletResource"); 

PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource); 

String username = prefs.getValue("username", StringPool.BLANK);
%>

 <liferay-portlet:actionURL portletConfiguration="true" var="ConfigUrl"  />
 
 <form action="<%=ConfigUrl.toString() %>" method="post" name="fm">

	Name : <input type="text" name="username" value="<%=username%>"> <br />
	<input type="submit">

</form>