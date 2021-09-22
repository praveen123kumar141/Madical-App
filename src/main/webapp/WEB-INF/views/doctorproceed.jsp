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
.inp{
width:500px;
height:50px;}

.content {
  margin: auto;
  background:#34d5eb;
  padding: 10px;
   background-image: url("images/doctor.jpg");
}
.con{
width:500px;
margin: auto;
  padding: 10px;
}
</style> 
</head>
<body class="content">
<p ><font color='green'>${succ}</font></p>
<p ><font color='red'>${err}</font></p>
<form:form action="/save-doct-sugg" modelAttribute="suggn">
	<label>patient id:</label>
	<form:input path="pId" /><br/><br/>
	<label>Doctor suggestion</label>&nbsp;&nbsp;
		<form:input path="sugg" class="inp"/><br/><br/><br/>
		<label>Doctor prescription</label>
		<form:input path="pre" class="inp"/><br/>
		<input type="submit" class="btn btn-success" value="save" />
</form:form>
<a href="/welcome-doctor">GO TO Doctor Welcome page</a>
<button class="btn btn-danger" style="margin-left:300px;"><a  href="/"> Home</a></button>
</body>
</html>