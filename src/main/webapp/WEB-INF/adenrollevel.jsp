<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21/06/2023
  Time: 07:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="upperlink.jsp"%>
<title>create enroll</title>

<div class="container2">
    <%--    left side--%>
    <div class="dleft">
        <%@ include file="sidebar.jsp" %>
    </div>
    <%--    right--%>
    <div class="dright">
        <div class="upper_desc">
            <h1>Enrollment Level</h1>
            <p>Here is the list of all students and the operation on them</p>
        </div>

        <form class="cinput" action="createnrolevel.php?page=createnrolevel" method="post">

            <div class="desf">
                <h1>Student detail</h1>
            </div>
            <div class="indesc">
                <input type="text" class="input" placeholder="Enter enroll level code" name="Ecode">
                <input type="text" class="input" placeholder="Enter enrol level name" name="Ename">
            </div>
            <div class="dcenter">
                <button class="btn">Add level</button>
            </div>

        </form>

    </div>
    <%@ include file="downlink.jsp"%>
