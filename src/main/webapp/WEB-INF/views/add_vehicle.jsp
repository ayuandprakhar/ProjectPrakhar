<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@page isELIgnored="false" %>
<html>
<body>
	<h3>Add a new Vehicle</h3>
	<hr>
		<form:form action="addvehicle" modelAttribute="vehicle" enctype="multipart/form-data">
		<pre>
			RC No 		<form:input path="number"/>
			Model		<form:input path="model"/>
			Type		<form:input path="type"/>
			Proof		<input type="file" name="image"/>
				<input type="submit" value="Add Vehicle"/>
			</pre>
		</form:form>
	<hr>
	<a href="transporter_home">Home</a>
</body>
</html>