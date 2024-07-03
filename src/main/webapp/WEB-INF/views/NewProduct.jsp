<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>add new product</h2>


<form action="newproduct" method="post" enctype="multipart/form-data">


	productName <input type="text" name="productName" value="${productname}">
	 <span style="color:red">${nameError}</span> <br><br>
	price <input type="text" name="price"> <br><br>
	qty <input type="text" name = "qty"> <br><br>
	category <input type="text" name="category"><br><br>
	
	MasterImage : <input type="file" name="masterImage"/><br><BR> 
		
	
	
	<input type="submit" value="add new product"> 
</form>
</body>
</html>