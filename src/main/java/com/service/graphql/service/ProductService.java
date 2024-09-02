package com.service.graphql.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.service.graphql.pojo.Product;

@Service
public class ProductService {
	
//	@Autowired
//	ProductRepo productRepo;
	
	Random rand = new Random();
	
//	private List<Product> products = Arrays.asList(new Product(rand.nextInt(), "code01", "Mobile", "Electronics", 10000, 100),
//			new Product(rand.nextInt(), "code02", "Laptop", "Electronics", 700000, 110),
//			new Product(rand.nextInt(), "code03", "Smartwatch", "Electronics", 5000, 210),
//			new Product(rand.nextInt(), "code04", "Banana", "Fruits", 5, 500),
//			new Product(rand.nextInt(), "code05", "Apple", "Fruits", 100, 600),
//			new Product(rand.nextInt(), "code06", "shoe", "Accessories", 1000, 1000));
	private List<Product> products = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		products.add(new Product(rand.nextInt(), "code01", "Mobile", "Electronics", 10000, 100));
		products.add(new Product(rand.nextInt(), "code02", "Laptop", "Electronics", 700000, 110));
		products.add(new Product(rand.nextInt(), "code03", "Smartwatch", "Electronics", 5000, 210));
		products.add(new Product(rand.nextInt(), "code04", "Banana", "Fruits", 5, 500));
		products.add(new Product(rand.nextInt(), "code05", "Apple", "Fruits", 100, 600));
		products.add(new Product(rand.nextInt(), "code06", "shoe", "Accessories", 1000, 1000));
	}
	
	public List<Product> getProducts() {
		System.out.println("In service /getall");
//		return productRepo.findAll();
		return products;
	}
	
	public List<Product> getProductByName(String productName) {
		System.out.println("In service /getProductByName");
//		return productRepo.findByProductName(productName);
		return products.stream().filter(data -> productName.equals(data.getProductName())).collect(Collectors.toList());
	}
	
	public List<Product> getProductByCategory(String category) {
		System.out.println("In service /getProductByCategory");
//		return productRepo.findByProductName(productName);
		return products.stream().filter(data -> category.equals(data.getCategory())).collect(Collectors.toList());
	}
	
	public Product updateProduct(String productCode, int stock) {
		System.out.println("In service /updateProduct");
		Optional<Product> findFirst = products.stream().filter(data -> productCode.equals(data.getProductCode())).findFirst();
		Product product = null;
		if(findFirst.isPresent()) {
			product = findFirst.get();
			product.setStock(product.getStock()+stock);
		}
		return product;
	}
	
	public Product addProduct(String productCode,String productName,String category,double price,int stock) {
		System.out.println("In service /addProduct");
		Product product = new Product(rand.nextInt(), productCode, productName, category, price, stock);
		products.add(product);
		return product;
	}
}
