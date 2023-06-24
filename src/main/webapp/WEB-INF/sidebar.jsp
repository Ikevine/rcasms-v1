
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="side">
    <div class="navbar">
        <div class="log-des">
            <div class="log">
                <img src="../images/logo2.png" alt="">
            </div>
            <h1 class="h1">RCA</h1>
        </div>

        <div class="list">

            <ul class="upper">

                <li>
                    <div class="icon">
                        <img src="../images/icon/student.png" alt="icon" >
                    </div>
                    <a href="displaypage.php?direct=student">Students</a>
                </li>
                <li>
                    <div class="icon">
                        <img src="../images/icon/parent.png" alt="icon" >
                    </div>
                    <a href="displaypage.php?direct=parent">Parents</a>
                </li>
                <li>
                    <div class="icon">
                        <img src="../images/icon/person.png" alt="icon" >
                    </div>
                    <a href="displaypage.php?direct=user">User</a>
                </li>
                <li>
                    <div class="icon">
                        <img src="../images/icon/semester.png" alt="icon" >
                    </div>
                    <a href="displaypage.php?direct=semester">Semester</a>
                </li>
                <li>
                    <div class="icon">
                        <img src="../images/icon/course.png" alt="icon" >
                    </div>
                    <a href="displaypage.php?direct=courses">Courses</a>
                </li>
                <li>
                    <div class="icon">
                        <img src="../images/icon/calender.png" alt="icon" >
                    </div>
                    <a href="displaypage.php?direct=academic">Academic Year</a>
                </li>
                <li>
                    <div class="icon">
                        <img src="../images/icon/level.png" alt="icon" >
                    </div>
                    <a href="displaypage.php?direct=enrollevel">Enrollment Level</a>
                </li>
                <li>
                    <div class="icon">
                        <img src="../images/icon/enrol.png" alt="icon" >
                    </div>
                    <a href="displaypage.php?direct=enroll">Enrollment</a>
                </li>
                <li>
                    <div class="icon">
                        <img src="../images/icon/location.png" alt="icon" >
                    </div>
                    <a href="displaypage.php?direct=address">Address</a>
                </li>
            </ul>
        </div>

      <c:if test="${authenticatedUser !=null}">
        <div class="bottom">
            <div class="user">
                <img src="../images/new.jpg" alt="user image">
                <div class="Udescr">
                    <h3>${authenticatedUser.fullName}</h3>
                    <p>${authenticatedUser.userRole}</p>
                </div>
            </div>
            <a href="login.php?logout=logout">Logout</a>
        </div>
      </c:if>
    </div>
</div>
