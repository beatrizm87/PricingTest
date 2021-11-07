package com.pricing.model.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Product Status enumerator
 * 
 * @author beatr
 *
 */
public enum ProductStatus {
	ETAT_MOYEN  ("etat moyen", 1),
	BON_ETAT ("bon état", 2),
	TRES_BON_ETAT ("très bon état", 3),
	COMME_NEUF ("comme neuf", 4),
	NEUF ("neuf", 5);
	
	/**
	 * Status name
	 */
	private String description;
	
	/**
	 * Status order
	 */
	private Integer order;
	
	/**
	 * Constructor
	 * 
	 * @param description
	 */
	private ProductStatus(String description, Integer order)
	{
		this.description = description;
		this.order = order;
	}
	
	/**
	 * Get description
	 * 
	 * @return description
	 */
	public String getDescription ()
	{
		return this.description;
	}
	
	/**
	 * Get order
	 * 
	 * @return order
	 */
	public Integer getOrder ()
	{
		return this.order;
	}
	
	/**
	 * Get the status by its description
	 * @param description status description
	 * @return the corresponding ProductStatus
	 * @throws IllegalArgumentException
	 * 			if description doesn't exist, throws an exception
	 */
	public static ProductStatus fromDescription(String description) throws IllegalArgumentException {

		ProductStatus [] statuses = ProductStatus.values();

		for (ProductStatus status: statuses)
			if (status.getDescription().equalsIgnoreCase(description))
				return status;
			
		throw new IllegalArgumentException("No type value associated to  :" + description );
	}
	
	/**
	 * 
	 * @param productStatus
	 * @return list with all existing productStatus with an order greater than or equal to a given one 
	 */
	public static List<ProductStatus> getEqualAndHigherOrder (ProductStatus productStatus)
	{
		List<ProductStatus> statusOrdinals = new ArrayList<>();
		ProductStatus [] statuses = ProductStatus.values();

		for (ProductStatus status: statuses)
			if (status.getOrder() >= productStatus.getOrder())
				statusOrdinals.add(status);
	
		return statusOrdinals;
	}

	
}
