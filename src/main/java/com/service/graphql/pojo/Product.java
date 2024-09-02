package com.service.graphql.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//@Entity
//@Table(name = "PRODUCT_INFO")
public class Product {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String productCode;
	private String productName;
	private String category;
	private double price;
	private int stock;
}
