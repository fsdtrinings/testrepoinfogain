package com.ig.test;

import java.util.List;

import com.ig.db.ProductDBClass;
import com.ig.model.Product;

public class ProductTestApp {

	public static void main(String[] args) {
		
		try {
			
			
			  List<Product> list = new ProductDBClass().getAllProductsByKeyword("Laptop");
			  System.out.println(list.size());
			 
			
			/*
			boolean b = new ProductDBClass().insertProduct(new Product(20, "ABC-123", "Mobile Phone", 20000, 2));
			System.out.println(b);
			*/
			  
			  Product p = new ProductDBClass().getProductbasedonId(1);
			  System.out.println(p);
			  
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
