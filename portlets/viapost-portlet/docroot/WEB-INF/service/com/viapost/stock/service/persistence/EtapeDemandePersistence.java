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

import com.viapost.stock.model.EtapeDemande;

/**
 * The persistence interface for the etape demande service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pif
 * @see EtapeDemandePersistenceImpl
 * @see EtapeDemandeUtil
 * @generated
 */
public interface EtapeDemandePersistence extends BasePersistence<EtapeDemande> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EtapeDemandeUtil} to access the etape demande persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the etape demandes where demandeId = &#63;.
	*
	* @param demandeId the demande ID
	* @return the matching etape demandes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viapost.stock.model.EtapeDemande> findByDemandeId(
		long demandeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the etape demandes where demandeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.EtapeDemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param demandeId the demande ID
	* @param start the lower bound of the range of etape demandes
	* @param end the upper bound of the range of etape demandes (not inclusive)
	* @return the range of matching etape demandes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viapost.stock.model.EtapeDemande> findByDemandeId(
		long demandeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the etape demandes where demandeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.EtapeDemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param demandeId the demande ID
	* @param start the lower bound of the range of etape demandes
	* @param end the upper bound of the range of etape demandes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching etape demandes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viapost.stock.model.EtapeDemande> findByDemandeId(
		long demandeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first etape demande in the ordered set where demandeId = &#63;.
	*
	* @param demandeId the demande ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching etape demande
	* @throws com.viapost.stock.NoSuchEtapeDemandeException if a matching etape demande could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.EtapeDemande findByDemandeId_First(
		long demandeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchEtapeDemandeException;

	/**
	* Returns the first etape demande in the ordered set where demandeId = &#63;.
	*
	* @param demandeId the demande ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching etape demande, or <code>null</code> if a matching etape demande could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.EtapeDemande fetchByDemandeId_First(
		long demandeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last etape demande in the ordered set where demandeId = &#63;.
	*
	* @param demandeId the demande ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching etape demande
	* @throws com.viapost.stock.NoSuchEtapeDemandeException if a matching etape demande could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.EtapeDemande findByDemandeId_Last(
		long demandeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchEtapeDemandeException;

	/**
	* Returns the last etape demande in the ordered set where demandeId = &#63;.
	*
	* @param demandeId the demande ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching etape demande, or <code>null</code> if a matching etape demande could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.EtapeDemande fetchByDemandeId_Last(
		long demandeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the etape demandes before and after the current etape demande in the ordered set where demandeId = &#63;.
	*
	* @param etapeId the primary key of the current etape demande
	* @param demandeId the demande ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next etape demande
	* @throws com.viapost.stock.NoSuchEtapeDemandeException if a etape demande with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.EtapeDemande[] findByDemandeId_PrevAndNext(
		long etapeId, long demandeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchEtapeDemandeException;

	/**
	* Removes all the etape demandes where demandeId = &#63; from the database.
	*
	* @param demandeId the demande ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDemandeId(long demandeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of etape demandes where demandeId = &#63;.
	*
	* @param demandeId the demande ID
	* @return the number of matching etape demandes
	* @throws SystemException if a system exception occurred
	*/
	public int countByDemandeId(long demandeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the etape demande in the entity cache if it is enabled.
	*
	* @param etapeDemande the etape demande
	*/
	public void cacheResult(com.viapost.stock.model.EtapeDemande etapeDemande);

	/**
	* Caches the etape demandes in the entity cache if it is enabled.
	*
	* @param etapeDemandes the etape demandes
	*/
	public void cacheResult(
		java.util.List<com.viapost.stock.model.EtapeDemande> etapeDemandes);

	/**
	* Creates a new etape demande with the primary key. Does not add the etape demande to the database.
	*
	* @param etapeId the primary key for the new etape demande
	* @return the new etape demande
	*/
	public com.viapost.stock.model.EtapeDemande create(long etapeId);

	/**
	* Removes the etape demande with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param etapeId the primary key of the etape demande
	* @return the etape demande that was removed
	* @throws com.viapost.stock.NoSuchEtapeDemandeException if a etape demande with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.EtapeDemande remove(long etapeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchEtapeDemandeException;

	public com.viapost.stock.model.EtapeDemande updateImpl(
		com.viapost.stock.model.EtapeDemande etapeDemande)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the etape demande with the primary key or throws a {@link com.viapost.stock.NoSuchEtapeDemandeException} if it could not be found.
	*
	* @param etapeId the primary key of the etape demande
	* @return the etape demande
	* @throws com.viapost.stock.NoSuchEtapeDemandeException if a etape demande with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.EtapeDemande findByPrimaryKey(long etapeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.viapost.stock.NoSuchEtapeDemandeException;

	/**
	* Returns the etape demande with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param etapeId the primary key of the etape demande
	* @return the etape demande, or <code>null</code> if a etape demande with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.viapost.stock.model.EtapeDemande fetchByPrimaryKey(long etapeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the etape demandes.
	*
	* @return the etape demandes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viapost.stock.model.EtapeDemande> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the etape demandes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.EtapeDemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of etape demandes
	* @param end the upper bound of the range of etape demandes (not inclusive)
	* @return the range of etape demandes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viapost.stock.model.EtapeDemande> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the etape demandes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.EtapeDemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of etape demandes
	* @param end the upper bound of the range of etape demandes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of etape demandes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.viapost.stock.model.EtapeDemande> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the etape demandes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of etape demandes.
	*
	* @return the number of etape demandes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}