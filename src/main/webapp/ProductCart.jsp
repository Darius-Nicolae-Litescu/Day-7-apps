<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,darius.model.Product,darius.utils.CastUtils"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	CastUtils<Product> castUtils = new CastUtils<Product>();
	Object cartProducts = request.getAttribute("products");
	List<Product> cartproductList = castUtils.castObjectToList(cartProducts, Product.class);
	for (Product product : cartproductList) {
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
</html>