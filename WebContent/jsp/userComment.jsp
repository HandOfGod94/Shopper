<%@page import="com.shopper.dao.ProductCRUD"%>
<%@page import="com.shopper.entity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%! ArrayList<Product> products = null; %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Comment</title>
<link rel="stylesheet"
	href="<c:url value = "/resources/css/bootstrap.min.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/resources/css/style.css"/>">
<link href='https://fonts.googleapis.com/css?family=Lobster'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
	<script src="<c:url value = "/resources/js/bootstrap.min.js"/>"></script>

	<%
	products = ProductCRUD.read();
%>
	<!-- Nav bar -->
	<nav class="navbar navbar-default navbar-static">
	<div class="container-fluid">
		<div class="navbar-header">
			<button class="collapsed navbar-toggle" type="button" data-toggle="collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Shopper</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active">
			<a role="button" href="/Shopper/">Home</span>
			</a>
			</li>
		</ul>
	</div>
	</nav>

	<!-- ---------------------------------- -->

	<!-- user comments container -->
	<div class="container">
		<h1>User Comment</h1>
		<form class="form-horizontal" action="/Shopper/addUserComment" method="get">
			<div class="form-group">
				<label for="product" class="col-sm-2 control-label">Product</label>
				<div class="col-sm-10">
					<select class="form-control" name="productId" required>
						<% for(Product product:products) { %>
						<option value="<%=product.getId() %>"><%= product.getName() %></option>
						<% } %>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="rating" class="col-sm-2 control-label">Rating</label>
				<div class="col-sm-10">
					<% for (int i = 0; i < 10; i++) { %>
					<label class="radio-inline"> 
					<input type="radio" name="rating"  value=<%=(i + 1)%> required/> <%=(i+1) %> &nbsp; &nbsp;
					</label>
					<% } %>
				</div>
			</div>
			<div class="form-group" required>
				<label for="comment" class="col-sm-2 control-label">Comment</label>
				<div class="col-sm-10">
					<textarea class="form-control" rows="3" name="comment" required></textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" value="Submit" class="btn btn-default" />
				</div>
			</div>
		</form>
		<span class="col-sm-offset-2 ${typeOfResult}">${result}</span>
	</div>
</body>
</html>