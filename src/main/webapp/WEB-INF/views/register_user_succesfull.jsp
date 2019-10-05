<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h3>Success</h3>
<hr>
	<table border="2">
	
	<tr>
		<th>User ID</th><th>User Name</th><th>Email</th><th>Address</th><th>Mobile</th>
	<tr>
	<c:forEach var="user" items="${user}">
		<tr>
			<td>${user.user_id}</td>
			<td>${user.user_name}</td>
			<td>${user.email}</td>
			<td>${user.address}</td>
			<td>${user.mobile}</td>
		</tr>
	</c:forEach>
	</table>
	<a href="index.jsp">Home</a><br>
<hr>
</body>
</html>