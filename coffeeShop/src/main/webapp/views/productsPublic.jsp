<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:f="http://xmlns.jcp.org/jsf/core">
<head>
<title>Products list</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

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
					<li class="active"><a href="/productsPublic">Products</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
	<h1>Product</h1>
		<div class="row">
			<div class="col col-lg-6">
				<table class="table" id="products">
					<thead class="thead-default">
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Description</th>
							<th>Price</th>
							<th>Type</th>
						</tr>
					</thead>
					<tbody>	
					<c:forEach var="product" items="${products}">
					<tr>
						<td>${product.id}</td>
						<td>${product.productName}</td>
						<td>${product.description}</td>
						<td>${product.price}</td>
						<td>${product.productType}</td>
						<td><a href="products/${product.id}"><button class="btn btn-warning btn-sm">edit</button></a></td>
						<td><form action="products/${product.id}/delete" method="POST">
						<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" /><button class="btn btn-danger btn-sm">delete</button></form></td>
					</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
	</div>
	</div>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>