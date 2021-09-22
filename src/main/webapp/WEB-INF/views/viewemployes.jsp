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
  
   background-image: url("images/reception.jpg");
  
}
</style>
</head>
<script>
	function confirmDelete(){
		return confirm("Are you sure, you want to delete?")
	}
</script>
<body class="content">
<a href="/add-new-employee">+Add New Employee</a>
	<h3 style="margin-left:30%;margin-top:120px;" class="text-primary">Employees List</h3>
	<table border="2"   >
		<thead>
			<tr>
				<th bgcolor="green">S.no</th>
				<th bgcolor="green">EmployeeId</th>
				<th bgcolor="green">Employee-Name</th>
				<th bgcolor="green">Email</th>
				<th bgcolor="green">Password</th>
				<th bgcolor="green">Type_Of_Employee</th>
				<th bgcolor="green">work_Start_time</th>
				<th bgcolor="green">Work_End_time</th>
				<th bgcolor="green">Word No</th>
				<th bgcolor="green">Type_Of_Occupation</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contacts}" var="c" varStatus="count"><tr>
				<td bgcolor="yellow">${count.index+1}</td>
				<td bgcolor="yellow">${c.empid}</td>
				<td bgcolor="yellow">${c.name}</td>
				<td bgcolor="yellow">${c.email}</td>
				<td bgcolor="yellow">${c.password}</td>
				<td bgcolor="yellow">${c.type}</td>
				<td bgcolor="yellow">${c.stime}</td>
				<td bgcolor="yellow">${c.etime}</td>
				<td bgcolor="yellow">${c.wno}</td>
				<td bgcolor="yellow">${c.tyofocc}</td>
				<td><a href="editempcontact?empid=${c.empid}">Edit</a> &nbsp;
				<a href="deleteempcontact?empid=${c.empid}" onclick="return confirmDelete()" >Delete</a></td></tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${currPno > 1 }">
		<a href="get-all-employees?pno=${currPno-1}"> Previous</a>
	</c:if>
	
	<c:forEach begin="1" end="${tp}" var="pageNo">
		<c:choose>
		
			<c:when test="${currPno==pageNo}">
					${pageNo}
			</c:when>
			
			<c:otherwise>
				<a href="get-all-employees?pno=${pageNo}">${pageNo}</a>
			</c:otherwise>
		
		</c:choose>

	</c:forEach>
	
	<c:if test="${currPno < tp }">
		<a href="get-all-employees?pno=${currPno + 1}">Next</a>
	</c:if>
	<button class="btn btn-danger" style="margin-left:300px;"><a  href="/"> Home</a></button>
</body>
</html>