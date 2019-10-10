<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@page isELIgnored="false" %>
<html>
<body>
	<h3>Query Response</h3>
	<hr>
		<form:form action="respondquery" modelAttribute="query">
		<pre>
			<form:hidden path="query_id"/>
			Question		<form:input path="question" readonly="readonly"/>
			Response		<form:input path="resp"/>
			<form:hidden path="user.email"/>
			<form:hidden path="transporter.email"/>
				<input type="submit" value="Respond query"/>
			</pre>
		</form:form>
	<hr>
	<a href="transporter_home">Home</a>
</body>
</html>