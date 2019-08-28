<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

	<head>
		<title>Update ToDo</title>
		<link rel="stylesheet" href="style.css">
	</head>

	<body>
		<jsp:include page="header.jsp"/>
		<jsp:include page="menu.jsp"/>
		<div id="wrapper" align="center">
			<div id="header">
				<h2>Update - To Do</h2>
			</div>
		</div>
	
		<div id="container" align="center">
			
			<form action="updateToDo" method="post">
				<input type="hidden" name="id" value="${toDo1.id}">
				<table>	
					<tr>
						<td>Name: </td>
						<td><input type="text" name="name" value="${toDo1.name}"></td>
					</tr>
					
					<tr>
						<td>Description: </td>
						<td><input type="text" name="descrp" value="${toDo1.descrp}"></td>
					</tr>
					
					<tr>
						<td>Date: </td>
						<td><input type="text" name="tdate" placeholder="YYYY-MM-DD" value="${toDo1.date}"></td>
					</tr>
			
					<tr>
						<td>Time: </td>
						<td><input type="text" name="time" value="${toDo1.time}"></td>
					</tr>
					
					<tr>
						<td><input type="submit" name="Save"></td>
					</tr>
				</table>
			</form>
		</div>
		
		<jsp:include page="footer.jsp"/>
	</body>
</html>