<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/login.css" />
</head>
<body>
	<div class="login-box">
		<h2>Login</h2>
		<%
						    if(request.getAttribute("error")!=null)
						    {
						    	%><p style="color:red" <%=request.getAttribute("error") %>></p>
						   
						   <%  }
						
						
						%>
		<form action="<%=request.getContextPath() %>/logn" method="post">
			<div class="row">
				<div class="col">
					<label for="email">email:</label> 
					<input type="email" id="email" name="email" required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="password">Password:</label> 
					<input type="password" id="password" name="password" required>
				</div>
			</div>
			<button type="submit" class="login-button" name ="login">Login</button>
		</form>
		<a href="<%=request.getContextPath()%>/register">Signup</a>
	</div>
</body>
</html>