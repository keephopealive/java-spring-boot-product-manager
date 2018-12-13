package com.codingdojo.productmanager.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.productmanager.models.Category;
import com.codingdojo.productmanager.models.Product;
import com.codingdojo.productmanager.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Product> retrieveAllProducts(){
		System.out.println("ProductService > retrieveAllProducts()");
		List<Product> products = (List<Product>) this.productRepository.findAll();
		System.out.println("ProductService > retrieveAllProducts() products" + products);
		return products;
	}
	
	public Product retrieveOneProduct(Long id) {
		Optional<Product> productInTheBox = this.productRepository.findById(id);
		if(productInTheBox.isPresent()) {
			Product product = productInTheBox.get();
			return product;
		} else {
			return null;
		}
	}
	
	public boolean createProduct(Product product) {
		this.productRepository.save(product);
		return true;
	}
	
	public boolean deleteProduct(Long id) {
		this.productRepository.deleteById(id);
		return true;
	}
	
	public boolean updateProduct(Long id, Product product) {
		Product databaseProduct = this.retrieveOneProduct(id);
		databaseProduct.setTitle(product.getTitle());
		databaseProduct.setDescription(product.getDescription());
		databaseProduct.setPrice(product.getPrice());
		databaseProduct.setQty(product.getQty());
		this.productRepository.save(databaseProduct);
		return true;
	}
	
	public List<Product> getProductsByTitle(String productName) {
		List<Product> products = this.productRepository.findByTitleContaining(productName);
		System.out.println("Products (inService: " + products);
		return products;
	}

	public List<Product> getAllProductsNotInCategory(Category category) {
		//	return this.productRepository.findByNotIn(category.getProducts())
		ArrayList<Long> product_ids = new ArrayList<Long>();
		for(Product product : category.getProducts()) {
			product_ids.add(product.getId());
		}
		
		if(product_ids.isEmpty()) {
			return (List<Product>) this.productRepository.findAll();
		} else {
			return this.productRepository.findByIdNotIn(product_ids);
		}
	}
	
}
