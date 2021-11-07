package com.pricing.dao;

import org.springframework.data.repository.CrudRepository;

import com.pricing.model.Supplier;

/**
 * Repository for Supplier
 * 
 * @author beatr
 *
 */
public interface SupplierRepository extends CrudRepository<Supplier, Long> {
}
