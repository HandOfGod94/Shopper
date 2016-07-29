<%@page import="com.shopper.dao.ShoppingDataDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.shopper.entity.ShoppingData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Analysis</title>
</head>
<body>
	<h2>Analysis Page</h2>
	<hr>
	<h3>Shop Details</h3>
		Owner:	${shop.owner} <br/>
		Address: ${shop.address} <br/>
		Contact: ${shop.contact} <br/>
	<hr>
	<h3>Sale Details</h3>
	<table cellpadding = 2 border = 2>
		<tr>
			<th>S.No.</th>
			<th>Product Name</th>
			<th>Sale Percentage</th>
			<th>Sale Category</th>
		</tr>
		<c:set scope="page"	var="i" value="${0}"/>
		<c:forEach items="${shopDataList}" var="data">
		<tr>
			<c:set scope="page" value="${i+1}" var="i"/>
			<td>${i}</td>
			<td>${data.productName}</td>
			<td>${data.salePercent}</td>
			<td>${data.saleCategory}</td>
		<tr>
		</c:forEach>
	</table>
</body>
</html>