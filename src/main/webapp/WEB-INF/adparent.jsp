<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21/06/2023
  Time: 07:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="upperlink.jsp"%>
<title>add parent</title>

<div class="container2">
    <%--    left side--%>
    <div class="dleft">
        <%@ include file="sidebar.jsp" %>
    </div>
    <%--    right--%>
    <div class="dright">
        <div class="upper_desc">
            <h1>Parent</h1>
            <p>Here is the list of all students and the operation on them</p>
        </div>

        <form class="cinput" action="createparents.php?page=createparents" method="post">

            <div class="desf">
                <h1>Parent detail</h1>
            </div>
            <div class="indesc">
                <input type="text" class="input" placeholder="Enter full name" name="name">
                <input type="text" class="input" placeholder="Enter date of birth[YYYY-MM-DD]" name="birth">
            </div>
            <div class="indesc">
                <input type="text" class="input" placeholder="Enter phone" name="phone">
                <input type="text" class="input" placeholder="Enter student Id" name="st_number">
            </div>

            <div class="dcenter">
                <button class="btn">Add parent</button>
            </div>

        </form>

    </div>
    <%@ include file="downlink.jsp"%>
