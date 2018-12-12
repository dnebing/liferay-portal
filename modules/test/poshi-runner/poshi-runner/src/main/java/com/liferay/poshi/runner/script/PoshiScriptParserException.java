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

package com.liferay.poshi.runner.script;

import com.liferay.poshi.runner.elements.PoshiNode;
import com.liferay.poshi.runner.util.StringUtil;

/**
 * @author Kenji Heigel
 */
public class PoshiScriptParserException extends Exception {

	public static int getExceptionCount() {
		return exceptionCount;
	}

	public PoshiScriptParserException(String msg) {
		super(msg);

		exceptionCount++;
	}

	public PoshiScriptParserException(String msg, PoshiNode poshiNode) {
		super(msg);

		setErrorDetails(poshiNode.getPoshiScript());
		setFilePath(poshiNode.getFilePath());
		setLineNumber(poshiNode.getPoshiScriptLineNumber());

		exceptionCount++;
	}

	public PoshiScriptParserException(
		String msg, String poshiScript, PoshiNode parentPoshiNode) {

		super(msg);

		setFilePath(parentPoshiNode.getFilePath());

		String parentPoshiScript = parentPoshiNode.getPoshiScript();

		setErrorDetails(parentPoshiScript);

		parentPoshiScript = parentPoshiScript.trim();

		int index = parentPoshiScript.indexOf(poshiScript.trim());

		int lineNumber =
			parentPoshiNode.getPoshiScriptLineNumber() +
				StringUtil.count(parentPoshiScript, "\n", index);

		setLineNumber(lineNumber);

		exceptionCount++;
	}

	public String getErrorDetails() {
		return _errorDetails;
	}

	public String getFilePath() {
		return _filePath;
	}

	public int getLineNumber() {
		return _lineNumber;
	}

	@Override
	public String getMessage() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.getMessage());
		sb.append(" at:\n");
		sb.append(getFilePath());
		sb.append(":");
		sb.append(getLineNumber());
		sb.append("\n");
		sb.append(getErrorDetails());

		return sb.toString();
	}

	public void setErrorDetails(String errorDetails) {
		_errorDetails = errorDetails;
	}

	public void setFilePath(String filePath) {
		_filePath = filePath;
	}

	public void setLineNumber(int lineNumber) {
		_lineNumber = lineNumber;
	}

	protected static int exceptionCount;

	private String _errorDetails = "";
	private String _filePath = "Unknown file";
	private int _lineNumber;

}