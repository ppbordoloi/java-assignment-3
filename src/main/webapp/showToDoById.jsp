<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>View Your ToDo</title>
		<link rel="stylesheet" href="style.css">
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<jsp:include page="menu.jsp"/>
		
		<table align="center" style="margin-top:10px; margin-bottom:20px;">
			<tr>
				<td>Search:</td>
				<td><form action="searchById"><input type="text" name="id" placeholder="To Do Id"> <input type="submit" value="Search"> </form></td>
			</tr>
		</table>
		
		<table class="zdp-data-grid" align="center">
		
			<tr>
				<th>To Do Id:</th>
				<th>Name:</th>
				<th>Description:</th>
				<th>Date:</th>
				<th>Time</th>
			</tr>
			
			<c:if test="${not empty todo22}">
				<tr>
					<td> ${todo22.id} </td>
					<td> ${todo22.name} </td>
					<td> ${todo22.descrp} </td>
					<td> ${todo22.date} </td>
					<td> ${todo22.time} </td>
				</tr>
			</c:if>
			
			
			<c:if test="${empty todo22}">
				<tr>
					<td colspan="6">No ToDos match with the id</td>
				</tr>
			</c:if>
			
		</table>
	
		<jsp:include page="footer.jsp"/>
	</body>
</html>