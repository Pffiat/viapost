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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.viapost.stock.model.UserDemande;

import java.util.List;

/**
 * The persistence utility for the user demande service. This utility wraps {@link UserDemandePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pif
 * @see UserDemandePersistence
 * @see UserDemandePersistenceImpl
 * @generated
 */
public class UserDemandeUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(UserDemande userDemande) {
		getPersistence().clearCache(userDemande);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserDemande> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserDemande> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserDemande> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static UserDemande update(UserDemande userDemande)
		throws SystemException {
		return getPersistence().update(userDemande);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static UserDemande update(UserDemande userDemande,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(userDemande, serviceContext);
	}

	/**
	* Returns all the user demandes where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching user demandes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viapost.stock.model.UserDemande> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

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
	public static java.util.List<com.viapost.stock.model.UserDemande> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

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
	public static java.util.List<com.viapost.stock.model.UserDemande> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first user demande in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user demande
	* @throws com.viapost.stock.NoSuchUserDemandeException if a matching user demande could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viapost.stock.model.UserDemande findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchUserDemandeException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first user demande in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user demande, or <code>null</code> if a matching user demande could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viapost.stock.model.UserDemande fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last user demande in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user demande
	* @throws com.viapost.stock.NoSuchUserDemandeException if a matching user demande could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viapost.stock.model.UserDemande findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchUserDemandeException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last user demande in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user demande, or <code>null</code> if a matching user demande could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viapost.stock.model.UserDemande fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

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
	public static com.viapost.stock.model.UserDemande[] findByUserId_PrevAndNext(
		long userDemandeId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchUserDemandeException {
		return getPersistence()
				   .findByUserId_PrevAndNext(userDemandeId, userId,
			orderByComparator);
	}

	/**
	* Removes all the user demandes where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of user demandes where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user demandes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns all the user demandes where resourcePrimaryKey = &#63; and status = &#63;.
	*
	* @param resourcePrimaryKey the resource primary key
	* @param status the status
	* @return the matching user demandes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viapost.stock.model.UserDemande> findByResourceAndStatus(
		long resourcePrimaryKey, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResourceAndStatus(resourcePrimaryKey, status);
	}

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
	public static java.util.List<com.viapost.stock.model.UserDemande> findByResourceAndStatus(
		long resourcePrimaryKey, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResourceAndStatus(resourcePrimaryKey, status, start,
			end);
	}

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
	public static java.util.List<com.viapost.stock.model.UserDemande> findByResourceAndStatus(
		long resourcePrimaryKey, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResourceAndStatus(resourcePrimaryKey, status, start,
			end, orderByComparator);
	}

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
	public static com.viapost.stock.model.UserDemande findByResourceAndStatus_First(
		long resourcePrimaryKey, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchUserDemandeException {
		return getPersistence()
				   .findByResourceAndStatus_First(resourcePrimaryKey, status,
			orderByComparator);
	}

	/**
	* Returns the first user demande in the ordered set where resourcePrimaryKey = &#63; and status = &#63;.
	*
	* @param resourcePrimaryKey the resource primary key
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user demande, or <code>null</code> if a matching user demande could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viapost.stock.model.UserDemande fetchByResourceAndStatus_First(
		long resourcePrimaryKey, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResourceAndStatus_First(resourcePrimaryKey, status,
			orderByComparator);
	}

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
	public static com.viapost.stock.model.UserDemande findByResourceAndStatus_Last(
		long resourcePrimaryKey, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchUserDemandeException {
		return getPersistence()
				   .findByResourceAndStatus_Last(resourcePrimaryKey, status,
			orderByComparator);
	}

	/**
	* Returns the last user demande in the ordered set where resourcePrimaryKey = &#63; and status = &#63;.
	*
	* @param resourcePrimaryKey the resource primary key
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user demande, or <code>null</code> if a matching user demande could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viapost.stock.model.UserDemande fetchByResourceAndStatus_Last(
		long resourcePrimaryKey, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResourceAndStatus_Last(resourcePrimaryKey, status,
			orderByComparator);
	}

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
	public static com.viapost.stock.model.UserDemande[] findByResourceAndStatus_PrevAndNext(
		long userDemandeId, long resourcePrimaryKey, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchUserDemandeException {
		return getPersistence()
				   .findByResourceAndStatus_PrevAndNext(userDemandeId,
			resourcePrimaryKey, status, orderByComparator);
	}

	/**
	* Removes all the user demandes where resourcePrimaryKey = &#63; and status = &#63; from the database.
	*
	* @param resourcePrimaryKey the resource primary key
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByResourceAndStatus(long resourcePrimaryKey,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByResourceAndStatus(resourcePrimaryKey, status);
	}

	/**
	* Returns the number of user demandes where resourcePrimaryKey = &#63; and status = &#63;.
	*
	* @param resourcePrimaryKey the resource primary key
	* @param status the status
	* @return the number of matching user demandes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByResourceAndStatus(long resourcePrimaryKey,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByResourceAndStatus(resourcePrimaryKey, status);
	}

	/**
	* Caches the user demande in the entity cache if it is enabled.
	*
	* @param userDemande the user demande
	*/
	public static void cacheResult(
		com.viapost.stock.model.UserDemande userDemande) {
		getPersistence().cacheResult(userDemande);
	}

	/**
	* Caches the user demandes in the entity cache if it is enabled.
	*
	* @param userDemandes the user demandes
	*/
	public static void cacheResult(
		java.util.List<com.viapost.stock.model.UserDemande> userDemandes) {
		getPersistence().cacheResult(userDemandes);
	}

	/**
	* Creates a new user demande with the primary key. Does not add the user demande to the database.
	*
	* @param userDemandeId the primary key for the new user demande
	* @return the new user demande
	*/
	public static com.viapost.stock.model.UserDemande create(long userDemandeId) {
		return getPersistence().create(userDemandeId);
	}

	/**
	* Removes the user demande with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userDemandeId the primary key of the user demande
	* @return the user demande that was removed
	* @throws com.viapost.stock.NoSuchUserDemandeException if a user demande with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viapost.stock.model.UserDemande remove(long userDemandeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchUserDemandeException {
		return getPersistence().remove(userDemandeId);
	}

	public static com.viapost.stock.model.UserDemande updateImpl(
		com.viapost.stock.model.UserDemande userDemande)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userDemande);
	}

	/**
	* Returns the user demande with the primary key or throws a {@link com.viapost.stock.NoSuchUserDemandeException} if it could not be found.
	*
	* @param userDemandeId the primary key of the user demande
	* @return the user demande
	* @throws com.viapost.stock.NoSuchUserDemandeException if a user demande with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viapost.stock.model.UserDemande findByPrimaryKey(
		long userDemandeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchUserDemandeException {
		return getPersistence().findByPrimaryKey(userDemandeId);
	}

	/**
	* Returns the user demande with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userDemandeId the primary key of the user demande
	* @return the user demande, or <code>null</code> if a user demande with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viapost.stock.model.UserDemande fetchByPrimaryKey(
		long userDemandeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userDemandeId);
	}

	/**
	* Returns all the user demandes.
	*
	* @return the user demandes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viapost.stock.model.UserDemande> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.viapost.stock.model.UserDemande> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.viapost.stock.model.UserDemande> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user demandes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user demandes.
	*
	* @return the number of user demandes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserDemandePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserDemandePersistence)PortletBeanLocatorUtil.locate(com.viapost.stock.service.ClpSerializer.getServletContextName(),
					UserDemandePersistence.class.getName());

			ReferenceRegistry.registerReference(UserDemandeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UserDemandePersistence persistence) {
	}

	private static UserDemandePersistence _persistence;
}