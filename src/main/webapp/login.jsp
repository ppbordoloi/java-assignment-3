<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>ToDo: Task Scheduler</title>
		<link rel="stylesheet" href="style.css">
	</head>
	
	<body>
		<jsp:include page="header.jsp"/>
			
			<form action="loginCheck" method="post">
				<table align="center">
					<tr>
						<td>User Id: </td>
						<td><input type="text" name="id"/></td>
					</tr>
					
					<tr>
						<td>Password: </td>
						<td><input type="text" name="pass"/></td>
					</tr>

					<tr>
						<td></td>
						<td><input type="submit" value="Login" /></td>
					</tr>

					<tr>
						<td></td>
						<td><a href="register">Register Here</a></td>
					</tr>
				</table>
		</form>

		<jsp:include page="footer.jsp"/>
	</body>
	
</html>