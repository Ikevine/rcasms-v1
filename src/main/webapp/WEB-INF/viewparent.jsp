<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21/06/2023
  Time: 07:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="upperlink.jsp"%>
<title>View parent</title>
<div class="container2">
    <%--    left side--%>
    <div class="dleft">
        <%@ include file="sidebar.jsp" %>
    </div>
    <%--    right--%>
    <div class="dright">
        <div class="upper_desc">
            <h1>Parents</h1>
            <p>Here is the list of all students and the operation on them</p>
        </div>

        <div class="tbody">
            <a href="createparents.php?page=createparents" class="btn" id="sidebtn">Add parent</a>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Full name</th>
                    <th>Birth date</th>
                    <th>Phone</th>
                    <th>Student Id</th>
                    <th class="haction">action</th>
                </tr>

                <c:forEach items="${parents}" var="par" varStatus="usrstatus">
                    <tr>
                        <td>${par.id}</td>
                        <td>${par.fullName}</td>
                        <td>${par.dateOfBirth}</td>
                        <td>${par.phoneNumber}</td>
                        <td>${par.student.id}</td>
                        <td class="action">
                            <a href="/updateparent.php?id=${par.id}" class="update">
                                <p>Edit</p>
                            </a>
                            <a href="/deleteparent.php?id=${par.id}" class="delete">
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
