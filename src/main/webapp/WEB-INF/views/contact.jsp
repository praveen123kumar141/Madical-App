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
  background-image: url("images/rece.jpg");
}
.con{
width:500px;
margin: auto;
  padding: 10px;
}
</style>
</head>

<body class="content">
<h1 class="con">Register Contact</h1>
<div class="container "  >
	<p><font color='green'>${succmsg}</font></p>
	<p><font color='red'>${errmsg}</font></p>
	<form:form action="savecontact?contactId=${contact.contactId}" modelAttribute="contact" method="POST">
	<table >
		<tr>
			<td>AAdharNo:</td>
			<td><form:input path="aadharno"/></td>
			<td><form:errors path="aadharno" class="text-danger"/></td>
		</tr>
		<tr>
			<td>Contact Name</td>
			<td><form:input path="contactName"/></td>
			<td><form:errors path="contactName" class="text-danger"/></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td><form:radiobutton path="gender" value="Male"/>Male
			<form:radiobutton path="gender" value="Female"/>Female</td>
			<td><form:errors path="gender" class="text-danger"/></td>
		</tr>
		<tr>
			 <td>Contact Number</td>
			<td><form:input  path="contactNumber"/></td>
			<td><form:errors path="contactNumber" class="text-danger"/></td>
		</tr>
		<tr>
			 <td>City:</td>
			<td><form:input  path="city"/></td>
			<td><form:errors path="city" class="text-danger"/></td>
		</tr>
		<tr>
			 <td>State:</td>
			<td><form:input  path="state"/></td>
			<td><form:errors path="state" class="text-danger"/></td>
		</tr>
		<tr>
			 <td>Country:</td>
			<td><form:input  path="country"/></td>
			<td><form:errors path="country" class="text-danger"/></td>
		</tr>
		<tr>
			 <td>Problems:</td>
			<td>
			<form:radiobutton path="problem" value="Cardiologist"/>Cardiologist 
			<form:radiobutton path="problem" value="Audiologist"/>Audiologist
			<form:radiobutton path="problem" value="Dentist"/>Dentist
			<form:radiobutton path="problem" value="ENT specialist"/>ENT specialist&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>
			<form:radiobutton path="problem" value="Gynaecologist"/>Gynaecologist
			<form:radiobutton path="problem" value="Orthopaedic"/>Orthopaedic
			<form:radiobutton path="problem" value="Neurologist"/>Neurologist 	
			</td>
			<td><form:errors path="problem" class="text-danger"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" class="btn btn-success" value="save" /></td>
		</tr>
	</table>
	</form:form>
	<a  href="viewContacts"> View All contacts</a>
</div>
<button class="btn btn-danger" style="margin-left:300px;"><a  href="/"> Home</a></button>
</body>
</html>