<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@page isELIgnored="false" %>
<html>
<body>
	<h3>Transporter Registration</h3>
	<hr>
		<form:form action="updateTransporter" modelAttribute="transporter" enctype="multipart/form-data">
		<pre>
			Id				<form:input path="transporter_id"/>
			Firm Name   		<form:input path="transporter_firm_name"/>
			Email			<form:input path="email" readonly="readonly"/>
			Password		<form:password path="password"/>
			Address			<form:input path="transporter_address"/>
			Mobile			<form:input path="mobile"/>
			PAN No			<form:input path="transporter_pan_no"/>
			GST No			<form:input path="transporter_gst_no"/>
			ID Proof		<input type="file" name="image"/>
				<input type="submit" value="Update"/>
			</pre>
		</form:form>
	<hr>
	<a href="trasporter_home">Home</a>
</body>
</html>