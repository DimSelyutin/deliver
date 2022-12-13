<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
				<a href="">About me</a>
				<a href="">Pilars</a>
			</div>
			<% 
			String formStyle="style=\" width: auto; display: grid; height: auto; align-content: center;\""; 
			String buttonsSign="<div " + formStyle +" class=\"buttons_sign\"><button id=\"btn_signin\" onclick=\"changeJsp()\" type=\"submit\" class=\"btn_sign\">SighIn</button><button id=\"btn_sgnup\" onclick=\"changeJsp()\" type=\"submit\" class=\"btn_sign\">SighUp</button></div></form>";
			String buttonsOut = "<form "+ formStyle +" action=\"Logout\" method=\"post\"><div class=\"buttons_sign\"><button type=\"submit\" class=\"btn_sign\">Log Out</button></div></form>";

			try{
				if (!session.getAttribute("userName").equals("")) {
				out.println(buttonsOut);
			} else {
				out.println(buttonsSign);

			}
			} catch(Exception e){
				out.println(buttonsSign);
			}

			%>
		</div>


		<jsp:include page="WEB-INF/jsp/login.jsp" flush="true">
			<jsp:param name="register" value="Example" />
		</jsp:include>

		<jsp:include page="WEB-INF/jsp/register.jsp" flush="true">
			<jsp:param name="register" value="Example" />
		</jsp:include>

	</body>

	</html>