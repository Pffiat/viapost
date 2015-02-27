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

package com.viapost.stock.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserDemandeLocalService}.
 *
 * @author pif
 * @see UserDemandeLocalService
 * @generated
 */
public class UserDemandeLocalServiceWrapper implements UserDemandeLocalService,
	ServiceWrapper<UserDemandeLocalService> {
	public UserDemandeLocalServiceWrapper(
		UserDemandeLocalService userDemandeLocalService) {
		_userDemandeLocalService = userDemandeLocalService;
	}

	/**
	* Adds the user demande to the database. Also notifies the appropriate model listeners.
	*
	* @param userDemande the user demande
	* @return the user demande that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viapost.stock.model.UserDemande addUserDemande(
		com.viapost.stock.model.UserDemande userDemande)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userDemandeLocalService.addUserDemande(userDemande);
	}

	/**
	* Creates a new user demande with the primary key. Does not add the user demande to the database.
	*
	* @param userDemandeId the primary key for the new user demande
	* @return the new user demande
	*/
	@Override
	public com.viapost.stock.model.UserDemande createUserDemande(
		long userDemandeId) {
		return _userDemandeLocalService.createUserDemande(userDemandeId);
	}

	/**
	* Deletes the user demande with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userDemandeId the primary key of the user demande
	* @return the user demande that was removed
	* @throws PortalException if a user demande with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viapost.stock.model.UserDemande deleteUserDemande(
		long userDemandeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userDemandeLocalService.deleteUserDemande(userDemandeId);
	}

	/**
	* Deletes the user demande from the database. Also notifies the appropriate model listeners.
	*
	* @param userDemande the user demande
	* @return the user demande that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viapost.stock.model.UserDemande deleteUserDemande(
		com.viapost.stock.model.UserDemande userDemande)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userDemandeLocalService.deleteUserDemande(userDemande);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userDemandeLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userDemandeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.UserDemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _userDemandeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viapost.stock.model.impl.UserDemandeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userDemandeLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userDemandeLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userDemandeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.viapost.stock.model.UserDemande fetchUserDemande(
		long userDemandeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userDemandeLocalService.fetchUserDemande(userDemandeId);
	}

	/**
	* Returns the user demande with the primary key.
	*
	* @param userDemandeId the primary key of the user demande
	* @return the user demande
	* @throws PortalException if a user demande with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viapost.stock.model.UserDemande getUserDemande(
		long userDemandeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userDemandeLocalService.getUserDemande(userDemandeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userDemandeLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.viapost.stock.model.UserDemande> getUserDemandes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userDemandeLocalService.getUserDemandes(start, end);
	}

	/**
	* Returns the number of user demandes.
	*
	* @return the number of user demandes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getUserDemandesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userDemandeLocalService.getUserDemandesCount();
	}

	/**
	* Updates the user demande in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userDemande the user demande
	* @return the user demande that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.viapost.stock.model.UserDemande updateUserDemande(
		com.viapost.stock.model.UserDemande userDemande)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userDemandeLocalService.updateUserDemande(userDemande);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _userDemandeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userDemandeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userDemandeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.viapost.stock.model.UserDemande addUserDemande(
		javax.portlet.ActionRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userDemandeLocalService.addUserDemande(request);
	}

	@Override
	public java.util.List<com.viapost.stock.model.UserDemande> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _userDemandeLocalService.findByUserId(userId);
	}

	@Override
	public com.viapost.stock.model.UserDemande updateStatus(long userId,
		long resourcePrimaryKey, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userDemandeLocalService.updateStatus(userId,
			resourcePrimaryKey, status, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UserDemandeLocalService getWrappedUserDemandeLocalService() {
		return _userDemandeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUserDemandeLocalService(
		UserDemandeLocalService userDemandeLocalService) {
		_userDemandeLocalService = userDemandeLocalService;
	}

	@Override
	public UserDemandeLocalService getWrappedService() {
		return _userDemandeLocalService;
	}

	@Override
	public void setWrappedService(
		UserDemandeLocalService userDemandeLocalService) {
		_userDemandeLocalService = userDemandeLocalService;
	}

	private UserDemandeLocalService _userDemandeLocalService;
}