<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21/06/2023
  Time: 07:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="upperlink.jsp"%>
<title>add user</title>

<div class="container2">
    <%--    left side--%>
    <div class="dleft">
        <%@ include file="sidebar.jsp" %>
    </div>
    <%--    right--%>
    <div class="dright">
        <div class="upper_desc">
            <h1>Users</h1>
            <p>Here is the list of all user and the operation on them</p>
        </div>

        <form class="cinput" action="adduser.php?page=adduser" method="post">

            <div class="desf">
                <h1>User detail</h1>
            </div>
            <div class="indesc">
                <input type="text" class="input" placeholder="Enter full name" name="userfullname">
                <input type="text" class="input" placeholder="Enter username" name="username">
            </div>
            <div class="indesc">
                <input type="text" class="input" placeholder="Enter Email" name="email">
                <input type="password" class="input" value="" name="password">
            </div>
            <div class="indesc">
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
            </div>
            <div class="dcenter">
                <button class="btn">Create user</button>
            </div>

        </form>

</div>
<%@ include file="downlink.jsp"%>
