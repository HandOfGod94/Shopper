<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Shop ID</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value = "/resources/css/style.css"/>">
	<link href='https://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>
</head>
<body>
	<div class="container" style="padding:50px">
    <div class="row" style="margin-top:50px">
        <div class="col-md-offset-4 col-md-4">
		<div class="form-login">
		<form action="/Shopper/" method="get">
            <h1 class="row text-center" >Shopper Login</h1>
            	<input type="text" id="shop-id-login" name="id" class=" row input-sm form-control chat-input" placeholder="Shop ID" />
            	<div class="wrapper">
            	<span class="group-btn row">
            		<input type="submit" value="Sumbit" class= "btn btn-primary btn-md"/>
            	</span>
            	</div>
            </form>
            </div>
        </div>
    </div>
    </div>
</body>
</html>