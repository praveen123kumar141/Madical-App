<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<h3 style="margin-left:30%" class="text-primary">View Contacts</h3>
	<table  border="2">
		<thead>
			<tr>
			<th style="width:500px">contact Id: &nbsp;&nbsp;${contact.contactId}</th>
			<th style="width:500px">AAdhar no:&nbsp;&nbsp; ${contact.aadharno}</th>
			<th style="width:500px">Name :&nbsp;&nbsp; ${contact.contactName}</th>
			</tr>
			<tr>
			<th style="width:500px">gender:&nbsp;&nbsp; ${contact.gender}</th>
			<th style="width:500px">contact Number :&nbsp;&nbsp; ${contact.contactNumber}</th>
			</tr>
			<tr>
			<th style="width:500px">city :&nbsp;&nbsp; ${contact.city}</th>
			<th style="width:500px">state :&nbsp;&nbsp; ${contact.state}</th>
			<th style="width:500px">country:&nbsp;&nbsp; ${contact.country}</th>
			</tr>
			<tr>
			<th style="width:500px">Problem :&nbsp;&nbsp; ${contact.problem}</th>
			</tr>
		</thead>
	</table>
	<br/><br/>
	
	<table border="2" >
		<thead>
			<tr>
				<th bgcolor="green">S.no</th>
				<th bgcolor="green">Date</th>
				<th bgcolor="green">suggestion</th>
				<th bgcolor="green">prescription</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${suggessions}" var="c" varStatus="count"><tr>
				<td bgcolor="yellow">${count.index+1}</td>
				<td bgcolor="yellow">${c.date}</td>
				<td bgcolor="yellow">${c.sugg}</td>
				<td bgcolor="yellow">${c.pre}</td>
			</tr>
		</c:forEach>
		</tbody>
		</table>
	
		<a href="/welcome-doctor">GO TO Doctor Welcome page</a>
		<button class="btn btn-danger" style="margin-left:300px;"><a  href="/"> Home</a></button>
</body>
</html>