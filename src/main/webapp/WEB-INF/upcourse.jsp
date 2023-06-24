<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21/06/2023
  Time: 07:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="upperlink.jsp"%>
<title>create courses</title>

<div class="container2">
    <%--    left side--%>
    <div class="dleft">
        <%@ include file="sidebar.jsp" %>
    </div>
    <%--    right--%>
    <div class="dright">
        <div class="upper_desc">
            <h1>Courses</h1>
            <p>Here is the list of all students and the operation on them</p>
        </div>

        <form class="cinput" action="updatecourse.php?page=//updatecourse.php&&id=${exist.id}"  method="post">

            <div class="desf">
                <h1>Course detail</h1>
            </div>
            <div class="indesc">
                <input type="text" class="input" value="${exist.name}" name="name">
                <input type="text" class="input" value="${exist.code}" name="code">
            </div>
            <div class="indesc">
                <input type="number" class="input" value="${exist.minStudent}" name="min">
                <input type="number" class="input" value="${exist.maxStudent}" name="max">
            </div>
            <div class="indesc">
                <input type="text" class="input" value="${exist.start}" name="start">
                <input type="text" class="input" value="${exist.end}" name="end">
            </div>
            <div class="dcenter">
                <button class="btn">Add course</button>
            </div>

        </form>

    </div>
    <%@ include file="downlink.jsp"%>
