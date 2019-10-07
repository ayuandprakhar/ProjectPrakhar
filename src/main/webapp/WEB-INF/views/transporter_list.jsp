<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<html>
<body>
<h3>Transporter List</h3>
<table border="2">
	<tr>
		<td>ID</td><td>Transporter Name</td><td>Email</td><td>Address</td><td>Mobile</td><td>Transporter PAN No.</td><td>Transporter GST No.</td><td>Id Proof</td><td>Approve Transporter</td><td>Reject Transporter</td>
	</tr>
	
	<jstl:forEach  var="transporter" items="${transporters}">
		<tr>
			<td>${transporter.transporter_id}</td>
			<td>${transporter.transporter_firm_name}</td>
			<td>${transporter.email}</td>
			<td>${transporter.transporter_address}</td>
			<td>${transporter.mobile}</td>
			<td>${transporter.transporter_pan_no}</td>
			<td>${transporter.transporter_gst_no}</td>
			<td><img width="50" height="50" src="showimage?number=${transporter.email}"/></td>
			<td><a href="approvetransporter?number=${transporter.email}">Approve</a></td>
			<td><a href="rejecttransporter?number=${transporter.email}">Reject</a></td>
		</tr>
	</jstl:forEach>
</table>
<hr>
<a href="admin_home">Home</a>
</body>
</html>