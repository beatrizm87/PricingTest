package com.pricing.presentation;

import java.util.Map;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pricing.annotations.CheckStatusNameValidation;
import com.pricing.presentation.uibean.RequestPrice;
import com.pricing.services.SupplierProductService;

/**
 * Rest controller to calculate the prices associated to a product according the parameters
 * 
 * @author beatr
 *
 */
@RestController
@Validated
@RequestMapping("pricing")
public class PricingController {
	
	/**
	 * Service injected by Spring
	 */
	@Autowired
	private SupplierProductService supplierProductService;

	/**
	 * Calculate a price for a determined product and status
	 * 
	 * @param productId product Id
	 * @param x quantity to reduce if the found product has the same status
	 * @param y quantity to reduce if the found product has a higher status
	 * @param lowerBound lower bound for the product's price
	 * @param upperBound upper bound for the product's price
	 * @param statusName status name
	 * 
	 * @return the suggested price
	 */
	@GetMapping("/calculateByStatus")
	@ResponseBody
	public double calculatePriceByStatusAndProduct (
			@RequestParam @Min(1) Long productId,
			@RequestParam @Min(0) Double x,
			@RequestParam @Min(0) Double y,
			@RequestParam @Min(0) Double lowerBound,
			@RequestParam @Min(0) Double upperBound,
			@RequestParam @CheckStatusNameValidation() String statusName)
	{
		RequestPrice request = new RequestPrice (productId, x, y, lowerBound, upperBound, statusName);
		return this.supplierProductService.calculatePriceForProductByStatus(request);
	}
	
	/**
	 * Calculate the prices according to the different statuses for a product
	 * 
	 * @param productId product Id
	 * @param x quantity to reduce if the found product has the same status
	 * @param y quantity to reduce if the found product has a higher status
	 * @param lowerBound lower bound for the product's price
	 * @param upperBound upper bound for the product's price
	 * 
	 * @return a map with a list of statuses and prices
	 */
	@GetMapping("/calculate")
	@ResponseBody
	public Map<String, Double> calculatePriceForProduct (  @RequestParam @Min(1) Long productId,
											@RequestParam @Min(0) Double x,
											@RequestParam @Min(0) Double y,
											@RequestParam @Min(0) Double lowerBound,
											@RequestParam @Min(0) Double upperBound)
	{
		RequestPrice request = new RequestPrice (productId, x, y, lowerBound, upperBound, null);		
		return this.supplierProductService.calculatePossiblePrices(request);
	}
}
