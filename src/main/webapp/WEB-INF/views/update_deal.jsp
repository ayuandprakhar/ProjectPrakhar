<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@page isELIgnored="false" %>
<html>
<body>
	<h3>Update the Deal, ${username}</h3>
	<hr>
		<form:form action="updatedeal" modelAttribute="deal">
		<pre>
			Deal No			<form:input path="deal_no" readonly="readonly"/>
			Description		<form:input path="deal_description"/>
			Date			<form:input path="date"/>
			Destination		<form:input path="goingto_city"/>
			Price			<form:input path="price"/>
			Vehicle			<form:select path="vehicle.number" items="${number}"/>
							<form:hidden path="transporter.email" value="${email }"/> 		
				<input type="submit" value="Update"/>
			</pre>
		</form:form>
	<hr>
	<a href="transporter_home">Home</a>
</body>
</html>