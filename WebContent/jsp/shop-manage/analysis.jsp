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
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">

<link href='https://fonts.googleapis.com/css?family=Anton|Lobster'
	rel='stylesheet' type='text/css'>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
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
		'width' : 400,
		'height' : 300,
		'backgroundColor': 'transparent'
	};

	// Instantiate and draw our chart, passing in some options.
	var chart = new google.visualization.PieChart(document
			.getElementById('relative-sale-chart'));
	chart.draw(data, options);
}

</script>
</head>
<body>

	<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	
	<nav class="navbar navbar-default navbar-static" style="margin-bottom: 0px;">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Shopper</a>
			</div>
				<ul class="nav navbar-nav">
					<li><a href="/Shopper/">HOME</a></li>
				</ul>
		</div>
	</nav>
	
	<div class="container">
	<div class="row">
		<div class="col-md-12"><h1 class="text-center">Shopper Analysis</h1></div>
	</div>
	<div class="row"> 
		<div class="col-md-4 " >
			<div class="row">
			<h2 class="text-center">Overall Best Selling Product</h2>
				<h4>${overallMaxSoldProduct.name}</h4>
				<ul>
					<li><strong>Manufacturer:</strong>${overallMaxSoldProduct.manufacturer}</li>
					<li><strong>Category:</strong>${overallMaxSoldProduct.category}</li>
					<li><strong>Price:</strong>${overallMaxSoldProduct.price}</li>
				</ul>
			</div>
			<div class="row">
			<h2 class="text-center">Shop's Best Selling Product</h2>
				<h4>${shopMaxSoldProduct.name}</h4>
				<ul>
					<li><strong>Manufacturer:</strong>${shopMaxSoldProduct.manufacturer}</li>
					<li><strong>Category:</strong>${shopMaxSoldProduct.category}</li>
					<li><strong>Price:</strong>${shopMaxSoldProduct.price}</li>
				</ul>
			</div>
		</div>
		<div class="col-md-4">
			<div class="row">
			<h2 class="text-center">Overall Least Selling Product</h2>
				<h4>${overallLeastSoldProduct.name}</h4>
				<ul>
					<li><strong>Manufacturer:</strong>${overallLeastSoldProduct.manufacturer}</li>
					<li><strong>Category:</strong>${overallLeastSoldProduct.category}</li>
					<li><strong>Price:</strong>${overallLeastSoldProduct.price}</li>
				</ul>
			</div>
			<div class="row">
			<h2 class="text-center">Shop's Least Selling Product</h2>
				<h4>${shopLeastSoldProduct.name}</h4>
				<ul>
					<li><strong>Manufacturer:</strong>${shopLeastSoldProduct.manufacturer}</li>
					<li><strong>Category:</strong>${shopLeastSoldProduct.category}</li>
					<li><strong>Price:</strong>${shopLeastSoldProduct.price}</li>
				</ul>
			</div>
		</div>
		<div class="col-md-4">
			<h2 class="text-center">Pie Chart</h2>
			<div id="relative-sale-chart"></div>
		</div>
	</div>
	
	<!-- Latest compiled and minified JavaScript -->
		<div class="row">
			<div class="col-md-12" style="border-top-width:10px;border-bottom-width:10px; margin-top:100px; margin-bottom: 20px ">
			<h1> Sales Analysis</h1></div>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>S.No.</th>
					<th>Product Name</th>
					<th>Sale Percentage</th>
					<th>Sale Category</th>
					<th>Semantic Result</th>
				</tr>
			</thead>
			<tbody>
				<c:set scope="page" var="i" value="${0}" />
				<c:forEach items="${shopDataList}" var="data">
				<tr>
					<c:set scope="page" value="${i+1}" var="i" />
					<th scope="row">${i}</th>
					<td>${data.productName}</td>
					<td>${data.salePercent}</td>
					<td>${data.saleCategory}</td>
					<td>${semanticResults.get(i-1).toString()}</td>
				</tr>
				</c:forEach>	
			</tbody>
		</table>
		<div class="col-md-12" style="margin-top:50px">
			<h2>${shop.owner}</h2>
			<address>
			 	<strong>${shop.address}</strong><br>
  				<abbr title="Phone">Phone No.:</abbr> ${shop.contact}
			</address>
		</div>
	</div>
</body>
</html>