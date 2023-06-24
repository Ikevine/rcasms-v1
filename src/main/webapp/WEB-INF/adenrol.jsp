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
            <h1>Enrollment</h1>
            <p>Add enrollment and the operation on them</p>
        </div>

        <form class="cinput" action="createnrol.php?page=createnrol" method="post">

            <div class="desf">
                <h1>Student detail</h1>
            </div>
            <div class="indesc">
                <input type="text" class="input" placeholder="Enter enrol date[YYYY-MM-DD]" name="Edate">
                <input type="text" class="input" placeholder="Enter grade" name="grade">
            </div>
            <div class="indesc">
                <div class="select-container">
                    <select class="select-box" name="semeter">
                        <option value="value">Select Semester</option>
                        <c:forEach items="${semesters}" var="semester">
                            <option value="${semester.name}">
                                <c:out value="${semester.name}"/>
                            </option>
                        </c:forEach>
                    </select>
                    <div class="icon1">
                        <i class="fa-solid fa-caret-down"></i>
                    </div>
                </div>

<%--                secondary--%>
                <div class="select-container">
                    <select class="select-box" name="academic">
                        <option value="value">Select Academic Year</option>
                        <c:forEach items="${academics}" var="academy">
                            <option value="${academy.name}">
                                <c:out value="${academy.name}"/>
                            </option>

                        </c:forEach>
                    </select>
                    <div class="icon1">
                        <i class="fa-solid fa-caret-down"></i>
                    </div>
                </div>
            </div>

<%--            another main box--%>

            <div class="indesc">
                <div class="select-container">
                    <select class="select-box" name="course">
                        <option value="value">Select course</option>
                        <c:forEach items="${courses}" var="course">
                            <option value="${course.name}">
                                <c:out value="${course.name}"/>
                            </option>

                        </c:forEach>
                    </select>
                    <div class="icon1">
                        <i class="fa-solid fa-caret-down"></i>
                    </div>
                </div>

                <%--                secondary--%>
                <div class="select-container">
                    <select class="select-box" name="enrolLevel">
                        <option value="value">Select Level</option>
                        <c:forEach items="${level}" var="leve">
                            <option value="${leve.name}">
                                <c:out value="${leve.name}"/>
                            </option>

                        </c:forEach>
                    </select>
                    <div class="icon1">
                        <i class="fa-solid fa-caret-down"></i>
                    </div>
                </div>
            </div>
<%--              last link here--%>
            <div class="indesc">
                <input type="text" class="input" placeholder="Enter student ID" name="student_id">
            </div>

            <div class="dcenter">
                <button class="btn">Add enroll</button>
            </div>

        </form>

    </div>
    <%@ include file="downlink.jsp"%>
