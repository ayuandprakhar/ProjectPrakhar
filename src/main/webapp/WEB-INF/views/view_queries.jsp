<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<html>
<body>
<h3>Query List</h3>
<table border="2">
	<tr>
		<td>Query No.</td><td>User Name</td><td>Query</td><td>Respond to Query</td>
	</tr>
	
	<jstl:forEach  var="query" items="${query}">
		<tr>
			<td>${query.query_id}</td>
			<td>${query.user.user_name}</td>
			<td>${query.question}</td>
			<td><a href="sendresponse?number=${query.query_id}">Send Response</a></td>
		</tr>
	</jstl:forEach>
</table>
<hr>
<a href="transporter_home">Home</a>
</body>
</html>