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

package com.liferay.user.associated.data.component;

/**
 * The base interface for the UAD framework. Do not implement this interface
 * directly.
 *
 * @author Drew Brokke
 * @param <T> the type of entity to be anonymized, deleted, edited, exported, or
 *        displayed. Also used as an identifier for grouping the various
 *        components
 * @see com.liferay.user.associated.data.anonymizer.UADAnonymizer
 * @see com.liferay.user.associated.data.display.UADDisplay
 * @see com.liferay.user.associated.data.exporter.UADExporter
 * @review
 */
public interface UADComponent<T> {

	/**
	 * Returns a class representing the type of data the extending components
	 * are concerned with.
	 *
	 * @return the identifying class of type {@code T}
	 * @review
	 */
	public Class<T> getTypeClass();

}