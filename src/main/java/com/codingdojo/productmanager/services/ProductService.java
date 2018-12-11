package com.codingdojo.productmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

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
	
}
