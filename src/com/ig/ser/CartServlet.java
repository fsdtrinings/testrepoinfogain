package com.ig.ser;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ig.db.ProductDBClass;
import com.ig.model.Product;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false); // 
		
		if(session!=null)
		{
			
			try {
				
				int pid = Integer.parseInt(request.getParameter("pid"));
				Product p = new ProductDBClass().getProductbasedonId(pid);
				
				List<Product> cart = (List<Product>)session.getAttribute("userCart");
				cart.add(p);
				session.setAttribute("userCart", cart);
				response.sendRedirect("ProductSearchPage.jsp");
				
			} catch (Exception e) {
				response.sendRedirect("ErrorPage.jsp");
			}
			
			
			
		}
		else
		{
			response.sendRedirect("Login.jsp");
		}
		
		
	}


}
