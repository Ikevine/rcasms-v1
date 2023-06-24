<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>RCA SMS</title>
	<link rel="stylesheet" href="../../sass/css/main.css">
</head>
<body>
<div class="container">
	<div class="Lleft">
		<div class="Lmain">

			<div class="log">
				<img src="../images/logo2.png" alt="logo">
			</div>

			<h1>Rwanda Coding Academy Student Management System</h1>
			<p class="small">Welcome back</p>
			<div class="lform">
				<form action="login.php" method="post" class="form">
					<input type="text" placeholder="Enter your username" class="input" name="username" required>
					<input type="password" placeholder="Enter your password" class="input" name="password" required>
					<button class="btn">Sign in</button>
				</form>
				<p class="allr">Don't have an account? <a href="createuser.php?page=createuser" class="llink">Sign up</a> </p>
			</div>
		</div>

	</div>

	<!-- right side start here -->
	<div class="Lright">

		<div class="overlay">
			<div class="ovhead">
				<h2>Leading through digital Innovation</h2>
			</div>
			<div class="ovdown">
				<p>This system management system is only for instructors , parents , students and discpline staff we welcome to this system</p>
			</div>
		</div>

	</div>

</div>
</body>
</html>
