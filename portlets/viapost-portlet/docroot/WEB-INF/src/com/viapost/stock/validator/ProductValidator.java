package com.viapost.stock.validator;

import com.liferay.portal.kernel.util.Validator;
import com.viapost.stock.model.Product;

public class ProductValidator {

	public static boolean validateProduct(final Product product) {

		if (Validator.isNull(product.getArticleNumber())) {
			return false;
		}
		if (Validator.isNull(product.getSeuil_stock())) {
			return false;
		}
		if (Validator.isNull(product.getStock())) {
			return false;
		}
		return true;
	}


}
