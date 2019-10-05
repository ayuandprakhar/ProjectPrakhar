<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<html>
<body>
<h3>Vehicle List</h3>
<table border="2">
	<tr>
		<td>Deal No.</td><td>Transporter Name</td><td>Description</td><td>Date</td><td>Destination City</td><td>Price</td><td>Raise a Query</td>
	</tr>
	
	<jstl:forEach  var="deal" items="${deals}">
		<tr>
			<td>${deal.deal_no}</td>
			<td>${deal.transporter.transporter_firm_name}</td>
			<td>${deal.deal_description}</td>
			<td>${deal.date}</td>
			<td>${deal.goingto_city}</td>
			<td>${deal.price}</td>
			<td><a href="raisequery?number=${deal.transporter.transporter_id}id=${deal.user.user_id}">Raise Query</a></td>
		</tr>
	</jstl:forEach>
</table>
<hr>
<a href="user_home">Home</a>
</body>
</html>