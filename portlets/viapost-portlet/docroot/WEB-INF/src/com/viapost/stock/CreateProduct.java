package com.viapost.stock;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.viapost.stock.service.ProductLocalServiceUtil;

/**
 * Portlet implementation class CreateProduct
 */
public class CreateProduct extends MVCPortlet {

	public void addProduct(final ActionRequest request, final ActionResponse response) throws SystemException, IOException {
		ProductLocalServiceUtil.addProductFromRequest(request);
	}
	
	public void editProduct(final ActionRequest request, final ActionResponse response) throws SystemException, IOException, NoSuchProductException {
		ProductLocalServiceUtil.editProductFromRequest(request);
	}

}
