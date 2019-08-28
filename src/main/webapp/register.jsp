<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="style.css">
	</head>
	
	<body>
		<jsp:include page="header.jsp"/>

		<form action="registered" method="post">
			<table align="center">
				<tr>
					<td>User Id</td>
					<td><input type="text" name="id"></td>
				</tr>
				
				<tr>
					<td>Name</td>
					<td><input type="text" name="name"></td>
				</tr>
				
				<tr>
					<td>Password</td>
					<td><input type="password" name="pass"></td>
				</tr>
				
				<tr>
					<td><input type="submit" name="Register"></td>
				</tr>
			</table>
		</form>
		
		<div style="color:red;">${ errorMessage }</div>
		<jsp:include page="footer.jsp"/>
	</body>
</html>