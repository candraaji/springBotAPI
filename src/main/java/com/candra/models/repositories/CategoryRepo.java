package com.candra.models.repositories;

import java.util.List;

import com.candra.models.entities.Category;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Long> {

    List<Category> findByNameContains(String name);
}
