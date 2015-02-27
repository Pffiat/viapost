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

import com.viapost.stock.model.Demande;

import java.util.List;

/**
 * The persistence utility for the demande service. This utility wraps {@link DemandePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pif
 * @see DemandePersistence
 * @see DemandePersistenceImpl
 * @generated
 */
public class DemandeUtil {
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
	public static void clearCache(Demande demande) {
		getPersistence().clearCache(demande);
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
	public static List<Demande> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Demande> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Demande> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Demande update(Demande demande) throws SystemException {
		return getPersistence().update(demande);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Demande update(Demande demande, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(demande, serviceContext);
	}

	/**
	* Returns the demande where question = &#63; or throws a {@link com.viapost.stock.NoSuchDemandeException} if it could not be found.
	*
	* @param question the question
	* @return the matching demande
	* @throws com.viapost.stock.NoSuchDemandeException if a matching demande could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viapost.stock.model.Demande findByQuestion(
		java.lang.String question)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchDemandeException {
		return getPersistence().findByQuestion(question);
	}

	/**
	* Returns the demande where question = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param question the question
	* @return the matching demande, or <code>null</code> if a matching demande could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viapost.stock.model.Demande fetchByQuestion(
		java.lang.String question)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByQuestion(question);
	}

	/**
	* Returns the demande where question = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param question the question
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching demande, or <code>null</code> if a matching demande could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viapost.stock.model.Demande fetchByQuestion(
		java.lang.String question, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByQuestion(question, retrieveFromCache);
	}

	/**
	* Removes the demande where question = &#63; from the database.
	*
	* @param question the question
	* @return the demande that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.viapost.stock.model.Demande removeByQuestion(
		java.lang.String question)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchDemandeException {
		return getPersistence().removeByQuestion(question);
	}

	/**
	* Returns the number of demandes where question = &#63;.
	*
	* @param question the question
	* @return the number of matching demandes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByQuestion(java.lang.String question)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByQuestion(question);
	}

	/**
	* Caches the demande in the entity cache if it is enabled.
	*
	* @param demande the demande
	*/
	public static void cacheResult(com.viapost.stock.model.Demande demande) {
		getPersistence().cacheResult(demande);
	}

	/**
	* Caches the demandes in the entity cache if it is enabled.
	*
	* @param demandes the demandes
	*/
	public static void cacheResult(
		java.util.List<com.viapost.stock.model.Demande> demandes) {
		getPersistence().cacheResult(demandes);
	}

	/**
	* Creates a new demande with the primary key. Does not add the demande to the database.
	*
	* @param demandeId the primary key for the new demande
	* @return the new demande
	*/
	public static com.viapost.stock.model.Demande create(long demandeId) {
		return getPersistence().create(demandeId);
	}

	/**
	* Removes the demande with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param demandeId the primary key of the demande
	* @return the demande that was removed
	* @throws com.viapost.stock.NoSuchDemandeException if a demande with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viapost.stock.model.Demande remove(long demandeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchDemandeException {
		return getPersistence().remove(demandeId);
	}

	public static com.viapost.stock.model.Demande updateImpl(
		com.viapost.stock.model.Demande demande)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(demande);
	}

	/**
	* Returns the demande with the primary key or throws a {@link com.viapost.stock.NoSuchDemandeException} if it could not be found.
	*
	* @param demandeId the primary key of the demande
	* @return the demande
	* @throws com.viapost.stock.NoSuchDemandeException if a demande with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viapost.stock.model.Demande findByPrimaryKey(
		long demandeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchDemandeException {
		return getPersistence().findByPrimaryKey(demandeId);
	}

	/**
	* Returns the demande with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param demandeId the primary key of the demande
	* @return the demande, or <code>null</code> if a demande with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.viapost.stock.model.Demande fetchByPrimaryKey(
		long demandeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(demandeId);
	}

	/**
	* Returns all the demandes.
	*
	* @return the demandes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viapost.stock.model.Demande> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the demandes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.DemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of demandes
	* @param end the upper bound of the range of demandes (not inclusive)
	* @return the range of demandes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viapost.stock.model.Demande> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the demandes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.DemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of demandes
	* @param end the upper bound of the range of demandes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of demandes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.viapost.stock.model.Demande> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the demandes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of demandes.
	*
	* @return the number of demandes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DemandePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DemandePersistence)PortletBeanLocatorUtil.locate(com.viapost.stock.service.ClpSerializer.getServletContextName(),
					DemandePersistence.class.getName());

			ReferenceRegistry.registerReference(DemandeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DemandePersistence persistence) {
	}

	private static DemandePersistence _persistence;
}