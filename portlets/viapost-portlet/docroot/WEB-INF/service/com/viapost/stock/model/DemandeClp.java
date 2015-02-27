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

import com.viapost.stock.service.ClpSerializer;
import com.viapost.stock.service.DemandeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pif
 */
public class DemandeClp extends BaseModelImpl<Demande> implements Demande {
	public DemandeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Demande.class;
	}

	@Override
	public String getModelClassName() {
		return Demande.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _demandeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDemandeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _demandeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("demandeId", getDemandeId());
		attributes.put("question", getQuestion());
		attributes.put("request", getRequest());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long demandeId = (Long)attributes.get("demandeId");

		if (demandeId != null) {
			setDemandeId(demandeId);
		}

		String question = (String)attributes.get("question");

		if (question != null) {
			setQuestion(question);
		}

		String request = (String)attributes.get("request");

		if (request != null) {
			setRequest(request);
		}
	}

	@Override
	public long getDemandeId() {
		return _demandeId;
	}

	@Override
	public void setDemandeId(long demandeId) {
		_demandeId = demandeId;

		if (_demandeRemoteModel != null) {
			try {
				Class<?> clazz = _demandeRemoteModel.getClass();

				Method method = clazz.getMethod("setDemandeId", long.class);

				method.invoke(_demandeRemoteModel, demandeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQuestion() {
		return _question;
	}

	@Override
	public void setQuestion(String question) {
		_question = question;

		if (_demandeRemoteModel != null) {
			try {
				Class<?> clazz = _demandeRemoteModel.getClass();

				Method method = clazz.getMethod("setQuestion", String.class);

				method.invoke(_demandeRemoteModel, question);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRequest() {
		return _request;
	}

	@Override
	public void setRequest(String request) {
		_request = request;

		if (_demandeRemoteModel != null) {
			try {
				Class<?> clazz = _demandeRemoteModel.getClass();

				Method method = clazz.getMethod("setRequest", String.class);

				method.invoke(_demandeRemoteModel, request);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDemandeRemoteModel() {
		return _demandeRemoteModel;
	}

	public void setDemandeRemoteModel(BaseModel<?> demandeRemoteModel) {
		_demandeRemoteModel = demandeRemoteModel;
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

		Class<?> remoteModelClass = _demandeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_demandeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DemandeLocalServiceUtil.addDemande(this);
		}
		else {
			DemandeLocalServiceUtil.updateDemande(this);
		}
	}

	@Override
	public Demande toEscapedModel() {
		return (Demande)ProxyUtil.newProxyInstance(Demande.class.getClassLoader(),
			new Class[] { Demande.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DemandeClp clone = new DemandeClp();

		clone.setDemandeId(getDemandeId());
		clone.setQuestion(getQuestion());
		clone.setRequest(getRequest());

		return clone;
	}

	@Override
	public int compareTo(Demande demande) {
		long primaryKey = demande.getPrimaryKey();

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

		if (!(obj instanceof DemandeClp)) {
			return false;
		}

		DemandeClp demande = (DemandeClp)obj;

		long primaryKey = demande.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{demandeId=");
		sb.append(getDemandeId());
		sb.append(", question=");
		sb.append(getQuestion());
		sb.append(", request=");
		sb.append(getRequest());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.viapost.stock.model.Demande");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>demandeId</column-name><column-value><![CDATA[");
		sb.append(getDemandeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>question</column-name><column-value><![CDATA[");
		sb.append(getQuestion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>request</column-name><column-value><![CDATA[");
		sb.append(getRequest());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _demandeId;
	private String _question;
	private String _request;
	private BaseModel<?> _demandeRemoteModel;
}