<%@page import="com.ig.db.ProductDBClass"%>
<%@page import="com.ig.model.Product"%>

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
		int pid = Integer.parseInt(request.getParameter("pid"));
		int cashBack = Integer.parseInt(request.getParameter("cashback"));
		String distributor = request.getParameter("distributorName");
		Product p = null;
		try
		{
			p = new ProductDBClass().getProductbasedonId(pid);
		}
		catch(Exception e)
		{
			response.sendRedirect("ErrorPage.jsp");
		}
	%>

	
	<jsp:include page="HeaderPage.jsp"/>
	<h1> <%=p.getProductName() %> </h1>
	<br/>
	Cost <%=p.getCost() %> <br/><br/>
	DistributorName <%=distributor %><br/><br/>
	cash back offer <%=cashBack %><br/><br/>
	
	<a href="CartServlet?pid=<%=p.getId()%>">Add to Cart</a><br/><br/>
	
	
</body>
</html>