<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<html>
<body>
	<h3>Deal List</h3>
	<table border="2">
		<tr>
			<td>Deal No.</td>
			<td>Transporter Name</td>
			<td>Description</td>
			<td>Date</td>
			<td>Destination City</td>
			<td>Price</td>
			<td>Raise a Query</td>
			<td>Rate</td>
		</tr>

		<jstl:forEach var="deal" items="${deal}">
			<tr>
				<td>${deal.deal_no}</td>
				<td>${deal.transporter.transporter_firm_name}</td>
				<td>${deal.deal_description}</td>
				<td>${deal.date}</td>
				<td>${deal.goingto_city}</td>
				<td>${deal.price}</td>
				<td><a href="raisequery?number=${deal.deal_no}">Raise Query</a></td>
				<td>
					<form action="rateTransporter">
						<input hidden="email" value=${ deal.transporter.email} name="email">
						<input onChange="this.form.submit();" type="radio" name="ratingValue" value="1"> 
						<input onChange="this.form.submit();" type="radio" name="ratingValue" value="2"> 
						<input onChange="this.form.submit();" type="radio" name="ratingValue" value="3"> 
						<input onChange="this.form.submit();" type="radio" name="ratingValue" value="4"> 
						<input onChange="this.form.submit();" type="radio" name="ratingValue" value="5">
					</form>

				</td>
			</tr>
		</jstl:forEach>
	</table>
	<hr>
	<a href="transporter_home">Home</a>
</body>
</html>