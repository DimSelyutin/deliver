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

		<div>
			<section class="cards-wrapper">
			  <div class="card-grid-space">
				<a class="card" href="https://codetheweb.blog/2017/10/06/html-syntax/" style="--bg-img: url(https://images1-focus-opensocial.googleusercontent.com/gadgets/proxy?container=focus&resize_w=1500&url=https://codetheweb.blog/assets/img/posts/html-syntax/cover.jpg)">
				  <div>
					<h1>HTML Syntax</h1>
					<p>The syntax of a language is how it works. How to actually write it. Learn HTML syntax…</p>
					<div class="date">6 Oct 2017</div>
					<div class="tags">
					  <div class="tag">HTML</div>
					</div>
				  </div>
				</a>
			  </div>
			  <div class="card-grid-space">
				<a class="card" href="https://codetheweb.blog/2017/10/09/basic-types-of-html-tags/" style="--bg-img: url('https://images1-focus-opensocial.googleusercontent.com/gadgets/proxy?container=focus&resize_w=1500&url=https://codetheweb.blog/assets/img/posts/basic-types-of-html-tags/cover.jpg')">
				  <div>
					<h1>Basic types of HTML tags</h1>
					<p>Learn about some of the most common HTML tags…</p>
					<div class="date">9 Oct 2017</div>
					<div class="tags">
					  <div class="tag">HTML</div>
					</div>
				  </div>
				</a>
			  </div>
			  <div class="card-grid-space">
				<a class="card" href="https://codetheweb.blog/2017/10/14/links-images-about-file-paths/" style="--bg-img: url('https://images1-focus-opensocial.googleusercontent.com/gadgets/proxy?container=focus&resize_w=1500&url=https://codetheweb.blog/assets/img/posts/links-images-about-file-paths/cover.jpg')">
				  <div>
					<h1>Links, images and about file paths</h1>
					<p>Learn how to use links and images along with file paths…</p>
					<div class="date">14 Oct 2017</div>
					<div class="tags">
					  <div class="tag">HTML</div>
					</div>
				  </div>
				</a>
			  </div>
			  <!-- https://images.unsplash.com/photo-1520839090488-4a6c211e2f94?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=38951b8650067840307cba514b554ba5&auto=format&fit=crop&w=1350&q=80 -->
			</section>
			</div>

	</body>

	</html>