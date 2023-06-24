<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21/06/2023
  Time: 07:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="upperlink.jsp"%>
<title>View courses</title>
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

    <div class="tbody">
      <a href="createcourse.php?page=createcourse" class="btn" id="sidebtn">Add course</a>
      <table>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Code</th>
          <th>Min student</th>
          <th>Start date</th>
          <th class="haction">action</th>
        </tr>

        <c:forEach items="${courses}" var="csr" varStatus="usrstatus">
          <tr>
            <td>${csr.id}</td>
            <td>${csr.name}</td>
            <td>${csr.code}</td>
            <td>${csr.minStudent}</td>
            <td>${csr.start}</td>
            <td class="action">
              <a href="/updatecourse.php?id=${csr.id}" class="update">
                <p>Edit</p>
              </a>
              <a href="/deletecourse.php?id=${csr.id}" class="delete">
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
