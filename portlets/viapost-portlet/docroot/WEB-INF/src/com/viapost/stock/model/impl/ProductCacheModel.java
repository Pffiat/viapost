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

package com.viapost.stock.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.viapost.stock.model.Product;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Product in entity cache.
 *
 * @author pif
 * @see Product
 * @generated
 */
public class ProductCacheModel implements CacheModel<Product>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{stockId=");
		sb.append(stockId);
		sb.append(", articleNumber=");
		sb.append(articleNumber);
		sb.append(", stock=");
		sb.append(stock);
		sb.append(", seuil_stock=");
		sb.append(seuil_stock);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Product toEntityModel() {
		ProductImpl productImpl = new ProductImpl();

		productImpl.setStockId(stockId);
		productImpl.setArticleNumber(articleNumber);
		productImpl.setStock(stock);
		productImpl.setSeuil_stock(seuil_stock);

		productImpl.resetOriginalValues();

		return productImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stockId = objectInput.readLong();
		articleNumber = objectInput.readLong();
		stock = objectInput.readLong();
		seuil_stock = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(stockId);
		objectOutput.writeLong(articleNumber);
		objectOutput.writeLong(stock);
		objectOutput.writeLong(seuil_stock);
	}

	public long stockId;
	public long articleNumber;
	public long stock;
	public long seuil_stock;
}