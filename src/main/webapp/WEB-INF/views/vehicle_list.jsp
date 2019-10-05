<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<html>
<body>
<h3>Vehicle List</h3>
<table border="2">
	<tr>
		<td>RC No</td><td>Model</td><td>Type</td><td>Proof</td><td>Update Details</td><td>Remove Vehicle</td>
	</tr>
	
	<jstl:forEach  var="vehicle" items="${vehicle}">
		<tr>
			<td>${vehicle.number}</td>
			<td>${vehicle.model}</td>
			<td>${vehicle.type}</td>
			<%-- <td>${vehicle.registration}</td> --%>
			<td><img width="50" height="50" src="viewimage?number=${vehicle.number}"/></td>
			<td><a href="updatevehicle?number=${vehicle.number}">Update</a></td>
			<td><a href="removevehicle?number=${vehicle.number}">Remove</a></td>
		</tr>
	</jstl:forEach>
</table>
<hr>
<a href="transporter_home">Home</a>
</body>
</html>