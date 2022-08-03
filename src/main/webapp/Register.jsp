<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="./css/Register.css" rel="stylesheet" type="text/css">

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
	<form method="post" action="Register">
		<div class="card">
			<input type="text" name="username" placeholder="Username"> <input
				type="text" name="password" placeholder="Password"> <input
				type="radio" value="admin" name="role">ADMIN <input
				type="radio" value="employee" name="role">USER <input
				type="submit" value="Register">
		</div>
	</form>
</body>
</html>