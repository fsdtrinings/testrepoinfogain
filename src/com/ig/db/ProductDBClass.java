package com.ig.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ig.model.Product;

public class ProductDBClass {
	Connection con;
	PreparedStatement ps;

	public ProductDBClass() {
		con = DBConfig.con;
	}
	
	public Product getProductbasedonId(int id)throws Exception
	{
		Product p = null;
		
		String sql = "select * from EComProduct where id = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			p = new Product();
			p.setProductName(rs.getString("productName"));
			p.setCost(rs.getInt("cost"));
			p.setCategory(rs.getString("category"));
			p.setUnits(rs.getInt("units"));
		}
		return p;
	}
	
	public boolean insertProduct(Product p)throws Exception
	{
		String sql = "insert into EComProduct values(?,?,?,?,?)";
		
		ps = con.prepareStatement(sql);
		ps.setInt(1,p.getId());
		ps.setString(2, p.getProductName());
		ps.setString(3, p.getCategory());
		ps.setInt(4,p.getCost());
		ps.setInt(5,p.getUnits());
		
		int x = ps.executeUpdate();
		if(x>0) return true;
		else return false;
	}
	
	
	public List<Product> getAllProductsByKeyword(String keyword)throws Exception
	{
		List<Product> list = new ArrayList<>();
		
		String sql = "select * from EcomProduct where category = ?";
		
		ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		
		
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			
			int id = rs.getInt("id");
			String productName = rs.getString("productName");
			String category = rs.getString("category");
			int cost = rs.getInt("cost");
			int units = rs.getInt("units");

			Product p = new Product(id, productName, category, cost, units);
			list.add(p);
			
		}
		
		
		return list;
	}
	
}
