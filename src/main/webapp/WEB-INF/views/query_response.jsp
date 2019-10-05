<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@page isELIgnored="false" %>
<html>
<body>
	<h3>User Registration</h3>
	<hr>
		<form:form action="respondquery" modelAttribute="query">
		<pre>
			Question		<form:input path="question"/>
			Response		<form:input path="resp"/>
				<input type="submit" value="Respond query"/>
			</pre>
		</form:form>
	<hr>
	<a href="index.jsp">Home</a>
</body>
</html>