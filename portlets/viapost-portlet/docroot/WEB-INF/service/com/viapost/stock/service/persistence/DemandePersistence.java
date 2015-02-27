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

import com.viapost.stock.model.Demande;

/**
 * The persistence interface for the demande service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pif
 * @see DemandePersistenceImpl
 * @see DemandeUtil
 * @generated
 */
public interface DemandePersistence extends BasePersistence<Demande> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DemandeUtil} to access the demande persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the demande where question = &#63; or throws a {@link com.viapost.stock.NoSuchDemandeException} if it could not be found.
	*
	* @param question the question
	* @return the matching demande
	* @throws com.viapost.stock.NoSuchDemandeException if a matching demande could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.Demande findByQuestion(
		java.lang.String question)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchDemandeException;

	/**
	* Returns the demande where question = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param question the question
	* @return the matching demande, or <code>null</code> if a matching demande could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.Demande fetchByQuestion(
		java.lang.String question)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the demande where question = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param question the question
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching demande, or <code>null</code> if a matching demande could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.Demande fetchByQuestion(
		java.lang.String question, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the demande where question = &#63; from the database.
	*
	* @param question the question
	* @return the demande that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.Demande removeByQuestion(
		java.lang.String question)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchDemandeException;

	/**
	* Returns the number of demandes where question = &#63;.
	*
	* @param question the question
	* @return the number of matching demandes
	* @throws SystemException if a system exception occurred
	*/
	public int countByQuestion(java.lang.String question)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the demande in the entity cache if it is enabled.
	*
	* @param demande the demande
	*/
	public void cacheResult(com.viapost.stock.model.Demande demande);

	/**
	* Caches the demandes in the entity cache if it is enabled.
	*
	* @param demandes the demandes
	*/
	public void cacheResult(
		java.util.List<com.viapost.stock.model.Demande> demandes);

	/**
	* Creates a new demande with the primary key. Does not add the demande to the database.
	*
	* @param demandeId the primary key for the new demande
	* @return the new demande
	*/
	public com.viapost.stock.model.Demande create(long demandeId);

	/**
	* Removes the demande with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param demandeId the primary key of the demande
	* @return the demande that was removed
	* @throws com.viapost.stock.NoSuchDemandeException if a demande with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.Demande remove(long demandeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchDemandeException;

	public com.viapost.stock.model.Demande updateImpl(
		com.viapost.stock.model.Demande demande)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the demande with the primary key or throws a {@link com.viapost.stock.NoSuchDemandeException} if it could not be found.
	*
	* @param demandeId the primary key of the demande
	* @return the demande
	* @throws com.viapost.stock.NoSuchDemandeException if a demande with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.Demande findByPrimaryKey(long demandeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchDemandeException;

	/**
	* Returns the demande with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param demandeId the primary key of the demande
	* @return the demande, or <code>null</code> if a demande with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.Demande fetchByPrimaryKey(long demandeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the demandes.
	*
	* @return the demandes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viapost.stock.model.Demande> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viapost.stock.model.Demande> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.viapost.stock.model.Demande> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the demandes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of demandes.
	*
	* @return the number of demandes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}