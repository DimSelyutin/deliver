<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>First-webApp</title>
	<link href="css/style.css" rel="stylesheet">
	<script src="js/script.js"></script>
</head>

<body>
	<div class="header">
		<div class="header-icon">
			<div class="header-icon-img">
				<img src="img/java-icon.svg">
			</div>
			<div class="header-icon-text">
				<a>First<br>
					WebApp</a>
			</div>
		</div>
		<div class="header-menu">
			<a href="/">Main</a>
			<a href="blog">News</a>
			<a href="">Pilars</a>
		</div>
		<div class="buttons_sign">

			<% 
				if(session.getAttribute("userName") != null) {
					out.println("<button class=\"btn_sign\" name=\"logout\" type=\"submit\">"+ session.getAttribute("userName")+"</button>");
					out.println("<button class=\"btn_sign\" name=\"logout\" type=\"submit\" onclick=\"window.location.href = 'logout';\">Log Out</button>");
				} else {
					out.println("<button id=\"btn_signin\" class=\"btn_sign\" type=\"submit\" onclick=\"window.location.href = 'login';\">SighIn</button>");
					out.println("<button id=\"btn_signup\" class=\"btn_sign\" type=\"submit\" onclick=\"window.location.href = 'register';\">SighUp</button>");

					
				}
			%>
			
		</div>
		

		
	</div>
	<div class="form" id="jsp_register">
		<form action="register" method="post">
			<div class="form-head">Registration</div>
			<input type="text" name="login" placeholder="Enter login">
			<input type="text" name="phone" placeholder="Enter your phone">
			<input type="password" name="password" placeholder="Enter password">
			<input type="submit" value="Press">
			<p>Have an account? <a href="login">SignIn</a></p>
		</form>
	</div>
</body>

</html>