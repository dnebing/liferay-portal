<%@ include file="/init.jsp" %>

<%
String name = ParamUtil.getString(request, "name", "");
%>

<p>
	<b><liferay-ui:message arguments="<%= name %>" key="${artifactId}.hello" /></b>
</p>