package com.codingdojo.productmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.productmanager.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
