package com.ig.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/*
 * Step 2
 * Configuration class to configure database connection
 * */

public class DBConfig {
	public static Connection con; 

	static {
	     try{
		     Class.forName("oracle.jdbc.driver.OracleDriver");
		     con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","admin");
		     System.out.println("Connected :- "+con);
	     }
	     catch(Exception e)
	     {
	             System.out.println("con"+e);
	     }
	}//end constructor
	
	
	
	public static Connection getCon() {
		return con;
	}
	
}//end class
