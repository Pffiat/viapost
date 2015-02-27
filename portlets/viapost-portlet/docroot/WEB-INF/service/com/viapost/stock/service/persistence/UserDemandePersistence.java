/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.viapost.stock.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.viapost.stock.model.UserDemande;

/**
 * The persistence interface for the user demande service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pif
 * @see UserDemandePersistenceImpl
 * @see UserDemandeUtil
 * @generated
 */
public interface UserDemandePersistence extends BasePersistence<UserDemande> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserDemandeUtil} to access the user demande persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the user demandes where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching user demandes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viapost.stock.model.UserDemande> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user demandes where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.UserDemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of user demandes
	* @param end the upper bound of the range of user demandes (not inclusive)
	* @return the range of matching user demandes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viapost.stock.model.UserDemande> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user demandes where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.UserDemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of user demandes
	* @param end the upper bound of the range of user demandes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user demandes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viapost.stock.model.UserDemande> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user demande in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user demande
	* @throws com.viapost.stock.NoSuchUserDemandeException if a matching user demande could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.UserDemande findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchUserDemandeException;

	/**
	* Returns the first user demande in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user demande, or <code>null</code> if a matching user demande could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.UserDemande fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user demande in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user demande
	* @throws com.viapost.stock.NoSuchUserDemandeException if a matching user demande could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.UserDemande findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchUserDemandeException;

	/**
	* Returns the last user demande in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user demande, or <code>null</code> if a matching user demande could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.UserDemande fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user demandes before and after the current user demande in the ordered set where userId = &#63;.
	*
	* @param userDemandeId the primary key of the current user demande
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user demande
	* @throws com.viapost.stock.NoSuchUserDemandeException if a user demande with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.UserDemande[] findByUserId_PrevAndNext(
		long userDemandeId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchUserDemandeException;

	/**
	* Removes all the user demandes where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user demandes where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user demandes
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user demandes where resourcePrimaryKey = &#63; and status = &#63;.
	*
	* @param resourcePrimaryKey the resource primary key
	* @param status the status
	* @return the matching user demandes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viapost.stock.model.UserDemande> findByResourceAndStatus(
		long resourcePrimaryKey, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user demandes where resourcePrimaryKey = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.UserDemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param resourcePrimaryKey the resource primary key
	* @param status the status
	* @param start the lower bound of the range of user demandes
	* @param end the upper bound of the range of user demandes (not inclusive)
	* @return the range of matching user demandes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viapost.stock.model.UserDemande> findByResourceAndStatus(
		long resourcePrimaryKey, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user demandes where resourcePrimaryKey = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.UserDemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param resourcePrimaryKey the resource primary key
	* @param status the status
	* @param start the lower bound of the range of user demandes
	* @param end the upper bound of the range of user demandes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user demandes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viapost.stock.model.UserDemande> findByResourceAndStatus(
		long resourcePrimaryKey, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user demande in the ordered set where resourcePrimaryKey = &#63; and status = &#63;.
	*
	* @param resourcePrimaryKey the resource primary key
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user demande
	* @throws com.viapost.stock.NoSuchUserDemandeException if a matching user demande could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.UserDemande findByResourceAndStatus_First(
		long resourcePrimaryKey, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchUserDemandeException;

	/**
	* Returns the first user demande in the ordered set where resourcePrimaryKey = &#63; and status = &#63;.
	*
	* @param resourcePrimaryKey the resource primary key
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user demande, or <code>null</code> if a matching user demande could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.UserDemande fetchByResourceAndStatus_First(
		long resourcePrimaryKey, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user demande in the ordered set where resourcePrimaryKey = &#63; and status = &#63;.
	*
	* @param resourcePrimaryKey the resource primary key
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user demande
	* @throws com.viapost.stock.NoSuchUserDemandeException if a matching user demande could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.UserDemande findByResourceAndStatus_Last(
		long resourcePrimaryKey, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchUserDemandeException;

	/**
	* Returns the last user demande in the ordered set where resourcePrimaryKey = &#63; and status = &#63;.
	*
	* @param resourcePrimaryKey the resource primary key
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user demande, or <code>null</code> if a matching user demande could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.UserDemande fetchByResourceAndStatus_Last(
		long resourcePrimaryKey, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user demandes before and after the current user demande in the ordered set where resourcePrimaryKey = &#63; and status = &#63;.
	*
	* @param userDemandeId the primary key of the current user demande
	* @param resourcePrimaryKey the resource primary key
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user demande
	* @throws com.viapost.stock.NoSuchUserDemandeException if a user demande with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.UserDemande[] findByResourceAndStatus_PrevAndNext(
		long userDemandeId, long resourcePrimaryKey, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchUserDemandeException;

	/**
	* Removes all the user demandes where resourcePrimaryKey = &#63; and status = &#63; from the database.
	*
	* @param resourcePrimaryKey the resource primary key
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByResourceAndStatus(long resourcePrimaryKey, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user demandes where resourcePrimaryKey = &#63; and status = &#63;.
	*
	* @param resourcePrimaryKey the resource primary key
	* @param status the status
	* @return the number of matching user demandes
	* @throws SystemException if a system exception occurred
	*/
	public int countByResourceAndStatus(long resourcePrimaryKey, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the user demande in the entity cache if it is enabled.
	*
	* @param userDemande the user demande
	*/
	public void cacheResult(com.viapost.stock.model.UserDemande userDemande);

	/**
	* Caches the user demandes in the entity cache if it is enabled.
	*
	* @param userDemandes the user demandes
	*/
	public void cacheResult(
		java.util.List<com.viapost.stock.model.UserDemande> userDemandes);

	/**
	* Creates a new user demande with the primary key. Does not add the user demande to the database.
	*
	* @param userDemandeId the primary key for the new user demande
	* @return the new user demande
	*/
	public com.viapost.stock.model.UserDemande create(long userDemandeId);

	/**
	* Removes the user demande with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userDemandeId the primary key of the user demande
	* @return the user demande that was removed
	* @throws com.viapost.stock.NoSuchUserDemandeException if a user demande with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.UserDemande remove(long userDemandeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchUserDemandeException;

	public com.viapost.stock.model.UserDemande updateImpl(
		com.viapost.stock.model.UserDemande userDemande)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user demande with the primary key or throws a {@link com.viapost.stock.NoSuchUserDemandeException} if it could not be found.
	*
	* @param userDemandeId the primary key of the user demande
	* @return the user demande
	* @throws com.viapost.stock.NoSuchUserDemandeException if a user demande with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.UserDemande findByPrimaryKey(
		long userDemandeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchUserDemandeException;

	/**
	* Returns the user demande with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userDemandeId the primary key of the user demande
	* @return the user demande, or <code>null</code> if a user demande with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.UserDemande fetchByPrimaryKey(
		long userDemandeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user demandes.
	*
	* @return the user demandes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viapost.stock.model.UserDemande> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user demandes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.UserDemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user demandes
	* @param end the upper bound of the range of user demandes (not inclusive)
	* @return the range of user demandes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viapost.stock.model.UserDemande> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user demandes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.UserDemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user demandes
	* @param end the upper bound of the range of user demandes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user demandes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viapost.stock.model.UserDemande> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user demandes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user demandes.
	*
	* @return the number of user demandes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}