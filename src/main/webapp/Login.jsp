<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="./css/Login.css" rel="stylesheet" type="text/css">

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String errorMessage = (String) request.getAttribute("errorMessage");
	if (errorMessage != null && errorMessage.length() > 0) {
	%>
	<h2 class="title" ><%=errorMessage%></h2> 
	<%
	}
	%>
	<form method="post" action="Login">
		<div class="card">
			<h2 class="title">Login page</h2> 
			<input type="text" name="username" placeholder="Username"> 
			<input type="text" name="password" placeholder="Password">
			<input type="submit" value="Login">
			<br /> <a href="Register.jsp" class="signup">Register</a>
		</div>
	</form>
</body>
</html>