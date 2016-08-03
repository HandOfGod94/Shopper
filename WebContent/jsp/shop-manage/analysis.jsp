<%@page import="com.shopper.dao.ShoppingDataDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.shopper.entity.ShoppingData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Analysis</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
//Load the Visualization API and the corechart package.
google.charts.load('current', {
	'packages' : [ 'corechart' ]
});

// Set a callback to run when the Google Visualization API is loaded.
google.charts.setOnLoadCallback(drawChart);

// Callback that creates and populates a data table,
// instantiates the pie chart, passes in the data and
// draws it.
function drawChart() {

	// Create the data table.
	var data = new google.visualization.DataTable();
	var productSaleMap = [];
	
	<c:forEach items = "${productSalePairs}" var = "pair">
		var arr = [];
		arr.push("<c:out value="${pair.getKey()}"/>");
		arr.push(<c:out value="${pair.getValue()}"/>);
		
		productSaleMap.push(arr);
	</c:forEach>
	
	data.addColumn('string', 'Product');
	data.addColumn('number', 'Sales');
	data.addRows(productSaleMap);

	// Set chart options
	var options = {
		'title' : 'Relative Product Sale',
		'width' : 600,
		'height' : 600
	};

	// Instantiate and draw our chart, passing in some options.
	var chart = new google.visualization.PieChart(document
			.getElementById('category-chart'));
	chart.draw(data, options);
}

</script>
</head>
<body>

	<h2>Analysis Page</h2>
	<hr>
	<h3>Shop Details</h3>
	Owner: ${shop.owner}
	<br /> Address: ${shop.address}
	<br /> Contact: ${shop.contact}
	<br />


	<hr>
	<h3>Overall Most selling Product:</h3>
	<table border=2 cellpadding=2>
		<tr>
			<th>S.No.</th>
			<th>Product Name</th>
			<th>Manufacturer</th>
			<th>Price</th>
			<th>Category</th>
		</tr>
		<tr>
			<td>1</td>
			<td>${overallMaxSoldProduct.name}</td>
			<td>${overallMaxSoldProduct.manufacturer}</td>
			<td>${overallMaxSoldProduct.price}</td>
			<td>${overallMaxSoldProduct.category}</td>
		</tr>
	</table>
	<hr>


	<h3>Sale Details</h3>
	<table cellpadding=2 border=2>
		<tr>
			<th>S.No.</th>
			<th>Product Name</th>
			<th>Sale Percentage</th>
			<th>Sale Category</th>
			<th>Semantic Result</th>
		</tr>
		<c:set scope="page" var="i" value="${0}" />
		<c:forEach items="${shopDataList}" var="data">
			<tr>
				<c:set scope="page" value="${i+1}" var="i" />
				<td>${i}</td>
				<td>${data.productName}</td>
				<td>${data.salePercent}</td>
				<td>${data.saleCategory}</td>
				<td>${semanticResults.get(i)}</td>
			<tr>
		</c:forEach>
	</table>

	<hr>

	<div id="category-chart"></div>

</body>
</html>