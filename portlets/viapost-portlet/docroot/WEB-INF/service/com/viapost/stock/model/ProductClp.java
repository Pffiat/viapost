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
import com.viapost.stock.service.ProductLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pif
 */
public class ProductClp extends BaseModelImpl<Product> implements Product {
	public ProductClp() {
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
	public long getPrimaryKey() {
		return _stockId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStockId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _stockId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getStockId() {
		return _stockId;
	}

	@Override
	public void setStockId(long stockId) {
		_stockId = stockId;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setStockId", long.class);

				method.invoke(_productRemoteModel, stockId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getArticleNumber() {
		return _articleNumber;
	}

	@Override
	public void setArticleNumber(long articleNumber) {
		_articleNumber = articleNumber;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setArticleNumber", long.class);

				method.invoke(_productRemoteModel, articleNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStock() {
		return _stock;
	}

	@Override
	public void setStock(long stock) {
		_stock = stock;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setStock", long.class);

				method.invoke(_productRemoteModel, stock);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSeuil_stock() {
		return _seuil_stock;
	}

	@Override
	public void setSeuil_stock(long seuil_stock) {
		_seuil_stock = seuil_stock;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setSeuil_stock", long.class);

				method.invoke(_productRemoteModel, seuil_stock);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getProductRemoteModel() {
		return _productRemoteModel;
	}

	public void setProductRemoteModel(BaseModel<?> productRemoteModel) {
		_productRemoteModel = productRemoteModel;
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

		Class<?> remoteModelClass = _productRemoteModel.getClass();

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

		Object returnValue = method.invoke(_productRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ProductLocalServiceUtil.addProduct(this);
		}
		else {
			ProductLocalServiceUtil.updateProduct(this);
		}
	}

	@Override
	public Product toEscapedModel() {
		return (Product)ProxyUtil.newProxyInstance(Product.class.getClassLoader(),
			new Class[] { Product.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProductClp clone = new ProductClp();

		clone.setStockId(getStockId());
		clone.setArticleNumber(getArticleNumber());
		clone.setStock(getStock());
		clone.setSeuil_stock(getSeuil_stock());

		return clone;
	}

	@Override
	public int compareTo(Product product) {
		long primaryKey = product.getPrimaryKey();

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

		if (!(obj instanceof ProductClp)) {
			return false;
		}

		ProductClp product = (ProductClp)obj;

		long primaryKey = product.getPrimaryKey();

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

		sb.append("{stockId=");
		sb.append(getStockId());
		sb.append(", articleNumber=");
		sb.append(getArticleNumber());
		sb.append(", stock=");
		sb.append(getStock());
		sb.append(", seuil_stock=");
		sb.append(getSeuil_stock());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.viapost.stock.model.Product");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>stockId</column-name><column-value><![CDATA[");
		sb.append(getStockId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>articleNumber</column-name><column-value><![CDATA[");
		sb.append(getArticleNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stock</column-name><column-value><![CDATA[");
		sb.append(getStock());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seuil_stock</column-name><column-value><![CDATA[");
		sb.append(getSeuil_stock());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _stockId;
	private long _articleNumber;
	private long _stock;
	private long _seuil_stock;
	private BaseModel<?> _productRemoteModel;
}