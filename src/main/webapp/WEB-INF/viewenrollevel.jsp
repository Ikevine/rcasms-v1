<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21/06/2023
  Time: 07:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="upperlink.jsp"%>
<title>View enrollevel</title>
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

        <div class="tbody">
            <a href="createnrolevel.php?page=createnrolevel" class="btn" id="sidebtn">Add level</a>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Names</th>
                    <th>Codes</th>
                    <th class="haction">action</th>
                </tr>

                <c:forEach items="${enrolLevel}" var="el" varStatus="usrstatus">
                    <tr>
                        <td>${el.id}</td>
                        <td>${el.name}</td>
                        <td>${el.code}</td>

                        <td class="action">
                            <a href="/updateenrolevel.php?id=${el.id}" class="update">
                                <p>Edit</p>
                            </a>
                            <a href="/deletelevel.php?id=${el.id}" class="delete">
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
