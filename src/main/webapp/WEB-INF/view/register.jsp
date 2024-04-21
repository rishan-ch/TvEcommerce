<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/register.css"/>
</head>
<body>

    <div class="container" id="container">
        <div class="form-container sign-up">
            <form style="padding-top: 60px;" action="<%=request.getContextPath() %>/register" method="post">
                <h1>Create Account</h1>
                <input type="text" placeholder="Full Name" name = "fullName">
                <input type="email" placeholder="Email" name = "email">
                <div class="row">
                    <div class="col">
                        <input type="password" placeholder="Password" name="password">
                    </div>
                    <div class="col">
                        <input type="password" placeholder="Retype Password" name="retypePassword">
                    </div>
			    </div>
                <div class="row">
                    <div class="col">
                        <input type="text" id="phone" placeholder="Phone (+977)" required name="phone">
                    </div>
                    <div class="col">
                        <input type="text" placeholder="City" name="address">
                    </div>
			    </div>
                
                <div class="row">
                    <div class="col">
                            <select id="gender" name="gender" required name="gender">
                                <option value="male">Male</option>
                                <option value="female">Female</option>
                                <option value="others">Others</option>
                            </select>
                    </div>
                    <div class="col">
                        <input type="date" id="birthday" name="birthday" required name="birthday">
                    </div>
                </div>

            <button>Sign Up</button>
            </form>
        </div>
        <div class="form-container sign-in">
            <form action="<%=request.getContextPath() %>/login" method="post">
                <h1>Sign in</h1>
                <input type="email" placeholder="Email">
                <input type="password" placeholder="Password">
                <a href="#">Forgot Your Password?</a>
                <button>Sign In</button>
            </form>
        </div>
        <div class="toggle-container">
            <div class="toggle">
                <div class="toggle-panel toggle-left">
                    <h1>Welcome User!</h1>
                    <p>Continue with your existing email and password</p>
                    <button class="hidden" id="login">Sign In</button>
                </div>
                <div class="toggle-panel toggle-right">
                    <h1>Infinity Stores</h1>
                    <p>Register with personal details to proceed further</p>
                    <button class="hidden" id="register">Sign Up</button>
                </div>
            </div>
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/script/script.js"></script>
</body>
</html>
