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
import com.viapost.stock.service.EtapeDemandeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pif
 */
public class EtapeDemandeClp extends BaseModelImpl<EtapeDemande>
	implements EtapeDemande {
	public EtapeDemandeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EtapeDemande.class;
	}

	@Override
	public String getModelClassName() {
		return EtapeDemande.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _etapeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEtapeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _etapeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("etapeId", getEtapeId());
		attributes.put("demandeId", getDemandeId());
		attributes.put("decription", getDecription());
		attributes.put("order", getOrder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long etapeId = (Long)attributes.get("etapeId");

		if (etapeId != null) {
			setEtapeId(etapeId);
		}

		Long demandeId = (Long)attributes.get("demandeId");

		if (demandeId != null) {
			setDemandeId(demandeId);
		}

		String decription = (String)attributes.get("decription");

		if (decription != null) {
			setDecription(decription);
		}

		Long order = (Long)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}
	}

	@Override
	public long getEtapeId() {
		return _etapeId;
	}

	@Override
	public void setEtapeId(long etapeId) {
		_etapeId = etapeId;

		if (_etapeDemandeRemoteModel != null) {
			try {
				Class<?> clazz = _etapeDemandeRemoteModel.getClass();

				Method method = clazz.getMethod("setEtapeId", long.class);

				method.invoke(_etapeDemandeRemoteModel, etapeId);
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

		if (_etapeDemandeRemoteModel != null) {
			try {
				Class<?> clazz = _etapeDemandeRemoteModel.getClass();

				Method method = clazz.getMethod("setDemandeId", long.class);

				method.invoke(_etapeDemandeRemoteModel, demandeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDecription() {
		return _decription;
	}

	@Override
	public void setDecription(String decription) {
		_decription = decription;

		if (_etapeDemandeRemoteModel != null) {
			try {
				Class<?> clazz = _etapeDemandeRemoteModel.getClass();

				Method method = clazz.getMethod("setDecription", String.class);

				method.invoke(_etapeDemandeRemoteModel, decription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrder() {
		return _order;
	}

	@Override
	public void setOrder(long order) {
		_order = order;

		if (_etapeDemandeRemoteModel != null) {
			try {
				Class<?> clazz = _etapeDemandeRemoteModel.getClass();

				Method method = clazz.getMethod("setOrder", long.class);

				method.invoke(_etapeDemandeRemoteModel, order);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEtapeDemandeRemoteModel() {
		return _etapeDemandeRemoteModel;
	}

	public void setEtapeDemandeRemoteModel(BaseModel<?> etapeDemandeRemoteModel) {
		_etapeDemandeRemoteModel = etapeDemandeRemoteModel;
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

		Class<?> remoteModelClass = _etapeDemandeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_etapeDemandeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EtapeDemandeLocalServiceUtil.addEtapeDemande(this);
		}
		else {
			EtapeDemandeLocalServiceUtil.updateEtapeDemande(this);
		}
	}

	@Override
	public EtapeDemande toEscapedModel() {
		return (EtapeDemande)ProxyUtil.newProxyInstance(EtapeDemande.class.getClassLoader(),
			new Class[] { EtapeDemande.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EtapeDemandeClp clone = new EtapeDemandeClp();

		clone.setEtapeId(getEtapeId());
		clone.setDemandeId(getDemandeId());
		clone.setDecription(getDecription());
		clone.setOrder(getOrder());

		return clone;
	}

	@Override
	public int compareTo(EtapeDemande etapeDemande) {
		int value = 0;

		if (getOrder() < etapeDemande.getOrder()) {
			value = -1;
		}
		else if (getOrder() > etapeDemande.getOrder()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EtapeDemandeClp)) {
			return false;
		}

		EtapeDemandeClp etapeDemande = (EtapeDemandeClp)obj;

		long primaryKey = etapeDemande.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{etapeId=");
		sb.append(getEtapeId());
		sb.append(", demandeId=");
		sb.append(getDemandeId());
		sb.append(", decription=");
		sb.append(getDecription());
		sb.append(", order=");
		sb.append(getOrder());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.viapost.stock.model.EtapeDemande");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>etapeId</column-name><column-value><![CDATA[");
		sb.append(getEtapeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>demandeId</column-name><column-value><![CDATA[");
		sb.append(getDemandeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>decription</column-name><column-value><![CDATA[");
		sb.append(getDecription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>order</column-name><column-value><![CDATA[");
		sb.append(getOrder());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _etapeId;
	private long _demandeId;
	private String _decription;
	private long _order;
	private BaseModel<?> _etapeDemandeRemoteModel;
}