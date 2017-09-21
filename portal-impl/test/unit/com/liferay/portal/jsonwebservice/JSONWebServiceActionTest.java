/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.jsonwebservice;

import com.liferay.portal.kernel.jsonwebservice.JSONWebServiceAction;
import com.liferay.portal.kernel.jsonwebservice.JSONWebServiceActionsManagerUtil;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

/**
 * @author Dave Nebinger
 */
public class JSONWebServiceActionTest
	extends BaseJSONWebServiceTestCase {

	@BeforeClass
	public static void setUpClass() throws Exception {
		initPortalServices();

		registerAction(new AnnotatedService());
	}

	@Test
	public void testMultiAnnotatedParamValid() throws Exception {
		MockHttpServletRequest mockHttpServletRequest = createHttpRequest(
				"/annotated/addFile");

		mockHttpServletRequest.setParameter("fileName", "123");

		JSONWebServiceAction jsonWebServiceAction =
				JSONWebServiceActionsManagerUtil.getJSONWebServiceAction(
						mockHttpServletRequest);
	}

	@Test
	public void testMultiAnnotatedParamFailNull() throws Exception {
		MockHttpServletRequest mockHttpServletRequest = createHttpRequest(
				"/annotated/addFile");

		mockHttpServletRequest.setParameter("fileName", (String) null);

		JSONWebServiceAction jsonWebServiceAction =
				JSONWebServiceActionsManagerUtil.getJSONWebServiceAction(
						mockHttpServletRequest);
	}

	@Test
	public void testMultiAnnotatedParamFailTooLong() throws Exception {
		MockHttpServletRequest mockHttpServletRequest = createHttpRequest(
				"/annotated/addFile");

		mockHttpServletRequest.setParameter("fileName", "12345678901234567890");

		JSONWebServiceAction jsonWebServiceAction =
				JSONWebServiceActionsManagerUtil.getJSONWebServiceAction(
						mockHttpServletRequest);
	}

	@Test
	public void testMultiAnnotatedParamsBothValid() throws Exception {
		MockHttpServletRequest mockHttpServletRequest = createHttpRequest(
				"/annotated/camel");

		mockHttpServletRequest.setParameter("goodName", "test@liferay.com");
		mockHttpServletRequest.setParameter("badName", "test");

		JSONWebServiceAction jsonWebServiceAction =
				JSONWebServiceActionsManagerUtil.getJSONWebServiceAction(
						mockHttpServletRequest);
	}

	@Test
	public void testMultiAnnotatedParamsFailParm1NotEmail() throws Exception {
		MockHttpServletRequest mockHttpServletRequest = createHttpRequest(
				"/annotated/camel");

		mockHttpServletRequest.setParameter("goodName", "test-liferay.com");
		mockHttpServletRequest.setParameter("badName", "test");

		JSONWebServiceAction jsonWebServiceAction =
				JSONWebServiceActionsManagerUtil.getJSONWebServiceAction(
						mockHttpServletRequest);
	}

	@Test
	public void testMultiAnnotatedParamsFailParm2TooLong() throws Exception {
		MockHttpServletRequest mockHttpServletRequest = createHttpRequest(
				"/annotated/camel");

		mockHttpServletRequest.setParameter("goodName", "test@liferay.com");
		mockHttpServletRequest.setParameter("badName", "test12345678901234567890");

		JSONWebServiceAction jsonWebServiceAction =
				JSONWebServiceActionsManagerUtil.getJSONWebServiceAction(
						mockHttpServletRequest);
	}

}
