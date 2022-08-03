<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,darius.model.Product"%>
<!DOCTYPE html>
<html>
<link href="./css/DisplayProducts.css" rel="stylesheet" type="text/css">

<head>
<meta charset="ISO-8859-1">
<title>Display products</title>
<body>

	<div class="container">
		<FORM action="DisplayProducts" method="post">
			<h4 style="display: auto">
				<b>Filter by product name: <input type="text"
					name="filterByName">
					<Button class="button-filter" type="submit">Filter</Button>
				</b>
			</h4>
		</FORM>
	</div>

	<%
	String username = (String) request.getAttribute("username");
	%>
	<h4>
		<b class="username-display">Welcome: <%=username%></b>
	</h4>
	<%
	List<Product> productList = (List<Product>) request.getAttribute("products");
	for (Product product : productList) {
	%>
	<div class="card">
		<img class="card-image" src="<%=product.getPictureHref()%>"
			alt="Avatar">
		<div class="container">
			<h4>
				<b>Product name: <%=product.getName()%></b>
			</h4>
			<p>
				Product code:
				<%=product.getProductCode()%></p>
			<p>
				Product price per unit:
				<%=product.getRonPricePerUnit()%>
				RON
			</p>
			<p>
				Product tax percentage:
				<%=product.getTaxPercentage()%>%
			</p>
			<p>
				Product available quantity:
				<%=product.getAvailableQuantity()%></p>
			<Button class="button">Add product to cart</Button>
		</div>
	</div>
	<%
	}
	%>

</body>
</head>
</html>