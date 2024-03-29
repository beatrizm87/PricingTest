package com.pricing.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pricing.calculator.PricingCalculator;
import com.pricing.dao.SupplierProductRepository;
import com.pricing.model.SupplierProduct;
import com.pricing.model.enums.ProductStatus;
import com.pricing.presentation.uibean.RequestPrice;

@Service
public class SupplierProductService {

	/**
	 * Repository injected by Spring
	 */
	@Autowired
	private SupplierProductRepository supplierProductRepository;
	
	/**
	 * Find all supplier products by product id and status
	 * 
	 * @param productId product id
	 * @param statuses list of status ids
	 * 
	 * @return list of found supplier products by product id and status
	 */
	public List<SupplierProduct> findAllByProductAndStatus (Long productId, List<ProductStatus> statuses)
	{	
		return this.supplierProductRepository.findAllByProductAndStatus(productId, statuses);
	}
	
	/**
	 * Calculate the price for a product according to a status
	 * 
	 * @param request built object from the parameters
	 * 
	 * @return the suggested price
	 */
	public double calculatePriceForProductByStatus (RequestPrice request)
	{	
		ProductStatus productStatus = ProductStatus.fromDescription(request.getStatusName());
		List<SupplierProduct> supplierProducts = this.findAllByProductAndStatus(request.getProductId(), ProductStatus.getEqualAndHigherOrder(productStatus));
		double suggestedPrice = PricingCalculator.calculatePrice(supplierProducts, request, productStatus.ordinal());
		
		return suggestedPrice;
	}
	
	/**
	 * Calculate the prices for a product for the different statuses
	 * 
	 * @param request built object from the parameters
	 * 
	 * @return map with the list of status name and corresponding price
	 */
	public Map<String, Double> calculatePossiblePrices (RequestPrice request)
	{
		Map<String, Double> response = new HashMap<>();
		List <SupplierProduct> supplierProducts = this.supplierProductRepository.findByProductId(request.getProductId());
		ProductStatus[] productStatuses = ProductStatus.values();
		
		for (ProductStatus status : productStatuses)
		{
			List <SupplierProduct> filteredProducts = supplierProducts.stream().filter(supplierProduct -> supplierProduct.getStatus().getOrder() >= status.getOrder()).collect(Collectors.toList());
			response.put(status.getDescription(), PricingCalculator.calculatePrice(filteredProducts, request, status.ordinal()));
		}
		
		return response;	
	}
}
