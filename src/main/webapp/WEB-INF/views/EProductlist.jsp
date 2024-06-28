<%@page import="com.bean.EProductBean"%>
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

<h1>List of all product</h1>

<a href="newproduct">Add New Product</a>
<br><br>
<a href="deletebyname">delete by name</a>

	<%
	List<EProductBean> products = (List<EProductBean>) request.getAttribute("products");
	%>

	
	<table border="1">
		<tr>
			<th>ProductId</th>
			<th>ProductName</th>
			<th>Action</th>
		</tr>
		<%
		for (EProductBean p : products) {
			out.print("<tr>");
			out.print("<td>" + p.getProductId() + "</td><td>" + p.getProductName() + "</td><td><a href='deleteproduct?productId="+p.getProductId()+"'>Delete</a> || <a href='viewproduct?productId="+p.getProductId()+"'>View</a></td>");
			out.print("</tr>");
		}
		%>
		
	</table>
</body>
</html>