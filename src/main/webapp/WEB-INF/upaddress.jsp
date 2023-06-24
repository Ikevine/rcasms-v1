<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21/06/2023
  Time: 07:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="upperlink.jsp"%>
<title>add address</title>

<div class="container2">
  <%--    left side--%>
  <div class="dleft">
    <%@ include file="sidebar.jsp" %>
  </div>
  <%--    right--%>
  <div class="dright">
    <div class="upper_desc">
      <h1>Address</h1>
      <p>Here is the list of all Address and the operation on them</p>
    </div>

    <form class="cinput" action="updateaddress.php?page=updateaddress&&id=${exist.id}" method="post">

      <div class="desf">
        <h1>Address detail</h1>
      </div>
      <div class="indesc">
        <input type="text" class="input" value="${exist.country}" name="country">
        <input type="text" class="input" value="${exist.city}" name="city">
      </div>
      <div class="indesc">
        <input type="text" class="input" value="${exist.streetAddress}" name="street">
        <input type="password" class="input" value="${exist.postalCode}" name="postal">
      </div>

      <div class="dcenter">
        <button class="btn">Add address</button>
      </div>

    </form>

  </div>
  <%@ include file="downlink.jsp"%>
