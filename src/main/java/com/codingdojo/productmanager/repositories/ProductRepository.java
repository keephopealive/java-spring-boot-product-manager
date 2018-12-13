package com.codingdojo.productmanager.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.productmanager.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	public List<Product> findByTitleContaining(String productName);

	public List<Product> findByIdNotIn(ArrayList<Long> product_ids);
}
