package com.pricing.presentation.uibean;

import lombok.Getter;
import lombok.Setter;

/**
 * UI Request Price
 * 
 * @author beatr
 *
 */
@Getter
@Setter
public class RequestPrice 
{
	/**
	 * Product id
	 */
	private Long productId;
	
	/**
	 * Quantity to reduce to the price for a supplier product with the same status
	 */
	private Double x;
	
	/**
	 * Quantity to reduce to the price for a supplier product with a higher status
	 */
	private Double y;
	
	/**
	 * Minimum allowed price
	 */
	private Double lowerBound;
	
	/**
	 * Maximum allowed price
	 */
	private Double upperBound;
	
	/**
	 * Status name of the product
	 */
	private String statusName;
	
	/**
	 * Constructor
	 * 
	 * @param productId
	 * @param x
	 * @param y
	 * @param lowerBound
	 * @param upperBound
	 * @param statusName
	 */
	public RequestPrice (Long productId, Double x, Double y, Double lowerBound, Double upperBound, String statusName)
	{
		this.productId = productId;
		this.x = x;
		this.y = y;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.statusName = statusName;
	}
}
