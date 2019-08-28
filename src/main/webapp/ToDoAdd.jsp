<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

	<head>
		<title>Add Your ToDo</title>
		<link rel="stylesheet" href="style.css">
	</head>

	<body>
		<jsp:include page="header.jsp"/>
		<jsp:include page="menu.jsp"/>
	
		<div id="container" align="center">
			<h3>To Do</h3>
			
			<form action="saveToDo" method="post">
				<table >
					<tr>
						<td>Name: </td>
						<td><input type="text" name="name"></td>
					</tr>
					
					<tr>
						<td>Description: </td>
						<td><input type="text" name="descrp"></td>
					</tr>
					
					<tr>
						<td>Date: </td>
						<td><input type="text" name="tdate" placeholder="YYYY-MM-DD"></td>
					</tr>
					
					<tr>
						<td>Time: </td>
						<td><input type="text" name="hh" placeholder="HH"><input type="text" name="mm" placeholder="MM"></td>
					</tr>
					
					<tr>
						<td></td>
						<td><input type="submit" name="Save"></td>
					</tr>
				</table>
			</form>
		</div>
	
		<jsp:include page="footer.jsp"/>
	</body>

</html>