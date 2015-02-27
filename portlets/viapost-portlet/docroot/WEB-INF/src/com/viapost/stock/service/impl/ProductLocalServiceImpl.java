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

package com.viapost.stock.service.impl;

import javax.portlet.ActionRequest;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.viapost.stock.NoSuchProductException;
import com.viapost.stock.model.Product;
import com.viapost.stock.service.base.ProductLocalServiceBaseImpl;
import com.viapost.stock.validator.ProductValidator;

/**
 * The implementation of the product local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viapost.stock.service.ProductLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author pif
 * @see com.viapost.stock.service.base.ProductLocalServiceBaseImpl
 * @see com.viapost.stock.service.ProductLocalServiceUtil
 */
public class ProductLocalServiceImpl extends ProductLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.viapost.stock.service.ProductLocalServiceUtil} to access the product local service.
	 */
	@Override
	public void addProductFromRequest(final ActionRequest request) throws SystemException {

		final long primaryKey = CounterLocalServiceUtil.increment(Product.class.getName());
		final Product product = productPersistence.create(primaryKey);
		product.setArticleNumber(ParamUtil.getLong(request, "article"));
		product.setStock(ParamUtil.getLong(request, "stock"));
		product.setSeuil_stock(ParamUtil.getLong(request, "seuil"));


		if (ProductValidator.validateProduct(product)) {
			SessionMessages.add(request, "success");
			productPersistence.update(product);
		} else {
			SessionErrors.add(request, "error");
		}
	}
	
	
	@Override
	public void editProductFromRequest(final ActionRequest request) throws SystemException, NoSuchProductException {
		final Product product = productPersistence.findByPrimaryKey(ParamUtil.getLong(request, "stockId"));
		product.setArticleNumber(ParamUtil.getLong(request, "articleNumber"));
		product.setStock(ParamUtil.getLong(request, "stock"));
		product.setSeuil_stock(ParamUtil.getLong(request, "seuil-stock"));


		if (ProductValidator.validateProduct(product)) {
			SessionMessages.add(request, "success");
			productPersistence.update(product);
		} else {
			SessionErrors.add(request, "error");
		}
	}

}