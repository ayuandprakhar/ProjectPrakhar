<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@page isELIgnored="false" %>
<html>
<body>
	<h3>Post a Deal, ${username}</h3>
	<hr>
		<form:form action="adddeal" modelAttribute="deal">
		<pre>
			Deal No			<form:input path="deal_no"/>
			Description		<form:input path="deal_description"/>
			Date			<form:input path="date"/>
			Destination		<form:input path="goingto_city"/>
			Price			<form:input path="price"/>
			Vehicle			<form:select path="vehicle.number" items="${number}"/>
							<form:hidden path="transporter.email" value="${email }"/> 		
				<input type="submit" value="Submit"/>
			</pre>
		</form:form>
	<hr>
	<a href="transporter_home">Home</a>
</body>
</html>