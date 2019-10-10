<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@page isELIgnored="false" %>
<html>
<body>
	<h3>Query Registration</h3>
	<hr>
		<form:form action="submitquery" modelAttribute="query" >
		<pre>
			ID			<form:input path="query_id"/>
			Question		<form:input path="question"/>
			<form:hidden path="user.email" value="${email}"/>
			<form:hidden path="transporter.email" value="${deal.transporter.email}"/>
				<input type="submit" value="Submit query"/>
			</pre>
		</form:form>
	<hr>
	<a href="user_home">Home</a>
</body>
</html>