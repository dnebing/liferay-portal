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

package com.liferay.user.associated.data.anonymizer;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.user.associated.data.component.UADComponent;

/**
 * Provides a way to retrieve, count, anonymize and delete entities of type
 * <pre>T</pre> for a user. The {@code anonymousUser} parameter in the
 * {@code autoAnonymize} and {@code autoAnonymizeAll} methods is the anonymous
 * user defined for a particular company by {@code AnonymousUserConfiguration}.
 *
 * @author William Newbury
 * @param <T> of the type of entity to be anonymized or deleted.
 * @review
 */
@ProviderType
public interface UADAnonymizer<T> extends UADComponent<T> {

	/**
	 * Anonymizes the given entity and persists the changes to the database. The
	 * primary key of the user is used to match against different fields on the
	 * given entity. The anonymous user is given to provide replacement
	 * user-related data, if needed.
	 *
	 * @param t the entity to be anonymized
	 * @param userId the primary key of the user associated with type {@code T}
	 * @param anonymousUser the company's anonymous user
	 * @throws PortalException if the persistence throws an exception
	 * @review
	 */
	public void autoAnonymize(T t, long userId, User anonymousUser)
		throws PortalException;

	/**
	 * Will perform anonymization on all entities of type {@code T} related
	 * to a user. This method is responsible to retrieve all the relevant
	 * entities, perform anonymization, and persist the changes.
	 *
	 * @param userId the primary key of the user whose data is being anonymized
	 * @param anonymousUser the company's anonymous user
	 * @throws PortalException if the persistence throws an exception
	 * @review
	 */
	public void autoAnonymizeAll(long userId, User anonymousUser)
		throws PortalException;

	/**
	 * Returns the number of entities of type {@code T} associated with a user.
	 *
	 * @param userId the primary key of the user whose data to count
	 * @return the number of entities associated with the user
	 * @review
	 */
	public long count(long userId) throws PortalException;

	/**
	 * Deletes the entity from the database.
	 *
	 * @param t the entity to be deleted
	 * @throws PortalException
	 * @review
	 */
	public void delete(T t) throws PortalException;

	/**
	 * Deletes from the database all the entities of type {@code T} related to
	 * a user.
	 *
	 * @param userId the primary key of the user whose data to delete
	 * @throws PortalException
	 * @review
	 */
	public void deleteAll(long userId) throws PortalException;

}