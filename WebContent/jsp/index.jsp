<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopper</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="<c:url value = "/resources/css/bootstrap.min.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>">
<link
	href='https://fonts.googleapis.com/css?family=Oleo+Script+Swash+Caps:400,700'
	rel='stylesheet' type='text/css'>
<style>
body {
	background-image: url("<c:url value="/resources/images/main.png"/>");
	background-repeat: no-repeat;
	background-position: right top;
}
</style>
</head>
<body>
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

	<!-- navbar with shop and user options -->
	<div class="container">
		<div class="row">
		<div class="col-md-12">
			<h2  style="font-size:100px;color:aquamarine;font-family: 'Oleo Script Swash Caps', cursive;margin-top:150px;">S
			<span style="color:red">h</span> 
			<span style="color:lightblue">o</span>
			 <span style="color:purple">p</span> 
			 <span style="color:orange">p</span> 
			 <span style="color:pink">e</span> 
			 <span style="color:maroon">r</span> 
			</h2>
		</div>
		 </div>
		 <div class="row">
		 	<div class="col-sm-2" >
		 		<a href="/Shopper/shopManage/analysis" class="btn btn-default btn-lg" style="background-color:antiquewhite">ANALYSIS</a>
		 	</div>	
		 	<div class="col-sm-2" >
		 		<a href="/Shopper/shopManage/transaction" class="btn btn-default btn-lg" style="background-color:antiquewhite">TRANSACTION</a>
		 	</div>
		 	<div class="col-sm-2" >
		 		<a href="/Shopper/userComment" class="btn btn-default btn-lg" style="background-color:antiquewhite">FEEDBACK</a>
		 	</div>
		 </div>
	</div>
</body>
</html>