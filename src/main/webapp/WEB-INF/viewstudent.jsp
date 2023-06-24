<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21/06/2023
  Time: 07:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="upperlink.jsp"%>
<title>View student</title>
<div class="container2">
    <%--    left side--%>
    <div class="dleft">
        <%@ include file="sidebar.jsp" %>
    </div>
    <%--    right--%>
    <div class="dright">
        <div class="upper_desc">
            <h1>Students</h1>
            <p>Here is the list of all students and the operation on them</p>
        </div>

        <div class="tbody">
            <a href="createstudent.php?page=students" class="btn" id="sidebtn">Add student</a>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Full names</th>
                    <th>Birth</th>
                    <th>Phone</th>
                    <th>Address Code</th>
                    <th class="haction">action</th>
                </tr>

                <c:forEach items="${students}" var="std" varStatus="usrstatus">
                    <tr>
                        <td>${std.id}</td>
                        <td>${std.fullName}</td>
                        <td>${std.dateOfBirth}</td>
                        <td>${std.phoneNumber}</td>
                        <td>${std.address.city}</td>
                        <td class="action">
                            <a href="/viewd.php?id=${std.id}" class="view">
                                <p>View</p>
                            </a>
                            <a href="/updatestudent.php?id=${std.id}" class="update">
                                <p>Edit</p>
                            </a>
                            <a href="/deletestudent.php?id=${std.id}" class="delete">
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
