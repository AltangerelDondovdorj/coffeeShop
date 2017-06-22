<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:f="http://xmlns.jcp.org/jsf/core">
<head>
<title>Products list</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript"
      src="webjars/jquery/2.2.4/jquery.min.js"></script>
      
 <script type="text/javascript"
      src="../../js/main.js"></script>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<link rel="stylesheet" th:href="@{/css/main.css}"
	href="../../css/main.css" />

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="/">Coffee Shop</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="/">Home</a></li>
					<li><a href="/products">Products</a></li>
					<li><a href="/person">Person</a></li>
					<li class="active"><a href="/orders">Orders</a></li>
				</ul>
				<div style="float:right">
					<a class="navbar-brand" href="/logout">Logout</a>
				</div>
			</div>
		</div>
	</nav>

	<div class="container">
	<h1>Order</h1>
		<div class="row">
			<div class="col col-lg-6">
				<table class="table" id="products">
					<thead class="thead-default">
						<tr>
							<th>ID</th>
							<th>orderDate</th>
							<th>Person</th>
						</tr>
					</thead>
					<tbody>	
					<c:forEach var="order" items="${orders}">
					<tr>
						<td>${order.id}</td>
						<td>${order.orderDate}</td>
						<td>${order.person.firstName}</td>
						<td><a href="orders/${order.id}">edit</a></td>
						<td><button onclick="showOrderline(${order.id})">show details</button></td>
					</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col col-lg-6">
			<c:forEach var="order" items="${orders}">
				<div id="order${order.id}" style="display:none;" class="orderLine">
				<table class="table table-stripes">
				<thead class="thead-default">
						<tr>
							<th>Product Name</th>
							<th>Quantity</th>
							<th>Price</th>
						</tr>
					</thead>
					<tbody>	
					<c:forEach var="oLine" items="${order.orderLines}">
						<tr>
							<td>${oLine.product.productName}</td>
							<td>${oLine.quantity}</td>
							<td>${oLine.product.price}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				</div>
				</c:forEach>
			</div>

	</div>
	</div>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>