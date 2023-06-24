<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21/06/2023
  Time: 07:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="upperlink.jsp"%>
<title>create ACYear</title>

<div class="container2">
  <%--    left side--%>
  <div class="dleft">
    <%@ include file="sidebar.jsp" %>
  </div>
  <%--    right--%>
  <div class="dright">
    <div class="upper_desc">
      <h1>Academic</h1>
      <p>Here is the list of all academic and the operation on them</p>
    </div>

    <form class="cinput" action="updateacademic.php?page=updateacademic&&id=${exist.id}" method="post">

      <div class="desf">
        <h1>Academic detail</h1>
      </div>
      <div class="indesc">
        <input type="text" class="input" value="${exist.name}" name="Aname">
        <input type="text" class="input" value="${exist.code}" name="Acode">
      </div>

      <div class="dcenter">
        <button class="btn">Add academic</button>
      </div>

    </form>

  </div>
  <%@ include file="downlink.jsp"%>
