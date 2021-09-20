package com.ig.ser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ig.db.RegistrationDBClass;
import com.ig.model.User;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		User user = new User(username, password, email, address);
		try {
		
			RegistrationDBClass dbTestObj = new RegistrationDBClass();
			boolean instertionStatus =  dbTestObj.doRegisterUser(user);
			
			if(instertionStatus)
			{
				
				response.sendRedirect("Login.jsp");
			}
			else
			{
				response.sendRedirect("ErrorPage.jsp");	
			}
			
		} catch (Exception e) {
			response.sendRedirect("ErrorPage.jsp");
		}
		
	}

}
