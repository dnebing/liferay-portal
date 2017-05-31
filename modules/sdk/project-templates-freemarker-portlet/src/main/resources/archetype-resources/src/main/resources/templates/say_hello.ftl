#set($symbol_pound = "#")
<${symbol_pound}include "init.ftl">
<${symbol_pound}assign name = ParamUtil.getString(requet, "name", "") />

<@liferay_ui["message"] arguments=(name) key="${artifactId}.hello" />