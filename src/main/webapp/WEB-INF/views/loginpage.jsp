<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>


.content {

  margin: auto;
  background:#34d5eb;
  padding: 10px;
  background-image: url("images/login.jpg");
   width:500px;
   padding: 10px;
}
.con{
width:500px;
margin: auto;
  padding: 10px;
}
</style>
</head>
<body class="content"  >
<p><font color="red">${err}</font></p>
<h3 style=" margin-top: 130px;margin-left:100px;">Login page</h3>
<form:form action="/login-check" modelAttribute="loginobj" method="POST">
<table >
		<tr>
			<td>Employee id:</td>
			<td><form:input path="userid"/></td>
			
		</tr>
		<tr>
			<td>password: </td>
			<td><form:password path="pass" /></td>
			
		</tr>
		<tr>
		
			<td></td>
			<td><input type="submit" class="btn btn-success" value="save" /></td>
		</tr>
		</table>
</form:form>
</body>
</html>