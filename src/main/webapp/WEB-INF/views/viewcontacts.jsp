<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>


.content {
  max-width: 500px;
  margin: auto;
  background:white;
  padding: 10px;
    background-image: url("images/rece.jpg");
  
}
</style>
</head>
<script>
	function confirmDelete(){
		return confirm("Are you sure, you want to delete?")
	}
</script>
<body class="content">

<a href="/loadform">+Add contact</a>
	<h3 style="margin-left:30%" class="text-primary">View Contacts</h3>
	<table border="2" >
		<thead>
			<tr>
				<th bgcolor="green">S.No</th>
				<th bgcolor="green">contact Id</th>
				<th bgcolor="green">Aadhar No</th>
				<th bgcolor="green">contact Name</th>
				<th bgcolor="green">Gender</th>
				<th bgcolor="green">contact Number</th>
				<th bgcolor="green">City</th>
				<th bgcolor="green">State</th>
				<th bgcolor="green">Country</th>
				<th bgcolor="green">Problem</th>
				<th bgcolor="green">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contacts}" var="c" varStatus="count"><tr>
				<td bgcolor="yellow">${count.index+1}</td>
				<td bgcolor="yellow">${c.contactId}</td>
				<td bgcolor="yellow">${c.aadharno}</td>
				<td bgcolor="yellow">${c.contactName}</td>
				<td bgcolor="yellow">${c.gender}</td>
				<td bgcolor="yellow">${c.contactNumber}</td>
				<td bgcolor="yellow">${c.city}</td>
				<td bgcolor="yellow">${c.state}</td>
				<td bgcolor="yellow">${c.country}</td>
				<td bgcolor="yellow">${c.problem}</td>
				<td><a href="editcontact?cid=${c.contactId}">Edit</a> &nbsp;
				<a href="deletecontact?cid=${c.contactId}" onclick="return confirmDelete()" >Delete</a></td></tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- bellow code is pagination implementation code -->
	<c:if test="${currPno > 1 }">
		<a href="viewContacts?pno=${currPno-1}"> Previous</a>
	</c:if>
	
	<c:forEach begin="1" end="${tp}" var="pageNo">
		<c:choose>
		
			<c:when test="${currPno==pageNo}">
					${pageNo}
			</c:when>
			
			<c:otherwise>
				<a href="viewContacts?pno=${pageNo}">${pageNo}</a>
			</c:otherwise>
		
		</c:choose>

	</c:forEach>
	
	<c:if test="${currPno < tp }">
		<a href="viewContacts?pno=${currPno + 1}">Next</a>
	</c:if>
	<button class="btn btn-danger" style="margin-left:300px;"><a  href="/"> Home</a></button>
</body>
</html>