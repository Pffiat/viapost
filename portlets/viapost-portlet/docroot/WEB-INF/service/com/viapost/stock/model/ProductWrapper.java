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
 * This class is a wrapper for {@link Product}.
 * </p>
 *
 * @author pif
 * @see Product
 * @generated
 */
public class ProductWrapper implements Product, ModelWrapper<Product> {
	public ProductWrapper(Product product) {
		_product = product;
	}

	@Override
	public Class<?> getModelClass() {
		return Product.class;
	}

	@Override
	public String getModelClassName() {
		return Product.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stockId", getStockId());
		attributes.put("articleNumber", getArticleNumber());
		attributes.put("stock", getStock());
		attributes.put("seuil_stock", getSeuil_stock());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stockId = (Long)attributes.get("stockId");

		if (stockId != null) {
			setStockId(stockId);
		}

		Long articleNumber = (Long)attributes.get("articleNumber");

		if (articleNumber != null) {
			setArticleNumber(articleNumber);
		}

		Long stock = (Long)attributes.get("stock");

		if (stock != null) {
			setStock(stock);
		}

		Long seuil_stock = (Long)attributes.get("seuil_stock");

		if (seuil_stock != null) {
			setSeuil_stock(seuil_stock);
		}
	}

	/**
	* Returns the primary key of this product.
	*
	* @return the primary key of this product
	*/
	@Override
	public long getPrimaryKey() {
		return _product.getPrimaryKey();
	}

	/**
	* Sets the primary key of this product.
	*
	* @param primaryKey the primary key of this product
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_product.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the stock ID of this product.
	*
	* @return the stock ID of this product
	*/
	@Override
	public long getStockId() {
		return _product.getStockId();
	}

	/**
	* Sets the stock ID of this product.
	*
	* @param stockId the stock ID of this product
	*/
	@Override
	public void setStockId(long stockId) {
		_product.setStockId(stockId);
	}

	/**
	* Returns the article number of this product.
	*
	* @return the article number of this product
	*/
	@Override
	public long getArticleNumber() {
		return _product.getArticleNumber();
	}

	/**
	* Sets the article number of this product.
	*
	* @param articleNumber the article number of this product
	*/
	@Override
	public void setArticleNumber(long articleNumber) {
		_product.setArticleNumber(articleNumber);
	}

	/**
	* Returns the stock of this product.
	*
	* @return the stock of this product
	*/
	@Override
	public long getStock() {
		return _product.getStock();
	}

	/**
	* Sets the stock of this product.
	*
	* @param stock the stock of this product
	*/
	@Override
	public void setStock(long stock) {
		_product.setStock(stock);
	}

	/**
	* Returns the seuil_stock of this product.
	*
	* @return the seuil_stock of this product
	*/
	@Override
	public long getSeuil_stock() {
		return _product.getSeuil_stock();
	}

	/**
	* Sets the seuil_stock of this product.
	*
	* @param seuil_stock the seuil_stock of this product
	*/
	@Override
	public void setSeuil_stock(long seuil_stock) {
		_product.setSeuil_stock(seuil_stock);
	}

	@Override
	public boolean isNew() {
		return _product.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_product.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _product.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_product.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _product.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _product.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_product.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _product.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_product.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_product.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_product.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProductWrapper((Product)_product.clone());
	}

	@Override
	public int compareTo(com.viapost.stock.model.Product product) {
		return _product.compareTo(product);
	}

	@Override
	public int hashCode() {
		return _product.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viapost.stock.model.Product> toCacheModel() {
		return _product.toCacheModel();
	}

	@Override
	public com.viapost.stock.model.Product toEscapedModel() {
		return new ProductWrapper(_product.toEscapedModel());
	}

	@Override
	public com.viapost.stock.model.Product toUnescapedModel() {
		return new ProductWrapper(_product.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _product.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _product.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_product.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProductWrapper)) {
			return false;
		}

		ProductWrapper productWrapper = (ProductWrapper)obj;

		if (Validator.equals(_product, productWrapper._product)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Product getWrappedProduct() {
		return _product;
	}

	@Override
	public Product getWrappedModel() {
		return _product;
	}

	@Override
	public void resetOriginalValues() {
		_product.resetOriginalValues();
	}

	private Product _product;
}