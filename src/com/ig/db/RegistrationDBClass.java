package com.ig.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ig.model.User;



public class RegistrationDBClass {
	
	Connection con;
	PreparedStatement ps;
	
	public RegistrationDBClass() {
		con = DBConfig.con;
	}
	
	public boolean doRegisterUser(User user)throws Exception
	{
		boolean isInserted = false;
		
		String sql = "insert into EComUser values(?,?,?,?)";
		
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getAddress());
		
		int rowInserted = ps.executeUpdate();
		if(rowInserted>0) isInserted = true;
		
		
		return isInserted;
		
	}

}
