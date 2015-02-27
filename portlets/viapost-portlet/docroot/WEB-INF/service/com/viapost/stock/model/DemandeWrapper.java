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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Demande}.
 * </p>
 *
 * @author pif
 * @see Demande
 * @generated
 */
public class DemandeWrapper implements Demande, ModelWrapper<Demande> {
	public DemandeWrapper(Demande demande) {
		_demande = demande;
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

	/**
	* Returns the primary key of this demande.
	*
	* @return the primary key of this demande
	*/
	@Override
	public long getPrimaryKey() {
		return _demande.getPrimaryKey();
	}

	/**
	* Sets the primary key of this demande.
	*
	* @param primaryKey the primary key of this demande
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_demande.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the demande ID of this demande.
	*
	* @return the demande ID of this demande
	*/
	@Override
	public long getDemandeId() {
		return _demande.getDemandeId();
	}

	/**
	* Sets the demande ID of this demande.
	*
	* @param demandeId the demande ID of this demande
	*/
	@Override
	public void setDemandeId(long demandeId) {
		_demande.setDemandeId(demandeId);
	}

	/**
	* Returns the question of this demande.
	*
	* @return the question of this demande
	*/
	@Override
	public java.lang.String getQuestion() {
		return _demande.getQuestion();
	}

	/**
	* Sets the question of this demande.
	*
	* @param question the question of this demande
	*/
	@Override
	public void setQuestion(java.lang.String question) {
		_demande.setQuestion(question);
	}

	/**
	* Returns the request of this demande.
	*
	* @return the request of this demande
	*/
	@Override
	public java.lang.String getRequest() {
		return _demande.getRequest();
	}

	/**
	* Sets the request of this demande.
	*
	* @param request the request of this demande
	*/
	@Override
	public void setRequest(java.lang.String request) {
		_demande.setRequest(request);
	}

	@Override
	public boolean isNew() {
		return _demande.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_demande.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _demande.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_demande.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _demande.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _demande.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_demande.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _demande.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_demande.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_demande.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_demande.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DemandeWrapper((Demande)_demande.clone());
	}

	@Override
	public int compareTo(com.viapost.stock.model.Demande demande) {
		return _demande.compareTo(demande);
	}

	@Override
	public int hashCode() {
		return _demande.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viapost.stock.model.Demande> toCacheModel() {
		return _demande.toCacheModel();
	}

	@Override
	public com.viapost.stock.model.Demande toEscapedModel() {
		return new DemandeWrapper(_demande.toEscapedModel());
	}

	@Override
	public com.viapost.stock.model.Demande toUnescapedModel() {
		return new DemandeWrapper(_demande.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _demande.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _demande.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_demande.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DemandeWrapper)) {
			return false;
		}

		DemandeWrapper demandeWrapper = (DemandeWrapper)obj;

		if (Validator.equals(_demande, demandeWrapper._demande)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Demande getWrappedDemande() {
		return _demande;
	}

	@Override
	public Demande getWrappedModel() {
		return _demande;
	}

	@Override
	public void resetOriginalValues() {
		_demande.resetOriginalValues();
	}

	private Demande _demande;
}