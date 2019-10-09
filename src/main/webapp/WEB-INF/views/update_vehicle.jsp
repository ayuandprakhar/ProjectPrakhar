<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@page isELIgnored="false" %>
<html>
<body>
	<h3>Update Vehicle</h3>
	<hr>
		<form:form action="updatevehicle" modelAttribute="vehicle" enctype="multipart/form-data">
		<pre>
			RC No 		<form:input path="number" readonly="readonly"/>
			Model		<form:input path="model"/>
			Type		<form:input path="type"/>
			Proof		<input type="file" name="image"/>
			<form:hidden path="transporter.email"/>
				<input type="submit" value="Update Vehicle"/>
			</pre>
		</form:form>
	<hr>
	<a href="transporter_home">Home</a>
</body>
</html>