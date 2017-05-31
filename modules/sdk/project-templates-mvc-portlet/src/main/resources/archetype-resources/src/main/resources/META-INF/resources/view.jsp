<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="${artifactId}.caption"/></b>
</p>

<portlet:actionURL name="/say_hello" var="sayHelloUrl">
	<portlet:param name="mvcActionCommand" value="/say_hello" />
</portlet:actionURL>

<aui:form action="<%= sayHelloUrl %>" method="post" name="fm">
	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset>
			<aui:input label="${artifactId}.please-enter-your-name" name="inputName" type="text" />
		</aui:fieldset>
	</aui:fieldset-group>

	<aui:button-row>
		<aui:button cssClass="btn-lg" type="submit" value="${artifactId}.say-hello" />
	</aui:button-row>
</aui:form>