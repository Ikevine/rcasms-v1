<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21/06/2023
  Time: 07:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="upperlink.jsp"%>
<title>create semester</title>

<div class="container2">
    <%--    left side--%>
    <div class="dleft">
        <%@ include file="sidebar.jsp" %>
    </div>
    <%--    right--%>
    <div class="dright">
        <div class="upper_desc">
            <h1>Semester</h1>
            <p>Here is the list of all students and the operation on them</p>
        </div>

        <form class="cinput" action="updatesemester.php?page=updatesemester&&id=${exist.id}" method="post">

            <div class="desf">
                <h1>Student detail</h1>
            </div>
            <div class="indesc">
                <input type="text" class="input" value="${exist.name}" name="Sname">
                <input type="text" class="input" value="${exist.code}" name="Scode">
            </div>
            <div class="indesc">
                <input type="text" class="input" value="${exist.startDate}" name="Sdate">
                <input type="text" class="input" value="${exist.endDate}" name="Edate">
            </div>

            <div class="dcenter">
                <button class="btn">Add semester</button>
            </div>

        </form>

    </div>
    <%@ include file="downlink.jsp"%>
