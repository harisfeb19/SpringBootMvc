<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="https://thymeleaf.org">
<head>	
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
		<form action = "AddEmployees">
			
			<label>Id  : <input type="text" name="id"><br></label>
				
			<label>Name: <input type="text" name="name"><br>	</label>
					
			<label>Designation: </label>
			<input type="text" name="designation"><br>
			<input type ="submit">
		</form>
	
		<br>
		
		<form action = "getEmployees">
			
			<label>Id          :</label>
			<input type="text" name="id"><br>		
			<input type ="submit">
		</form>
</body>
</html>