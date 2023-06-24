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
                <form class="form" action="createuser.php?page=createuser" method="post">
                    <div class="desf">
                        <h1>User detail</h1>
                    </div>

                        <input type="text" class="input" placeholder="Enter full name" name="userfullname">
                        <input type="text" class="input" placeholder="Enter username" name="username">
                        <input type="text" class="input" placeholder="Enter Email" name="email">
                        <input type="password" class="input" placeholder="Enter password" name="password">

                        <div class="select-container">
                            <select class="select-box" name="userRole">
                                <option value="value">Select Role</option>
                                <c:forEach items="${userRoles}" var="userrole">
                                    <option value="${userrole}">
                                        <c:out value="${userrole.getRoleDescription()}"/>
                                    </option>

                                </c:forEach>
                            </select>
                            <div class="icon1">
                                <i class="fa-solid fa-caret-down"></i>
                            </div>
                        </div>

                    <div class="dcenter">
                        <button class="btn">Create user</button>
                    </div>

                </form>
                <p class="allr">Don't have an account? <a href="login.php?page=login" class="llink">Sign in</a> </p>
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

