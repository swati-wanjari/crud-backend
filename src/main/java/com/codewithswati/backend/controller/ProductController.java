package com.codewithswati.backend.controller;

import java.util.List;

import com.codewithswati.backend.model.Product;
import com.codewithswati.backend.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codewithswati.backend.exception.ProductNotFoundException;
import com.codewithswati.backend.repository.ProductRepository;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping("/test")
	public String test (@Valid @RequestBody Product product) {
		return "Success";
	}
	@PostMapping
	public Product addProduct(@RequestBody Product product)
	{
		return productService.addProduct(product);
	}
	@GetMapping
	public List<Product> getAllProducts()
	{
		return productService.getAllProducts();
	}
	@GetMapping("/{id}")
	Product getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	
	@PutMapping
	public Product updateProduct(@RequestBody Product product)
	{
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/{id}")
	public String DeleteProduct(@PathVariable Long id)
	{
		return productService.DeleteProduct(id);
	}
}
