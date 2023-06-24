<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21/06/2023
  Time: 07:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="upperlink.jsp"%>
<title>create user</title>

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

        <form class="cinput" action="updatestudent.php?page=updatestudent&&id=${exist.id}" method="post">

            <div class="desf">
                <h1>Student detail</h1>
            </div>
            <div class="indesc">
                <input type="text" class="input" value="${exist.fullName}" name="fullName">
                <input type="text" class="input" value="${exist.dateOfBirth}" name="birth">
            </div>
            <div class="indesc">
                <input type="text" class="input" value="${exist.phoneNumber}" name="phone">
                <fieldset>
                    <legend>Select the study state</legend>
                    <div class="check">
                        <input type="radio" id="1" value="true"/>
                        <label for="1">International</label>
                    </div>
                    <div class="check">
                        <input type="radio" id="2" value="true"/>
                        <label for="2">part Time</label>
                    </div>
                    <div class="check">
                        <input type="radio" id="3" value="true"/>
                        <label for="3">Is repaeting</label>
                    </div>
                </fieldset>
            </div>
            <div class="desf">
                <h1>Address detail</h1>
            </div>
            <div class="indesc">
                <input type="text" class="input" value="${exist.address.country}" name="country">
                <input type="text" class="input" value="${exist.address.city}" name="city">
            </div>
            <div class="indesc">
                <input type="text" class="input" value="${exist.address.streetAddress}" name="street">
                <input type="text" class="input" value="${exist.address.postalCode}" name="postal">
            </div>
            <div class="dcenter">
                <button class="btn">Update user</button>
            </div>

        </form>

    </div>
<%@ include file="downlink.jsp"%>