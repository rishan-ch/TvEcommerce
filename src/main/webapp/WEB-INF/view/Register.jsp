<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheet/register.css"/>
</head>
<body>
	<div class="container">
		<h1>Registration Form</h1>

		<form action="<%=request.getContextPath() %>/register" method="post">
			<div class="row">
				<div class="col">
					<label for="fullName">full Name:</label> <input type="text"
						id="fullName" value="" name="fullName" required>
				</div>
				<div class="col">
					<label for="email">email:</label> <input type="email"
						id="email" name="email" required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="phone">phone:</label> <input type="text"
						id="phone" name="phone" required>
				</div>
				<div class="col">
					<label for="birthday">Birthday:</label> <input type="date"
						id="birthday" name="birthday" required>
				</div>

			</div>
			<div class="row">
				<div class="col">
					<label for="gender">Gender:</label> <select id="gender"
						name="gender" required>
						<option value="male">Male</option>
						<option value="female">Female</option>
					</select>
				</div>
				<div class="col">
					<label for="address">address:</label> <input type="text" id="address"
						name="address" required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="password">Password:</label> <input type="password"
						id="password" name="password" required>
				</div>
				<div class="col">
					<label for="retypePassword">Retype Password:</label> <input
						type="password" id="retypePassword" name="retypePassword" required>
						
				</div>
			</div>
			<button type="submit">Submit</button>
		</form>
	</div>
</body>
</html>
