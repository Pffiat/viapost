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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.viapost.stock.service.ClpSerializer;
import com.viapost.stock.service.UserDemandeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pif
 */
public class UserDemandeClp extends BaseModelImpl<UserDemande>
	implements UserDemande {
	public UserDemandeClp() {
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
	public long getPrimaryKey() {
		return _userDemandeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserDemandeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userDemandeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getUserDemandeId() {
		return _userDemandeId;
	}

	@Override
	public void setUserDemandeId(long userDemandeId) {
		_userDemandeId = userDemandeId;

		if (_userDemandeRemoteModel != null) {
			try {
				Class<?> clazz = _userDemandeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserDemandeId", long.class);

				method.invoke(_userDemandeRemoteModel, userDemandeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDemandeId() {
		return _demandeId;
	}

	@Override
	public void setDemandeId(long demandeId) {
		_demandeId = demandeId;

		if (_userDemandeRemoteModel != null) {
			try {
				Class<?> clazz = _userDemandeRemoteModel.getClass();

				Method method = clazz.getMethod("setDemandeId", long.class);

				method.invoke(_userDemandeRemoteModel, demandeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_userDemandeRemoteModel != null) {
			try {
				Class<?> clazz = _userDemandeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_userDemandeRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_userDemandeRemoteModel != null) {
			try {
				Class<?> clazz = _userDemandeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_userDemandeRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_userDemandeRemoteModel != null) {
			try {
				Class<?> clazz = _userDemandeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_userDemandeRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDate() {
		return _date;
	}

	@Override
	public void setDate(Date date) {
		_date = date;

		if (_userDemandeRemoteModel != null) {
			try {
				Class<?> clazz = _userDemandeRemoteModel.getClass();

				Method method = clazz.getMethod("setDate", Date.class);

				method.invoke(_userDemandeRemoteModel, date);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOrigine() {
		return _origine;
	}

	@Override
	public void setOrigine(String origine) {
		_origine = origine;

		if (_userDemandeRemoteModel != null) {
			try {
				Class<?> clazz = _userDemandeRemoteModel.getClass();

				Method method = clazz.getMethod("setOrigine", String.class);

				method.invoke(_userDemandeRemoteModel, origine);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getArticle() {
		return _article;
	}

	@Override
	public void setArticle(long article) {
		_article = article;

		if (_userDemandeRemoteModel != null) {
			try {
				Class<?> clazz = _userDemandeRemoteModel.getClass();

				Method method = clazz.getMethod("setArticle", long.class);

				method.invoke(_userDemandeRemoteModel, article);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getResourcePrimaryKey() {
		return _resourcePrimaryKey;
	}

	@Override
	public void setResourcePrimaryKey(long resourcePrimaryKey) {
		_resourcePrimaryKey = resourcePrimaryKey;

		if (_userDemandeRemoteModel != null) {
			try {
				Class<?> clazz = _userDemandeRemoteModel.getClass();

				Method method = clazz.getMethod("setResourcePrimaryKey",
						long.class);

				method.invoke(_userDemandeRemoteModel, resourcePrimaryKey);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_userDemandeRemoteModel != null) {
			try {
				Class<?> clazz = _userDemandeRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_userDemandeRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_userDemandeRemoteModel != null) {
			try {
				Class<?> clazz = _userDemandeRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_userDemandeRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;

		if (_userDemandeRemoteModel != null) {
			try {
				Class<?> clazz = _userDemandeRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserId", long.class);

				method.invoke(_userDemandeRemoteModel, statusByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	@Override
	public String getStatusByUserName() {
		return _statusByUserName;
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;

		if (_userDemandeRemoteModel != null) {
			try {
				Class<?> clazz = _userDemandeRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserName",
						String.class);

				method.invoke(_userDemandeRemoteModel, statusByUserName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStatusByDate() {
		return _statusByDate;
	}

	@Override
	public void setStatusByDate(Date statusByDate) {
		_statusByDate = statusByDate;

		if (_userDemandeRemoteModel != null) {
			try {
				Class<?> clazz = _userDemandeRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByDate", Date.class);

				method.invoke(_userDemandeRemoteModel, statusByDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUserDemandeRemoteModel() {
		return _userDemandeRemoteModel;
	}

	public void setUserDemandeRemoteModel(BaseModel<?> userDemandeRemoteModel) {
		_userDemandeRemoteModel = userDemandeRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _userDemandeRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_userDemandeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UserDemandeLocalServiceUtil.addUserDemande(this);
		}
		else {
			UserDemandeLocalServiceUtil.updateUserDemande(this);
		}
	}

	@Override
	public UserDemande toEscapedModel() {
		return (UserDemande)ProxyUtil.newProxyInstance(UserDemande.class.getClassLoader(),
			new Class[] { UserDemande.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UserDemandeClp clone = new UserDemandeClp();

		clone.setUserDemandeId(getUserDemandeId());
		clone.setDemandeId(getDemandeId());
		clone.setUserId(getUserId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setDate(getDate());
		clone.setOrigine(getOrigine());
		clone.setArticle(getArticle());
		clone.setResourcePrimaryKey(getResourcePrimaryKey());
		clone.setTitle(getTitle());
		clone.setStatus(getStatus());
		clone.setStatusByUserId(getStatusByUserId());
		clone.setStatusByUserName(getStatusByUserName());
		clone.setStatusByDate(getStatusByDate());

		return clone;
	}

	@Override
	public int compareTo(UserDemande userDemande) {
		long primaryKey = userDemande.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserDemandeClp)) {
			return false;
		}

		UserDemandeClp userDemande = (UserDemandeClp)obj;

		long primaryKey = userDemande.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{userDemandeId=");
		sb.append(getUserDemandeId());
		sb.append(", demandeId=");
		sb.append(getDemandeId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", date=");
		sb.append(getDate());
		sb.append(", origine=");
		sb.append(getOrigine());
		sb.append(", article=");
		sb.append(getArticle());
		sb.append(", resourcePrimaryKey=");
		sb.append(getResourcePrimaryKey());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusByDate=");
		sb.append(getStatusByDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.viapost.stock.model.UserDemande");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userDemandeId</column-name><column-value><![CDATA[");
		sb.append(getUserDemandeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>demandeId</column-name><column-value><![CDATA[");
		sb.append(getDemandeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date</column-name><column-value><![CDATA[");
		sb.append(getDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>origine</column-name><column-value><![CDATA[");
		sb.append(getOrigine());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>article</column-name><column-value><![CDATA[");
		sb.append(getArticle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resourcePrimaryKey</column-name><column-value><![CDATA[");
		sb.append(getResourcePrimaryKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByDate</column-name><column-value><![CDATA[");
		sb.append(getStatusByDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userDemandeId;
	private long _demandeId;
	private long _userId;
	private String _userUuid;
	private long _companyId;
	private long _groupId;
	private Date _date;
	private String _origine;
	private long _article;
	private long _resourcePrimaryKey;
	private String _title;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusByDate;
	private BaseModel<?> _userDemandeRemoteModel;
}