<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

			<H1> Welcome </H1>
			
			<%
				String arr[]={"Button1","But"};
				// scriptlet tag
				for(int i = 0;i<10;i++)
				{
					out.print("<input type='button' value='doThis'>");			
				}
			%>


</body>
</html>