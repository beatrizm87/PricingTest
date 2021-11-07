package com.pricing.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pricing.model.SupplierProduct;
import com.pricing.model.enums.ProductStatus;

/**
 * Repository for SupplierProduct
 * 
 * @author beatr
 *
 */
public interface SupplierProductRepository extends CrudRepository<SupplierProduct, Long>{

	/**
	 * Find all supplier products with same productId and equal or higher priority
	 * 
	 * @param productId product id
	 * @param priotity priority to compare
	 * 
	 * @return list of found supplier products
	 */
	@Query("SELECT sp FROM SupplierProduct sp LEFT JOIN FETCH sp.product product "
			+ "									WHERE product.id = :productId AND sp.status IN (:statuses)")
	List<SupplierProduct> findAllByProductAndStatus (@Param("productId") Long productId, @Param("statuses") List<ProductStatus> statuses);
	
	/**
	 * Find list of supplier products by product id
	 * 
	 * @param productId product id to compare
	 * 
	 * @return the list of found supplier products
	 */
	@Query("SELECT sp FROM SupplierProduct sp LEFT JOIN FETCH sp.product product WHERE product.id = :productId")
	List<SupplierProduct> findByProductId (@Param("productId") Long productId);
}
