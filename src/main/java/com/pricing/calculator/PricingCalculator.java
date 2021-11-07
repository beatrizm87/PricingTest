package com.pricing.calculator;

import java.util.Comparator;
import java.util.List;

import com.pricing.model.SupplierProduct;
import com.pricing.presentation.uibean.RequestPrice;

public class PricingCalculator 
{
	/**
	 * Calculate a price for a product according to a status
	 * 
	 * @param supplierProducts list of supplier products to compare
	 * @param request built object from the parameters
	 * @param statusId status id
	 * 
	 * @return the suggested price for the status id according to the parameters
	 */
	public static double calculatePrice (List <SupplierProduct> supplierProducts, RequestPrice request, Integer statusId)
	{
		double suggestedPrice = request.getUpperBound(); 
		SupplierProduct supplierProduct = supplierProducts.stream().min(Comparator.comparing(SupplierProduct::getPrice)).orElse(null);
		
		if (supplierProduct != null)
		{
			if (supplierProduct.getStatus().ordinal() == statusId.intValue())
				suggestedPrice = Math.min(suggestedPrice, Math.max(request.getLowerBound(), supplierProduct.getPrice() - request.getX()));
			else
				suggestedPrice = Math.min(suggestedPrice, Math.max(request.getLowerBound(), supplierProduct.getPrice() - request.getY()));
		}
		return suggestedPrice;
	}
}
