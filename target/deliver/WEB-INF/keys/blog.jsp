<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

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
				<a href="index.jsp">Main</a>
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
			
        <div class="blog"> 	
			<c:forEach var="post" items="${listUsers}">
				<div class="b_post">
					<div class="b_image" style="background-image: url('<c:out value="${post.img}"/>')">
						
					</div>
					<div class="b_theme">
						<a>Тема: </a>
							<h2>
								<c:out value="${post.title}"/>
							</h2>
					</div>
					<div class="b_text">
						<div class="b_text_area">
							<p><c:out value="${post.textare}"/></p>
						</div>
					</div>
				</div>
			</c:forEach>
        </div>
	
			
</body>

</html>