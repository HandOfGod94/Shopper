<%@page import="com.shopper.dao.ProductCRUD"%>
<%@page import="com.shopper.entity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%! ArrayList<Product> products = null; %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Comment</title>
<script language="javascript">
function check()  
{

	chosen = ""
	len = document.myform.chk.length
	cmt=document.myform.comment.value.length
	
	for (i = 0; i <len; i++) 
	{
		if (document.myform.chk[i].checked)
		{
			chosen = document.myform.chk[i].value
		}
	}

	if (chosen == "" ) 
	{
		alert("Please Select Rating");
		return false;
	}
	else if(cmt=="" || cmt<=4) {
		alert( "Please enter comment");
		
	}
	else
		document.forms["myform"].submit();
	
}

</script>
</head>
<body>
<%
	products = ProductCRUD.read();
%>
	<h1>Comment</h1>
	<form action="/Shopper/addUserComment" method="get">
		<table cellpadding="5">
			<tr>
				<td>Product:</td>
				<td><select name="productId">
				<% for(Product product:products) { %>
					<option value="<%=product.getId() %>"><%= product.getName() %></option>
				<% } %>
				</select></td>
			</tr>
			<tr>
				<td>Rating:</td>
				<td>
					<% for (int i = 0; i < 10; i++) { %> 
					<input name="rating" type="radio" value=<%=(i + 1)%> /> <%= (i+1) %> &nbsp; &nbsp;
					<% } %>
				</td>
			</tr>
			<tr>
				<td>Comment:</td>
				<td><textarea rows="5" cols="50" name="comment"></textarea>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
	${result}
</body>
</html>