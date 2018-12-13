package com.codingdojo.productmanager.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.productmanager.models.Category;
import com.codingdojo.productmanager.models.Product;
import com.codingdojo.productmanager.services.CategoryService;
import com.codingdojo.productmanager.services.ProductService;


@Controller
@RequestMapping("/categories")
public class CategoriesController {
	
	private final CategoryService categoryService;
	private final ProductService productService;
	
	public CategoriesController(CategoryService categoryService,ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	
	@GetMapping("")
	public String showCategories(Model model) {
		model.addAttribute("categories", this.categoryService.retrieveAllCategories());
		return "categories/index.jsp";
	}
	
	@GetMapping("/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "categories/new.jsp";
	}
	
	@PostMapping("")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "categories/new.jsp";
		} else {
			this.categoryService.createCategory(category);
			return "redirect:/categories";
		}
		
	}
	
	@GetMapping("/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category category = this.categoryService.retrieveOneCategory(id);
		List<Product> products = this.productService.getAllProductsNotInCategory(category);
		model.addAttribute("category", category);
		model.addAttribute("products", products);
		return "categories/show.jsp";
	}
	
	@GetMapping("/{category_id}/product/{product_id}/remove")
	public String removeProductFromCategory(@PathVariable("category_id") Long category_id, @PathVariable("product_id") Long product_id) {
		System.out.println("category_id " + category_id);
		System.out.println("product_id " + product_id);
		this.categoryService.removeProductFromCategory(product_id, category_id);
		return "redirect:/categories/"+category_id;
	}
	
	@GetMapping("/{category_id}/product/{product_id}/add")
	public String addProductFromCategory(@PathVariable("category_id") Long category_id, @PathVariable("product_id") Long product_id) {
		System.out.println("category_id " + category_id);
		System.out.println("product_id " + product_id);
		this.categoryService.addProductToCategory(product_id, category_id);
		return "redirect:/categories/"+category_id;
	}
	
}
