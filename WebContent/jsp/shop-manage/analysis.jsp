<%@page import="com.shopper.dao.ShoppingDataDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.shopper.entity.ShoppingData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Analysis</title>
</head>
<%! int i = 0; %>
<%! ArrayList<ShoppingData> shopDataList = ShoppingDataDao.read("S1"); %>
<body>
	<h2>Analysis Page</h2>
	<hr>
	<h3>Shop Details</h3>
		Owner:	${shop.getOwner()} <br/>
		Address: ${shop.getAddress()} <br/>
		Contact: ${shop.getContact()} <br/>
	<hr>
	<h3>Sale Details</h3>
	<table cellpadding = 2 border = 2>
		<tr>
			<th>S.No.</th>
			<th>Product Name</th>
			<th>Sale Percentage</th>
			<th>Sale Category</th>
		</tr>
		<% for (ShoppingData data: shopDataList) { %>
		<tr>
			<td> <%= ++i %> </td>
			<td> <%= data.getProductName() %> </td>
			<td> <%= data.getSalePercent() %> % </td>
			<td> <%= data.getSaleCategory() %> </td>
		</tr>
		<% } %>
	</table>
</body>
</html>