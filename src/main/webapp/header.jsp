<div class="page-header">
<%
String loggedInUsername = (String) session.getAttribute("loggedInUsername");
if (loggedInUsername != null) {
%>
Welcome <%= loggedInUsername %> to TODO Application
<div style="float:right"><a href="logout">Logout</a></div>
<%
}
else {
%>
    <a href="<%= request.getContextPath() %>">TODO Application</a>
<%
}
%>
</div>

<div class="page-content">