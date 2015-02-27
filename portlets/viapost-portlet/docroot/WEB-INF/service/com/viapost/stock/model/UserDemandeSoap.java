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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author pif
 * @generated
 */
public class UserDemandeSoap implements Serializable {
	public static UserDemandeSoap toSoapModel(UserDemande model) {
		UserDemandeSoap soapModel = new UserDemandeSoap();

		soapModel.setUserDemandeId(model.getUserDemandeId());
		soapModel.setDemandeId(model.getDemandeId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setDate(model.getDate());
		soapModel.setOrigine(model.getOrigine());
		soapModel.setArticle(model.getArticle());
		soapModel.setResourcePrimaryKey(model.getResourcePrimaryKey());
		soapModel.setTitle(model.getTitle());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusByDate(model.getStatusByDate());

		return soapModel;
	}

	public static UserDemandeSoap[] toSoapModels(UserDemande[] models) {
		UserDemandeSoap[] soapModels = new UserDemandeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserDemandeSoap[][] toSoapModels(UserDemande[][] models) {
		UserDemandeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserDemandeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserDemandeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserDemandeSoap[] toSoapModels(List<UserDemande> models) {
		List<UserDemandeSoap> soapModels = new ArrayList<UserDemandeSoap>(models.size());

		for (UserDemande model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserDemandeSoap[soapModels.size()]);
	}

	public UserDemandeSoap() {
	}

	public long getPrimaryKey() {
		return _userDemandeId;
	}

	public void setPrimaryKey(long pk) {
		setUserDemandeId(pk);
	}

	public long getUserDemandeId() {
		return _userDemandeId;
	}

	public void setUserDemandeId(long userDemandeId) {
		_userDemandeId = userDemandeId;
	}

	public long getDemandeId() {
		return _demandeId;
	}

	public void setDemandeId(long demandeId) {
		_demandeId = demandeId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	public String getOrigine() {
		return _origine;
	}

	public void setOrigine(String origine) {
		_origine = origine;
	}

	public long getArticle() {
		return _article;
	}

	public void setArticle(long article) {
		_article = article;
	}

	public long getResourcePrimaryKey() {
		return _resourcePrimaryKey;
	}

	public void setResourcePrimaryKey(long resourcePrimaryKey) {
		_resourcePrimaryKey = resourcePrimaryKey;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusByDate() {
		return _statusByDate;
	}

	public void setStatusByDate(Date statusByDate) {
		_statusByDate = statusByDate;
	}

	private long _userDemandeId;
	private long _demandeId;
	private long _userId;
	private long _companyId;
	private long _groupId;
	private Date _date;
	private String _origine;
	private long _article;
	private long _resourcePrimaryKey;
	private String _title;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusByDate;
}