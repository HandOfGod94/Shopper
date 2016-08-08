<%@page import="com.shopper.dao.ShoppingDataDao"%>
<%@page import="com.shopper.entity.ShoppingData"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction</title>
<link rel="stylesheet"
	href="<c:url value = "/resources/css/bootstrap.min.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/resources/css/style.css"/>">
<link href='https://fonts.googleapis.com/css?family=Lobster'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<% ArrayList<ShoppingData> shopDataList = ShoppingDataDao.read((String)session.getAttribute("id"));	 %>
	<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
	<script src="<c:url value = "/resources/js/bootstrap.min.js"/>"></script>

	<!-- Nav bar -->
	<nav class="navbar navbar-default navbar-static">
	<div class="container-fluid">
		<div class="navbar-header">
			<button class="collapsed navbar-toggle" type="button"
				data-toggle="collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Shopper</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="/Shopper/">Home</a></li>
		</ul>
	</div>
	</nav>

	<!-- ---------------------------------- -->

	<div class="container">
		<h1>Transaction</h1>
		<form class="form-horizontal"
			action="/Shopper/shopManage/performTransaction" method="get">
			<div class="form-group">
				<label for="rating" class="col-sm-2 control-label">Select
					Transaction</label>
				<div class="col-sm-10">
					<label class="radio-inline"> 
					<input type="radio" name="transaction_type" value="1" required>Sales
					</label> <label class="radio-inline"> 
					<input type="radio" name="transaction_type" value="2">Return
					</label>
				</div>
			</div>
			<div class="form-group">
				<label for="product" class="col-sm-2 control-label">Product</label>
				<div class="col-sm-10">
					<select class="form-control" name="product_id" required>
						<c:forEach items="${shopDataList}" var="data">
							<option value="${data.productId}">${data.productName}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="quantity" class="col-sm-2 control-label">Quantity</label>
				<div class="col-sm-10">
					<input class="form-control" type="number" name="quantity" required>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" value="Submit" class="btn btn-default" />
				</div>
			</div>
		</form>
		<div class="row">
			<div class="col-sm-offset-2 col-sm-10 ${typeOfSuccess}">${successMessage}</div>
		</div>
</body>
</html>