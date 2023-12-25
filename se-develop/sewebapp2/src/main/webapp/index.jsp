<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<section class="login">
		<div class="login_box">
			<div class="left">
				<%--
					<div class="top_link"><a href="#"><img src="https://drive.google.com/u/0/uc?id=16U__U5dJdaTfNGobB_OpwAJ73vM50rPV&export=download" alt="">Return home</a></div>
					
					<form method="get" action="">
						<h3>SIGN IN</h3>
						<input type="text" name="username" placeholder="USERNAME" />
						<input type="password" name="password" placeholder="PASSWORD" />
						<a href="guest/Login.jsp">
							<button class="submit">Sign In</button>
						<a href="guest/Login.jsp" class="submit">
							Sign In
						</a>
						</a>
					</form>
				--%>
				<div class="contact">
					<form method="get" action="LoginServlet">
						<h3>SIGN IN</h3>
						<input type="text" name="username" placeholder="USERNAME" />
						<input type="password" name="password" placeholder="PASSWORD" />
							<button class="submit">Sign In</button>
					</form>
				</div>
			</div>
			<div class="right">
				<div class="right-text">
					<h2>MR.D</h2>
					<h5>20B1NUM1183</h5>
				</div>
			</div>
		</div>
	</section>
</body>
</html>