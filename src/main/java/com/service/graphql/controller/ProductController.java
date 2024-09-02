package com.service.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.graphql.pojo.Product;
import com.service.graphql.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/getall")
	public List<Product> getProducts() {
		System.out.println("In controller /getall");
		return productService.getProducts();
	}
	
	@GetMapping("/{productName}")
	public List<Product> getProductByName(@PathVariable String productName) {
		System.out.println("In controller /productName");
		return productService.getProductByName(productName);
	}
	
	@QueryMapping
	public List<Product> getAllProducts() {
		System.out.println("In controller /getall");
		return productService.getProducts();
	}
	
	@QueryMapping
	public List<Product> getProductByProductName(@Argument String productName) {
		System.out.println("In controller /getProductByProductName");
		return productService.getProductByName(productName);
	}
	
	@QueryMapping
	public List<Product> getProductByCategory(@Argument String category) {
		System.out.println("In controller /getProductByCategory");
		return productService.getProductByCategory(category);
	}
	
	@MutationMapping
	public Product updateProduct(@Argument String productCode, @Argument int stock) {
		System.out.println("In controller /updateProduct");
		return productService.updateProduct(productCode, stock);
	}
	
	@MutationMapping
	public Product addProduct(@Argument String productCode,@Argument String productName,@Argument String category,
			@Argument double price,@Argument int stock) {
		System.out.println("In controller /addProduct");
		return productService.addProduct(productCode, productName, category, price, stock);
	}
}
