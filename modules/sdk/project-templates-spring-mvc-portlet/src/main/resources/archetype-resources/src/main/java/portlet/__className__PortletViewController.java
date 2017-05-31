package ${package}.portlet;

import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

/**
 * @author ${author}
 */
@Controller
@RequestMapping("VIEW")
public class ${className}PortletViewController {

	/**
	 * Handles the say hello action.
	 * @param  request the action request
	 * @param  response the action response
	 */
	@ActionMapping(params = "action=sayHello")
	public void sayHello(ActionRequest request, ActionResponse response) {
		String inputName = ParamUtil.getString(request, "inputName", "");

		// fix the capitalization on the name

		String name = _capitalizeFully(inputName);

		// hide the success message.

		_hideDefaultSuccessMessage(request);

		response.setRenderParameter("name", name);
	}

	/**
	 * Returns the view when the action key is set to <code>sayHello</code>.
	 *
	 * @param  request the render request
	 * @param  response the render response
	 * @return the view result
	 */
	@RenderMapping(params = "action=sayHello")
	public String sayHello(RenderRequest request, RenderResponse response) {
		return "say_hello";
	}

	@RenderMapping
	public String view(RenderRequest request, RenderResponse response) {
		return "view";
	}

	/**
	 * capitalizeFully: Capitalizes first letter of all words in given string.
	 * @param str String to capitalize.
	 * @return String The fully capitalized string.
	 */
	private String _capitalizeFully(String str) {
		if ((str == null) || (str.length() == 0)) {
			return str;
		}

		int strLen = str.length();
		str = str.toLowerCase();
		StringBuffer buffer = new StringBuffer(strLen);
		boolean capitalizeNext = true;

		for (int i = 0; i < strLen; i++) {
			char ch = str.charAt(i);

			if (Character.isWhitespace(ch)) {
				buffer.append(ch);
				capitalizeNext = true;
			}
			else if (capitalizeNext) {
				buffer.append(Character.toTitleCase(ch));
				capitalizeNext = false;
			}
			else {
				buffer.append(ch);
			}
		}

		return buffer.toString();
	}

	private void _hideDefaultSuccessMessage(PortletRequest portletRequest) {
		SessionMessages.add(
			portletRequest,
			PortalUtil.getPortletId(portletRequest) +
				".hideDefaultSuccessMessage");
	}
}