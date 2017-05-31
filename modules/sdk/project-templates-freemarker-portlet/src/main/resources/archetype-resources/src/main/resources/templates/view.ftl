#set($symbol_pound = "#")
<${symbol_pound}include "init.ftl">

<@liferay_ui["message"] key="${artifactId}.caption" />

<@portlet["actionURL"] var="sayHelloUrl">
	<@portlet["param"]
		name="mvcPath"
		value="/say_hello.ftl"
	/>
</@>

<@aui["form"] action=(sayHelloUrl) enctype="multipart/form-data" method="post" name="fm">
	<@aui["layout"]>

	<@aui["fieldset-group"] markupView="lexicon">
		<@aui["fieldset"]>
			<@aui["input"] label="${artifactId}.please-enter-your-name" name="inputName" type="text" />
		</@>
	</@>

	<@aui["button-row"]>
		<@aui["button"] cssClass="btn-lg" type="submit" value="${artifactId}.say-hello" />
	</@>
</@>