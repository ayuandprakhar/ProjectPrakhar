<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@page isELIgnored="false" %>
<html>
<body>
	<h3>User Registration</h3>
	<hr>
		<form:form action="updateuser" modelAttribute="user">
		<pre>
			User Name		<form:input path="user_name"/>
			Email			<form:input path="email" readonly="readonly"/>
			Password		<form:password path="password"/>
			Address			<form:input path="address"/>
			Mobile			<form:input path="mobile"/>
				<input type="submit" value="Update"/>
			</pre>
		</form:form>
	<hr>
	<a href="user_home">Home</a>
</body>
</html>