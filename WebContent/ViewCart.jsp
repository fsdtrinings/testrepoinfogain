<%@page import="com.ig.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="HeaderPage.jsp" />
	<h1>User Cart </h1>
	<Table class="table table-striped">
		<%
			List<Product> cart = (List<Product>) session.getAttribute("userCart");
			int totalCost = 0;
			System.out.print("Inside View Cart 1 :- "+cart.size());
			
			
		for (Product p : cart) {
			System.out.print("Inside View Cart 2 Product :- "+p);
			String productName = p.getProductName();
			int cost = p.getCost();
			int pid = p.getId();
		%>
		<tr>
				<td> <%=productName %>  </td>
				<td> <%=cost%> </td>
				<td> <a href="RemoveServlet?pid=<%=pid%>">remove from cart</a> </td>
		</tr>
		<%
			totalCost+=cost;
			} //end of for
		%>
	</Table>

	Total Value <%=totalCost%>


</body>
</html>