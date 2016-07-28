<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		<form>
			<input type="radio" name="option" value="sales" checked>
			Sales<br> <input type="radio" name="option" value="return">
			Return<br>
			<center>
				<label for="ProductName">ProductName</label> <select
					id="ProductName" name="ProductName">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
				</select> Quantity: <input type="text" name="Quantity" /> <input
					type="submit" value="Submit">
			</center>
		</form>
	</div>
</body>
</html>