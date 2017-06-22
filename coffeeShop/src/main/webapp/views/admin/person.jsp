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
					<li><a href="/products">Products</a></li>
					<li class="active"><a href="/person">Person</a></li>
					<li><a href="/orders">Orders</a></li>
				</ul>
				<div style="float:right">
					<a class="navbar-brand" href="/logout">Logout</a>
				</div>
			</div>
		</div>
	</nav>

	<div class="container">
	<h1>Person</h1>
		<div class="row">
			<div class="col col-lg-6">
				<table class="table" id="products">
					<thead class="thead-default">
						<tr>
							<th>ID</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Phone</th>
						</tr>
					</thead>
					<tbody>	
					<c:forEach var="person" items="${persons}">
					<tr>
						<td>${person.id}</td>
						<td>${person.firstName}</td>
						<td>${person.lastName}</td>
						<td>${person.email}</td>
						<td>${person.phone}</td>
						<td><a href="person/${person.id}"><button class="btn btn-warning btn-sm">edit</button></a></td>
						<td><form action="products/${person.id}/delete" method="POST">
						<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" /><button class="btn btn-danger btn-sm">delete</button></form></td>
					</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col col-lg-6">
				<form action="/person" method="POST">
					<div class="form-group">
						<label>First Name</label> <input type="text" class="form-control"
							name="firstName" />
					</div>
					<div class="form-group">
						<label>Last Name</label> <input type="text"
							class="form-control" name="lastName" />
					</div>
					<div class="form-group">
						<label>Email</label> <input type="text" class="form-control"
							name="email" />
					</div>
					<div class="form-group">
						<label>Phone</label> <input type="text" class="form-control"
							name="phone" />
					</div>
					<button type="submit" class="btn btn-primary form-control">CREATE</button>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
			</div>

	</div>
	</div>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>