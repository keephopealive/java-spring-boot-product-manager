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

import com.codingdojo.productmanager.models.Product;
import com.codingdojo.productmanager.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductsController {
	private final ProductService productService;
	
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("")
	public String showProducts(Model model) {
		System.out.println("ProductsController > showProducts(), get all products");
		List<Product> products = this.productService.retrieveAllProducts();
		System.out.println("ProductsController > showProducts(), products" + products);
		model.addAttribute("products", products);
		return "products/index.jsp";
	}
	
	@GetMapping("/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		System.out.println("ProductsController > newProduct()");
		return "products/new.jsp";
	}
	
	@GetMapping("/{id}/edit")
	public String editProduct(@PathVariable("id") Long id, Model model) {
		System.out.println("ProductsController > editProduct()");
		Product product = this.productService.retrieveOneProduct(id);
		model.addAttribute("product", product);
		return "products/edit.jsp";
	}
	
	@GetMapping("/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		System.out.println("ProductsController > showProduct(), id: " + id);
		Product product = this.productService.retrieveOneProduct(id);
		model.addAttribute("product", product);
		return "products/show.jsp";
	}
	
	
	@PostMapping("")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		System.out.println("ProductsController > POST createProduct() ");
		if(result.hasErrors()) {
			return "products/new.jsp";
		} else {
			this.productService.createProduct(product);
			return "redirect:/products";
		}
		
	}
	
	@GetMapping("/{id}/delete")
	public String deleteProduct(@PathVariable("id") Long id) {
		System.out.println("ProductsController > deleteProduct(), id: " + id);
		this.productService.deleteProduct(id);
		return "redirect:/products";
	}
	
	@PostMapping("/{id}/update")
	public String updateProduct(@PathVariable("id") Long id, @Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "products/edit.jsp";
		} else {
			this.productService.updateProduct(id, product);
			return "redirect:/products";
		}
	}
	
	
}
