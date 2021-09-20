package com.ig.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ig.model.Product;
import com.ig.model.User;

public class LoginDBClass {

	Connection con;
	PreparedStatement ps;
	
	public LoginDBClass() {
		con = DBConfig.con;
	}
	
	
	
	
	public boolean validateLogin(String username,String password)throws Exception
	{
		boolean isValidated = false;
		
		String sql = "select * from EComUser where username = ? and password = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1,username);
		ps.setString(2,password);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			isValidated = true;
		}
		
		
		return isValidated;
		
	}
}
