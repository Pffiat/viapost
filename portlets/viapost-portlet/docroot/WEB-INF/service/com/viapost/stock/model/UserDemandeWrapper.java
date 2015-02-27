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

package com.viapost.stock.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserDemande}.
 * </p>
 *
 * @author pif
 * @see UserDemande
 * @generated
 */
public class UserDemandeWrapper implements UserDemande,
	ModelWrapper<UserDemande> {
	public UserDemandeWrapper(UserDemande userDemande) {
		_userDemande = userDemande;
	}

	@Override
	public Class<?> getModelClass() {
		return UserDemande.class;
	}

	@Override
	public String getModelClassName() {
		return UserDemande.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userDemandeId", getUserDemandeId());
		attributes.put("demandeId", getDemandeId());
		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("date", getDate());
		attributes.put("origine", getOrigine());
		attributes.put("article", getArticle());
		attributes.put("resourcePrimaryKey", getResourcePrimaryKey());
		attributes.put("title", getTitle());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusByDate", getStatusByDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userDemandeId = (Long)attributes.get("userDemandeId");

		if (userDemandeId != null) {
			setUserDemandeId(userDemandeId);
		}

		Long demandeId = (Long)attributes.get("demandeId");

		if (demandeId != null) {
			setDemandeId(demandeId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		String origine = (String)attributes.get("origine");

		if (origine != null) {
			setOrigine(origine);
		}

		Long article = (Long)attributes.get("article");

		if (article != null) {
			setArticle(article);
		}

		Long resourcePrimaryKey = (Long)attributes.get("resourcePrimaryKey");

		if (resourcePrimaryKey != null) {
			setResourcePrimaryKey(resourcePrimaryKey);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusByDate = (Date)attributes.get("statusByDate");

		if (statusByDate != null) {
			setStatusByDate(statusByDate);
		}
	}

	/**
	* Returns the primary key of this user demande.
	*
	* @return the primary key of this user demande
	*/
	@Override
	public long getPrimaryKey() {
		return _userDemande.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user demande.
	*
	* @param primaryKey the primary key of this user demande
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userDemande.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user demande ID of this user demande.
	*
	* @return the user demande ID of this user demande
	*/
	@Override
	public long getUserDemandeId() {
		return _userDemande.getUserDemandeId();
	}

	/**
	* Sets the user demande ID of this user demande.
	*
	* @param userDemandeId the user demande ID of this user demande
	*/
	@Override
	public void setUserDemandeId(long userDemandeId) {
		_userDemande.setUserDemandeId(userDemandeId);
	}

	/**
	* Returns the demande ID of this user demande.
	*
	* @return the demande ID of this user demande
	*/
	@Override
	public long getDemandeId() {
		return _userDemande.getDemandeId();
	}

	/**
	* Sets the demande ID of this user demande.
	*
	* @param demandeId the demande ID of this user demande
	*/
	@Override
	public void setDemandeId(long demandeId) {
		_userDemande.setDemandeId(demandeId);
	}

	/**
	* Returns the user ID of this user demande.
	*
	* @return the user ID of this user demande
	*/
	@Override
	public long getUserId() {
		return _userDemande.getUserId();
	}

	/**
	* Sets the user ID of this user demande.
	*
	* @param userId the user ID of this user demande
	*/
	@Override
	public void setUserId(long userId) {
		_userDemande.setUserId(userId);
	}

	/**
	* Returns the user uuid of this user demande.
	*
	* @return the user uuid of this user demande
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userDemande.getUserUuid();
	}

	/**
	* Sets the user uuid of this user demande.
	*
	* @param userUuid the user uuid of this user demande
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userDemande.setUserUuid(userUuid);
	}

	/**
	* Returns the company ID of this user demande.
	*
	* @return the company ID of this user demande
	*/
	@Override
	public long getCompanyId() {
		return _userDemande.getCompanyId();
	}

	/**
	* Sets the company ID of this user demande.
	*
	* @param companyId the company ID of this user demande
	*/
	@Override
	public void setCompanyId(long companyId) {
		_userDemande.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this user demande.
	*
	* @return the group ID of this user demande
	*/
	@Override
	public long getGroupId() {
		return _userDemande.getGroupId();
	}

	/**
	* Sets the group ID of this user demande.
	*
	* @param groupId the group ID of this user demande
	*/
	@Override
	public void setGroupId(long groupId) {
		_userDemande.setGroupId(groupId);
	}

	/**
	* Returns the date of this user demande.
	*
	* @return the date of this user demande
	*/
	@Override
	public java.util.Date getDate() {
		return _userDemande.getDate();
	}

	/**
	* Sets the date of this user demande.
	*
	* @param date the date of this user demande
	*/
	@Override
	public void setDate(java.util.Date date) {
		_userDemande.setDate(date);
	}

	/**
	* Returns the origine of this user demande.
	*
	* @return the origine of this user demande
	*/
	@Override
	public java.lang.String getOrigine() {
		return _userDemande.getOrigine();
	}

	/**
	* Sets the origine of this user demande.
	*
	* @param origine the origine of this user demande
	*/
	@Override
	public void setOrigine(java.lang.String origine) {
		_userDemande.setOrigine(origine);
	}

	/**
	* Returns the article of this user demande.
	*
	* @return the article of this user demande
	*/
	@Override
	public long getArticle() {
		return _userDemande.getArticle();
	}

	/**
	* Sets the article of this user demande.
	*
	* @param article the article of this user demande
	*/
	@Override
	public void setArticle(long article) {
		_userDemande.setArticle(article);
	}

	/**
	* Returns the resource primary key of this user demande.
	*
	* @return the resource primary key of this user demande
	*/
	@Override
	public long getResourcePrimaryKey() {
		return _userDemande.getResourcePrimaryKey();
	}

	/**
	* Sets the resource primary key of this user demande.
	*
	* @param resourcePrimaryKey the resource primary key of this user demande
	*/
	@Override
	public void setResourcePrimaryKey(long resourcePrimaryKey) {
		_userDemande.setResourcePrimaryKey(resourcePrimaryKey);
	}

	/**
	* Returns the title of this user demande.
	*
	* @return the title of this user demande
	*/
	@Override
	public java.lang.String getTitle() {
		return _userDemande.getTitle();
	}

	/**
	* Sets the title of this user demande.
	*
	* @param title the title of this user demande
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_userDemande.setTitle(title);
	}

	/**
	* Returns the status of this user demande.
	*
	* @return the status of this user demande
	*/
	@Override
	public int getStatus() {
		return _userDemande.getStatus();
	}

	/**
	* Sets the status of this user demande.
	*
	* @param status the status of this user demande
	*/
	@Override
	public void setStatus(int status) {
		_userDemande.setStatus(status);
	}

	/**
	* Returns the status by user ID of this user demande.
	*
	* @return the status by user ID of this user demande
	*/
	@Override
	public long getStatusByUserId() {
		return _userDemande.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this user demande.
	*
	* @param statusByUserId the status by user ID of this user demande
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_userDemande.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this user demande.
	*
	* @return the status by user uuid of this user demande
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userDemande.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this user demande.
	*
	* @param statusByUserUuid the status by user uuid of this user demande
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_userDemande.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this user demande.
	*
	* @return the status by user name of this user demande
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _userDemande.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this user demande.
	*
	* @param statusByUserName the status by user name of this user demande
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_userDemande.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status by date of this user demande.
	*
	* @return the status by date of this user demande
	*/
	@Override
	public java.util.Date getStatusByDate() {
		return _userDemande.getStatusByDate();
	}

	/**
	* Sets the status by date of this user demande.
	*
	* @param statusByDate the status by date of this user demande
	*/
	@Override
	public void setStatusByDate(java.util.Date statusByDate) {
		_userDemande.setStatusByDate(statusByDate);
	}

	@Override
	public boolean isNew() {
		return _userDemande.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_userDemande.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _userDemande.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userDemande.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _userDemande.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _userDemande.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userDemande.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userDemande.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_userDemande.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_userDemande.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userDemande.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserDemandeWrapper((UserDemande)_userDemande.clone());
	}

	@Override
	public int compareTo(com.viapost.stock.model.UserDemande userDemande) {
		return _userDemande.compareTo(userDemande);
	}

	@Override
	public int hashCode() {
		return _userDemande.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viapost.stock.model.UserDemande> toCacheModel() {
		return _userDemande.toCacheModel();
	}

	@Override
	public com.viapost.stock.model.UserDemande toEscapedModel() {
		return new UserDemandeWrapper(_userDemande.toEscapedModel());
	}

	@Override
	public com.viapost.stock.model.UserDemande toUnescapedModel() {
		return new UserDemandeWrapper(_userDemande.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userDemande.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userDemande.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userDemande.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserDemandeWrapper)) {
			return false;
		}

		UserDemandeWrapper userDemandeWrapper = (UserDemandeWrapper)obj;

		if (Validator.equals(_userDemande, userDemandeWrapper._userDemande)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UserDemande getWrappedUserDemande() {
		return _userDemande;
	}

	@Override
	public UserDemande getWrappedModel() {
		return _userDemande;
	}

	@Override
	public void resetOriginalValues() {
		_userDemande.resetOriginalValues();
	}

	private UserDemande _userDemande;
}