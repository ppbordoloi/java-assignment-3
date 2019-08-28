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
				<td>
					<form action="searchById">
						<input type="text" name="id" placeholder="To Do Id"> 
						<input type="submit" value="Search"> 
					</form>
				</td>
			</tr>
		</table>
		
		<table class="zdp-data-grid" align="center">
			<tr>
				<th>To Do Id:</th>
				<th>Name:</th>
				<th>Description:</th>
				<th>Date:</th>
				<th>Time</th>
				<th>Action</th>
			</tr>

			<c:forEach var="tempTD" items="${ToDos}">
	
				<c:url var="updateLink" value="/showFormForUpdate">
					<c:param name="TDId" value="${tempTD.id}" />
				</c:url>
				<c:url var="deleteLink" value="/deleteLink">
					<c:param name="TDId" value="${tempTD.id}" />
				</c:url>
				
				<tr>
					<td> ${tempTD.id} </td>
					<td> ${tempTD.name} </td>
					<td> ${tempTD.descrp} </td>
					<td> ${tempTD.date} </td>
					<td> ${tempTD.time} </td>
					<td> <a href="${updateLink}">Update</a>/<a href="${deleteLink}">Delete</a> </td>
				</tr>
				
			</c:forEach>
			
			<c:if test="${empty ToDos}">
				<tr>
					<td colspan="6">No ToDos to Display</td>
				</tr>
			</c:if>
				
		</table>
	
		<jsp:include page="footer.jsp"/>
	</body>
</html>