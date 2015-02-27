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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author pif
 * @generated
 */
public class DemandeSoap implements Serializable {
	public static DemandeSoap toSoapModel(Demande model) {
		DemandeSoap soapModel = new DemandeSoap();

		soapModel.setDemandeId(model.getDemandeId());
		soapModel.setQuestion(model.getQuestion());
		soapModel.setRequest(model.getRequest());

		return soapModel;
	}

	public static DemandeSoap[] toSoapModels(Demande[] models) {
		DemandeSoap[] soapModels = new DemandeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DemandeSoap[][] toSoapModels(Demande[][] models) {
		DemandeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DemandeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DemandeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DemandeSoap[] toSoapModels(List<Demande> models) {
		List<DemandeSoap> soapModels = new ArrayList<DemandeSoap>(models.size());

		for (Demande model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DemandeSoap[soapModels.size()]);
	}

	public DemandeSoap() {
	}

	public long getPrimaryKey() {
		return _demandeId;
	}

	public void setPrimaryKey(long pk) {
		setDemandeId(pk);
	}

	public long getDemandeId() {
		return _demandeId;
	}

	public void setDemandeId(long demandeId) {
		_demandeId = demandeId;
	}

	public String getQuestion() {
		return _question;
	}

	public void setQuestion(String question) {
		_question = question;
	}

	public String getRequest() {
		return _request;
	}

	public void setRequest(String request) {
		_request = request;
	}

	private long _demandeId;
	private String _question;
	private String _request;
}