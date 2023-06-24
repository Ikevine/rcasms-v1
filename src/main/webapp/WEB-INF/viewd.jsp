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
            <h1>Student view</h1>
            <p>Here is the list of all students and the operation on them</p>
        </div>

        <div class="dright">
            <div class="container3">
                <div class="ldetail">
                    <div class="dh1">
                        <h3>Personal details</h3>
                    </div>

                    <div class="dbody">
                        <div class="detail">
                            <h3>ID</h3>
                            <p>${inf.id}</p>
                        </div>
                        <div class="detail">
                            <h3>Full name</h3>
                            <p>${inf.fullName}</p>
                        </div>
                        <div class="detail">
                            <h3>DOB</h3>
                            <p>${inf.dateOfBirth}</p>
                        </div>
                        <div class="detail">
                            <h3>Parent name</h3>
                            <p>${pinf.fullName}</p>
                        </div>
                        <div class="detail">
                            <h3>Address</h3>
                            <p>${inf.address.country}, ${inf.address.city} , ${inf.address.streetAddress}</p>
                        </div>
                    </div>
                </div>
                <div class="rdetail">
                    <div class="enrol">
                        <h1>All courses enrolled in</h1>
                    </div>
                    <div class="tbody">
                        <table>
                            <tr>
                                <th>Subject</th>
                                <th>Marks</th>
                                <th>Semester</th>
                                <th>Level</th>
                            </tr>
                            <c:forEach items="${einf}" var="inf" >
                                <tr>
                                    <td>${inf.course.name}</td>
                                    <td>${inf.grade}</td>
                                    <td>${inf.semester.name}</td>
                                    <td>${inf.enrollmentLevel.name}</td>
                                </tr>
                            </c:forEach>

                        </table>
                    </div>
                </div>
            </div>
        </div>
   </div>
<%@ include file="downlink.jsp"%>
