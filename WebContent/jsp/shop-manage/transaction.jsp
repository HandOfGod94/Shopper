<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction</title>
</head>
<style>
body {
	background-color: lightgreen;
}

input[type=text], select {
	width: 20%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 20%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

div {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>
<body>
	<div>
		<form method="get" action="/Shopper/shopManage/performTransaction">
			<!-- refer values with TransactionType enum class -->
			<input type="radio" name="transaction_type" value="1" checked>
			Sales<br> <input type="radio" name="transaction_type" value="2">
			Return<br>

			<center>
				<label for="ProductName">ProductName</label> 
				<select id="ProductName" name=product_id>
					<c:forEach items="${shopDataList}" var="data">
						<option value="${data.productId}">${data.productName}</option>
					</c:forEach>
				</select> 
				Quantity: <input type="text" name="quantity" /> 
				<input type="submit" value="Submit">
			</center>
		</form>
		${successMessage}
	</div>
</body>
</html>