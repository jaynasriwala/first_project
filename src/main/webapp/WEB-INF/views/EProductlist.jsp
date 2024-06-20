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
	<%
	List<EProductBean> products = (List<EProductBean>) request.getAttribute("products");
	%>

	<table border="1">
		<tr>
			<th>ProductId</th>
			<th>ProductName</th>
		</tr>
		<%
		for (EProductBean p : products) {
			out.print("<tr>");
			out.print("<td>" + p.getProductId() + "</td><td>" + p.getProductName() + "</td>");
			out.print("</tr>");
		}
		%>
		
	</table>
</body>
</html>