package com.pricing.dao;

import org.springframework.data.repository.CrudRepository;

import com.pricing.model.Product;

/**
 * Repository for Product 
 * 
 * @author beatr
 *
 */
public interface ProductRepository extends CrudRepository<Product, Long>{
}
