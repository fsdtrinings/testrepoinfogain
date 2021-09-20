<%@page import="com.ig.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	
	<jsp:include page="HeaderPage.jsp"/>

	<form action="SearchServlet" method="post">
		Enter Search Keyword
		
		<!-- <input type="text" name="keyword"> --> 
		
		<select name="keyword">
			<option>Laptop</option>
			<option>Watch</option>
			<option>Camera</option>
			<option>Mobile Phone</option>
			
		</select>
		
		<input type="submit" value="Search">
	</form>
	<hr/>
	
	<%
	List<Product> list = (List<Product>)session.getAttribute("user-pref-productList");
	Integer cashBack = (Integer)session.getAttribute("cashBack");
	String distributor = (String)session.getAttribute("distributorInfo");
	
	
	
	if(list!= null)
	{
		%>
			<table class="table table-striped">
				<tr>
					<td> Product Name </td>
					<td> Cost </td>
					<td> Action </td>
				</tr>
		<%
		
		for(Product p:list)
		{
			String productName = p.getProductName();
			int cost = p.getCost();
			
			int productId = p.getId();
			
			%>
				<tr>
				
					<td> <a href="ProductInfoPage.jsp?distributorName=<%=distributor%>&cashback=<%=cashBack%>&pid=<%=productId%>"><%=productName%></a>  </td>
					<td> <%=cost %></td>
					<td><a href="CartServlet?pid=<%=productId%>">Add to Cart</a></td>
				</tr>
		<%
			
		}//end of for
		%>
		</table>
		<%
	}//end if list is not empty or not selected
	
	%>
	
	
</body>
</html>



















