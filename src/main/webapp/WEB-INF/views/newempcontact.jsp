<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>


.content {
  margin: auto;
  background:#34d5eb;
  padding: 10px;
   background-image: url("images/reception.jpg");
}
.con{
width:500px;
margin: auto;
  padding: 10px;
}
</style>
</head>
<body class="content">
<script>
$( function() {
    $.datepicker.setDefaults({
        onClose:function(date, inst){
            $("#selectedDtaeVal").html(date);
        }
    });

    $( "#datepicker" ).datepicker();
});
</script>
<div >
<p><font color='green'>${succ}</font></p>
<p><font color='red'>${err}</font></p>
<form:form action="save-employee?empid=${contact.empid}" modelAttribute="contact" method="POST">
	<table >
		<tr>
			<td>Employee Name:</td>
			<td><form:input path="name"/></td>
			<td><form:errors path="name" class="text-danger"/></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><form:input path="email"/></td>
			<td><form:errors path="email" class="text-danger"/></td>
		</tr>
		<tr>
			<td>Employee Type:</td>
			<td>
			<form:radiobutton path="type" value="doctor"/>Doctor
			<form:radiobutton path="type" value="admin"/>Admin
			<form:radiobutton path="type" value="medical"/>medical
			<form:radiobutton path="type" value="receptionist"/>Receptionist
			<td><form:errors path="type" class="text-danger"/></td>
		</tr>
		<tr>
			<td>Work Start Time & End time:</td>
			<td><form:input path="stime" placeholder="start time >in 24 Hr format< "/>&nbsp;&nbsp;<form:input path="etime" placeholder="end time >in 24 Hr format< "/></td>
			<td><form:errors path="stime" class="text-danger"/>
			<form:errors path="etime" class="text-danger"/></td>
		</tr>
		<tr>
			<td>word No:</td>
			<td><form:input path="wno" placeholder="Example:-  10"/></td>
			<td><form:errors path="wno" class="text-danger"/></td>
		</tr>
		<tr>
			<td>Sub type of Occupation:</td>
			<td>
			<form:radiobutton path="tyofocc" value="Cardiologist"/>Cardiologist 
			<form:radiobutton path="tyofocc" value="Audiologist"/>Audiologist
			<form:radiobutton path="tyofocc" value="Dentist"/>Dentist
			<form:radiobutton path="tyofocc" value="ENT specialist"/>ENT specialist&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>
			<form:radiobutton path="tyofocc" value="Gynaecologist"/>Gynaecologist
			<form:radiobutton path="tyofocc" value="Orthopaedic"/>Orthopaedic
			<form:radiobutton path="tyofocc" value="Neurologist"/>Neurologist <br/>	
			<form:radiobutton path="tyofocc" value="Admin"/>Admin<br/>
			<form:radiobutton path="tyofocc" value="medical"/>medical<br/>
			<form:radiobutton path="tyofocc" value="receptionist"/>Receptionist
			</td>
				<td><form:errors path="tyofocc" class="text-danger"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" class="btn btn-success" value="save" /></td>
		</tr>
	</table>
</form:form>
<a  href="/get-all-employees"> View All contacts</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button class="btn btn-danger" style="margin-left:300px;"><a  href="/"> Home</a></button>
</div>

</body>
</html>