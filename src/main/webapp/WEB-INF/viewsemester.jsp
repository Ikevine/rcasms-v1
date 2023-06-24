<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21/06/2023
  Time: 07:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="upperlink.jsp"%>
<title>View Semester</title>
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

        <div class="tbody">
            <a href="createsemester.php?page=createsemester" class="btn" id="sidebtn">Add semester</a>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th class="haction">action</th>
                </tr>

                <c:forEach items="${sms}" var="sm" varStatus="usrstatus">
                    <tr>
                        <td>${sm.id}</td>
                        <td>${sm.code}</td>
                        <td>${sm.name}</td>
                        <td>${sm.startDate}</td>
                        <td>${sm.endDate}</td>

                        <td class="action">
                            <a href="/updatesemester.php?id=${sm.id}" class="update">
                                <p>Edit</p>
                            </a>
                            <a href="/deletesemester.php?id=${sm.id}" class="delete">
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
