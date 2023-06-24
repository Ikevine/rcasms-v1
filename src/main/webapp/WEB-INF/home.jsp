<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21/06/2023
  Time: 07:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="upperlink.jsp"%>
<title>Overview</title>
<div class="container2">
    <%--    left side--%>
    <div class="dleft">
        <%@ include file="sidebar.jsp" %>
    </div>
    <%--    right--%>
        <div class="dright">
            <div class="dhome">
                <div class="overlay">
                    <div class="desc">
                        <h2>welcome to</h2>
                        <h1>Rwanda Coding Academy Student Management System</h1>
                    </div>
                    <div class="desc">
                        <h1>About application</h1>
                        <p>This is Student management system which is mainly focused on student enroll in the course and show the result of the students. Also parent can view the progress of their children</p>
                    </div>
                    <div class="desc">
                        <h1>Developed by Kevine Ishimwe</h1>
                        <p>All the phase of development from {System analysis , Design , Development}</p>
                    </div>
                </div>
            </div>
        </div>
</div>
<%@ include file="downlink.jsp"%>