package com.candra.models.repositories;

import java.util.List;

import javax.websocket.server.PathParam;

import com.candra.models.entities.Product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Long>{

    List<Product> findByNameContains(String name);

    @Query("SELECT p FROM Product p WHERE p.name = :name")
    public Product findProductByName(@PathParam("name") String name);

    @Query("SELECT p FROM Product p WHERE p.name LIKE :name")
    public List<Product> findProductByNameLike(@PathParam("name") String name);
}
