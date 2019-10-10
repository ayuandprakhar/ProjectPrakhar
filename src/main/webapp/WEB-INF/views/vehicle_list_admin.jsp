<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<html>
<body>
<h3>Vehicle List</h3>
<table border="2">
	<tr>
		<td>RC No</td><td>Model</td><td>Type</td><td>Proof</td><td>Approve Vehicle</td><td>Reject Vehicle</td>
	</tr>
	
	<jstl:forEach  var="vehicle" items="${vehicle}">
		<tr>
			<td>${vehicle.number}</td>
			<td>${vehicle.model}</td>
			<td>${vehicle.type}</td>
			<td>${vehicle.transporter.transporter_firm_name}</td>
			<td><img width="50" height="50" src="viewimage?number=${vehicle.number}"/></td>
			<td><a href="approvevehicle?number=${vehicle.number}">Approve</a></td>
			<td><a href="rejectvehicle?number=${vehicle.number}">Reject</a></td>
		</tr>
	</jstl:forEach>
</table>
<hr>
<a href="admin_home">Home</a>
</body>
</html>