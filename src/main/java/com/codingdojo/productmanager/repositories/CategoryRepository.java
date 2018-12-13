package com.codingdojo.productmanager.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.productmanager.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
