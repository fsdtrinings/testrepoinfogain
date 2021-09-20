<%@page import="com.ig.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String username = (String) session.getAttribute("username");
		List<Product> cart = (List<Product>)session.getAttribute("userCart");
		System.out.println("Inside Header jsp "+cart);
		int cartSize= 0;
		if(cart!=null)cartSize = cart.size();
	%>

	<div>
		<div>
			<h1>MyEcomWeb Application</h1>
		</div>

		<%
			if (username != null) {
		%>
		<div style="margin-left: 60%">
			<table>
				<tr>

					<td>Welcome <%=username%>
					</td>
				</tr>
				<tr>
					<td><a href="LogoutServlet">Logout</a></td>
					<td>
						<a href="ViewCart.jsp">View Cart (<%=cartSize%>)</a>
					</td>
					
				</tr>

			</table>
		</div>
		<%
			} //end of if(username is not null)
		%>

<div>
	<table>
		<tr> 
			<td> <a href="index.jsp">Home</a> </td>
			<td> <a href="#">About Us</a> </td>
			<td> <a href="#">Services</a> </td>
			
			
		</tr>
	</table>
</div>


	</div>

	<hr />
</body>
</html>