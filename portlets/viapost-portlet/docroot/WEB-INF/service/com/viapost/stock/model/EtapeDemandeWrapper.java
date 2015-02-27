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
 * This class is a wrapper for {@link EtapeDemande}.
 * </p>
 *
 * @author pif
 * @see EtapeDemande
 * @generated
 */
public class EtapeDemandeWrapper implements EtapeDemande,
	ModelWrapper<EtapeDemande> {
	public EtapeDemandeWrapper(EtapeDemande etapeDemande) {
		_etapeDemande = etapeDemande;
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

	/**
	* Returns the primary key of this etape demande.
	*
	* @return the primary key of this etape demande
	*/
	@Override
	public long getPrimaryKey() {
		return _etapeDemande.getPrimaryKey();
	}

	/**
	* Sets the primary key of this etape demande.
	*
	* @param primaryKey the primary key of this etape demande
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_etapeDemande.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the etape ID of this etape demande.
	*
	* @return the etape ID of this etape demande
	*/
	@Override
	public long getEtapeId() {
		return _etapeDemande.getEtapeId();
	}

	/**
	* Sets the etape ID of this etape demande.
	*
	* @param etapeId the etape ID of this etape demande
	*/
	@Override
	public void setEtapeId(long etapeId) {
		_etapeDemande.setEtapeId(etapeId);
	}

	/**
	* Returns the demande ID of this etape demande.
	*
	* @return the demande ID of this etape demande
	*/
	@Override
	public long getDemandeId() {
		return _etapeDemande.getDemandeId();
	}

	/**
	* Sets the demande ID of this etape demande.
	*
	* @param demandeId the demande ID of this etape demande
	*/
	@Override
	public void setDemandeId(long demandeId) {
		_etapeDemande.setDemandeId(demandeId);
	}

	/**
	* Returns the decription of this etape demande.
	*
	* @return the decription of this etape demande
	*/
	@Override
	public java.lang.String getDecription() {
		return _etapeDemande.getDecription();
	}

	/**
	* Sets the decription of this etape demande.
	*
	* @param decription the decription of this etape demande
	*/
	@Override
	public void setDecription(java.lang.String decription) {
		_etapeDemande.setDecription(decription);
	}

	/**
	* Returns the order of this etape demande.
	*
	* @return the order of this etape demande
	*/
	@Override
	public long getOrder() {
		return _etapeDemande.getOrder();
	}

	/**
	* Sets the order of this etape demande.
	*
	* @param order the order of this etape demande
	*/
	@Override
	public void setOrder(long order) {
		_etapeDemande.setOrder(order);
	}

	@Override
	public boolean isNew() {
		return _etapeDemande.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_etapeDemande.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _etapeDemande.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_etapeDemande.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _etapeDemande.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _etapeDemande.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_etapeDemande.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _etapeDemande.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_etapeDemande.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_etapeDemande.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_etapeDemande.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EtapeDemandeWrapper((EtapeDemande)_etapeDemande.clone());
	}

	@Override
	public int compareTo(com.viapost.stock.model.EtapeDemande etapeDemande) {
		return _etapeDemande.compareTo(etapeDemande);
	}

	@Override
	public int hashCode() {
		return _etapeDemande.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viapost.stock.model.EtapeDemande> toCacheModel() {
		return _etapeDemande.toCacheModel();
	}

	@Override
	public com.viapost.stock.model.EtapeDemande toEscapedModel() {
		return new EtapeDemandeWrapper(_etapeDemande.toEscapedModel());
	}

	@Override
	public com.viapost.stock.model.EtapeDemande toUnescapedModel() {
		return new EtapeDemandeWrapper(_etapeDemande.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _etapeDemande.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _etapeDemande.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_etapeDemande.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EtapeDemandeWrapper)) {
			return false;
		}

		EtapeDemandeWrapper etapeDemandeWrapper = (EtapeDemandeWrapper)obj;

		if (Validator.equals(_etapeDemande, etapeDemandeWrapper._etapeDemande)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EtapeDemande getWrappedEtapeDemande() {
		return _etapeDemande;
	}

	@Override
	public EtapeDemande getWrappedModel() {
		return _etapeDemande;
	}

	@Override
	public void resetOriginalValues() {
		_etapeDemande.resetOriginalValues();
	}

	private EtapeDemande _etapeDemande;
}