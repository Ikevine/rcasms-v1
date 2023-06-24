<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21/06/2023
  Time: 07:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="upperlink.jsp"%>
<title>View user</title>
<div class="container2">
<%--    left side--%>
    <div class="dleft">
        <%@ include file="sidebar.jsp" %>
    </div>
<%--    right--%>
    <div class="dright">
        <div class="upper_desc">
            <h1>Users</h1>
            <p>Here is the list of all students and the operation on them</p>
        </div>

        <div class="tbody">
            <a href="adduser.php?page=adduser" class="btn" id="sidebtn">Add user</a>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Role</th>
                    <th class="haction">action</th>
                </tr>

                <c:forEach items="${users}" var="usr" varStatus="usrstatus">
                <tr>
                    <td>${usr.id}</td>
                    <td>${usr.fullName}</td>
                    <td>${usr.email}</td>
                    <td>${usr.userRole.getRoleDescription()}</td>

                    <td class="action">
                        <a href="/updateuser.php?id=${usr.id}" class="update">
                            <p>Edit</p>
                        </a>
                        <a href="/deleteuser.php?id=${usr.id}" class="delete">
                            <p>Delete</p>
                        </a>
                    </td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<%@ include file="downlink.jsp"%>