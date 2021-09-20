package com.ig.test;

import com.ig.db.RegistrationDBClass;
import com.ig.model.User;

public class TestApp {

	public static void main(String[] args) {
		
		try {
			
			RegistrationDBClass dbTestObj = new RegistrationDBClass();
			boolean instertionStatus =  dbTestObj.doRegisterUser(new User("testuser","abc","a@gmail.com", "123-New Delhi"));
			System.out.println(instertionStatus);
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
