package com.codingdojo.productmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.productmanager.models.Category;
import com.codingdojo.productmanager.models.Product;
import com.codingdojo.productmanager.repositories.CategoryRepository;
import com.codingdojo.productmanager.repositories.ProductRepository;


@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	private final ProductService productService;
	
	public CategoryService(
		CategoryRepository categoryRepository, 
		ProductRepository productRepository,
		ProductService productService
	) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
		this.productService = productService;
	}

	public List<Category> retrieveAllCategories() {
		return (List<Category>) this.categoryRepository.findAll();
	}

	public void createCategory(Category category) {
		this.categoryRepository.save(category);
	}
	
	public Category retrieveOneCategory(Long id) {
		Optional<Category> categoryInTheBox = this.categoryRepository.findById(id);
		if(categoryInTheBox.isPresent()) {
			return categoryInTheBox.get();
		} else {
			return null;
		}
	}

	public void removeProductFromCategory(Long product_id, Long category_id) {
		Category category = this.retrieveOneCategory(category_id);
		Product product = this.productService.retrieveOneProduct(product_id);
		category.getProducts().remove(product);
		this.categoryRepository.save(category);
	}

	public void addProductToCategory(Long product_id, Long category_id) {
		Category category = this.retrieveOneCategory(category_id);
		Product product = this.productService.retrieveOneProduct(product_id);
		category.getProducts().add(product);
		this.categoryRepository.save(category);
	}
}
