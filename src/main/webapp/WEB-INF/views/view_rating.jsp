<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<html>
<body>
<h3>Transporter Ratings</h3>
<table border="2">
	<tr>
		<td>Rating No.</td><td>Tansporter Firm Name</td><td>Rating</td><td>Remove Transporter</td>
	</tr>
	
	<jstl:forEach  var="rating" items="${rating}">
		<tr>
			<td>${rating.id}</td>
			<td>${rating.transporter.transporter_firm_name}</td>
			<td>${rating.value}</td>
			<td><a href="removetransporter?number=${rating.transporter.email}">Remove</a></td>
		</tr>
	</jstl:forEach>
</table>
<hr>
<a href="admin_home">Home</a>
</body>
</html>