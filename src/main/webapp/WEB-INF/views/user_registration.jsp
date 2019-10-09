<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@page isELIgnored="false" %>
<html>
<body>
	<h3>User Registration</h3>
	<hr>
		<form:form action="adduser" modelAttribute="user">
		<pre>
			User ID			<form:input path="user_id"/> <form:errors path="user_id"/>
			User Name		<form:input path="user_name"/> <form:errors path="user_name"/>
			Email			<form:input path="email"/> <form:errors path="email"/>
			Password		 <form:password path="password"/> <form:errors path="password"/>
			Address			<form:input path="address"/> <form:errors path="address"/>
			Mobile			<form:input path="mobile"/> <form:errors path="mobile"/>
				<input type="submit" value="Register"/>
			</pre>
		</form:form>
	<hr>
	<a href="index.jsp">Home</a>
</body>
</html>