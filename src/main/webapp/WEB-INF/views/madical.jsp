<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  background-image: url("images/medical.jpeg");
}
.con{
width:500px;
margin: auto;
  padding: 10px;
}
</style>

</head>
<script>
	function confirmDelete(){
		return confirm("Are you sure, you want to delete?")
	}
</script>
<body class="content">
<h3 Style="margin-left:30%;margin-top:8%;">Madical patients List</h3>
<table border="2"  Style="margin-left:30%;" >
		<thead>
			<tr>
				<th bgcolor="green">S.no</th>
				<th bgcolor="green">Patient id</th>
				<th bgcolor="green">Date</th>
				<th bgcolor="green">precription</th>
				<th bgcolor="green">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${madical}" var="c" varStatus="count"><tr>
				<td bgcolor="yellow">${count.index+1}</td>
				<td bgcolor="yellow">${c.pId}</td>
				<td bgcolor="yellow">${c.date}</td>
				<td bgcolor="yellow">${c.pre}</td>
				<td>
				<a href="deleterecord?id=${c.id}" onclick="return confirmDelete()">Issued</a></td></tr>
			
		</c:forEach>
		</tbody>
		</table>

</body>
</html>