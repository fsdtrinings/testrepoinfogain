package com.ig.ser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ig.db.LoginDBClass;
import com.ig.model.Product;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			
			LoginDBClass obj = new LoginDBClass();
			boolean validateStatus = obj.validateLogin(username, password);
			
			if(validateStatus)
			{
				List<Product> cart = new ArrayList<>(); // empty Cart
				
				HttpSession session = request.getSession(true); // new session will be created
				session.setAttribute("username", username);
				session.setAttribute("user-role","client");
				session.setAttribute("userCart",cart);
				response.sendRedirect("ProductSearchPage.jsp");
			}
			else
			{
				response.sendRedirect("Login.jsp");
			}
			
			
		} catch (Exception e) {
			response.sendRedirect("ErrorPage.jsp");
		}
	}

}
