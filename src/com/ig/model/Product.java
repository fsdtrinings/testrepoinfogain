package com.ig.model;

public class Product implements Comparable<Product>{
	
	private int id;
	private String productName;
	private String category;
	private int cost;
	private int units;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String productName, String category, int cost, int units) {
		super();
		this.id = id;
		this.productName = productName;
		this.category = category;
		this.cost = cost;
		this.units = units;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + cost;
		result = prime * result + id;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + units;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (cost != other.cost)
			return false;
		if (id != other.id)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (units != other.units)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", category=" + category + ", cost=" + cost
				+ ", units=" + units + "]";
	}
	@Override
	public int compareTo(Product o) {
		return this.cost - o.getCost();
	}
	
	
	

}
