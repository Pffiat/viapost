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
public class ProductSoap implements Serializable {
	public static ProductSoap toSoapModel(Product model) {
		ProductSoap soapModel = new ProductSoap();

		soapModel.setStockId(model.getStockId());
		soapModel.setArticleNumber(model.getArticleNumber());
		soapModel.setStock(model.getStock());
		soapModel.setSeuil_stock(model.getSeuil_stock());

		return soapModel;
	}

	public static ProductSoap[] toSoapModels(Product[] models) {
		ProductSoap[] soapModels = new ProductSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProductSoap[][] toSoapModels(Product[][] models) {
		ProductSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProductSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProductSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProductSoap[] toSoapModels(List<Product> models) {
		List<ProductSoap> soapModels = new ArrayList<ProductSoap>(models.size());

		for (Product model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProductSoap[soapModels.size()]);
	}

	public ProductSoap() {
	}

	public long getPrimaryKey() {
		return _stockId;
	}

	public void setPrimaryKey(long pk) {
		setStockId(pk);
	}

	public long getStockId() {
		return _stockId;
	}

	public void setStockId(long stockId) {
		_stockId = stockId;
	}

	public long getArticleNumber() {
		return _articleNumber;
	}

	public void setArticleNumber(long articleNumber) {
		_articleNumber = articleNumber;
	}

	public long getStock() {
		return _stock;
	}

	public void setStock(long stock) {
		_stock = stock;
	}

	public long getSeuil_stock() {
		return _seuil_stock;
	}

	public void setSeuil_stock(long seuil_stock) {
		_seuil_stock = seuil_stock;
	}

	private long _stockId;
	private long _articleNumber;
	private long _stock;
	private long _seuil_stock;
}