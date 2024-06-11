<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>singup</h1>

<form action="/usersave" method="post">

First name: <input type="text" name="firstname"> <br><br>
email:<input type="text" name="email">   <br><br>
password: <input type="password" name="password">   <br><br>

<input type="submit" value="Submit">
</form>

</body>
</html>