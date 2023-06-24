<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21/06/2023
  Time: 07:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="upperlink.jsp"%>
<title>View academic year</title>
<div class="container2">
    <%--    left side--%>
    <div class="dleft">
        <%@ include file="sidebar.jsp" %>
    </div>
    <%--    right--%>
    <div class="dright">
        <div class="upper_desc">
            <h1>Academic year</h1>
            <p>Here is the list of all students and the operation on them</p>
        </div>

        <div class="tbody">
            <a href="createacademic.php?page=createacademic" class="btn" id="sidebtn">Add year</a>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Code</th>
                    <th class="haction">action</th>
                </tr>

                <c:forEach items="${academic}" var="acad" varStatus="usrstatus">
                    <tr>
                        <td>${acad.id}</td>
                        <td>${acad.name}</td>
                        <td>${acad.code}</td>

                        <td class="action">
                            <a href="/updateacademic.php?id=${acad.id}" class="update">
                                <p>Edit</p>
                            </a>
                            <a href="/deleteacademic.php?id=${acad.id}" class="delete">
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