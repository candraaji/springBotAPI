package com.candra.models.repositories;

import java.util.List;

import com.candra.models.entities.Supplier;

import org.springframework.data.repository.CrudRepository;

public interface SupplierRepo extends CrudRepository<Supplier, Long> {
    
    List<Supplier> findByNameContains(String name);
}
