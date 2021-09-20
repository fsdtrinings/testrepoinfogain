package com.ig.ser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ig.db.ProductDBClass;
import com.ig.model.Product;




public class SearchServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String keyword = req.getParameter("keyword");
		
		
		try {
			
			HttpSession session = req.getSession(false);
			if(session!=null)
			{
				ProductDBClass obj = new ProductDBClass();
				List<Product> list = obj.getAllProductsByKeyword(keyword);
				
				int cashback = 0;
				String distributorName = "Web-Direct";
				
				if(keyword.equals("Laptop"))
					{
						cashback = 500;
						distributorName = "ABC-Hardware Pvt Ltd";
					}
				if(keyword.equals("Camera")) 
					{
						cashback = 1500;
						distributorName = "A Camera Store";
					}
				if(keyword.equals("Watch")) cashback = 100;
				
				
				session.setAttribute("user-pref-productList", list);
				session.setAttribute("cashBack", cashback);
				session.setAttribute("distributorInfo",distributorName);
				
				resp.sendRedirect("ProductSearchPage.jsp");
				
			}
			else
			{
				// user is not login 
				resp.sendRedirect("Login.jsp");
			}
			
			
			
		} catch (Exception e) {
			resp.sendRedirect("ErrorPage.jsp");
		}
		
		
	}
	

	
	
}
