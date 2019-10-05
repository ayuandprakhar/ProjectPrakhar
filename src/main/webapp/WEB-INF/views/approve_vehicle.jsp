<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<html>
<body>
<h3>Vehicle List</h3>
<table border="2">
	<tr>
		<td>RC No</td><td>Model</td><td>Type</td><td>Proof</td><td>Transporter Name</td><td>Approve Vehicle</td><td>Reject Vehicle</td>
	</tr>
	
	<jstl:forEach  var="vehicle" items="${vehicles}">
		<tr>
			<td>${vehicle.number}</td>
			<td>${vehicle.model}</td>
			<td>${vehicle.type}</td>
			<td>${vehicle.registration}</td>
			<td>${vehicle.transporter.transporter_firm_name}</td>
			<td><a href="approvevehicle?number=${vehicle.number}">Approve</a></td>
			<td><a href="rejectvehicle?number=${vehicle.number}">Reject</a></td>
		</tr>
	</jstl:forEach>
</table>
<hr>
<a href="admin_home">Home</a>
</body>
</html>