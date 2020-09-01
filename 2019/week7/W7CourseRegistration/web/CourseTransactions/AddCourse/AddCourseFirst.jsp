<%-- 
    Document   : AddCourseFirst
    Author     : Melike Geçer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A New Course</title>
    </head>
    <body>
        <form action="courseRegistration" method="post">
            Course Name: 
            <input type="text" name="CourseName" value=""><br>
            Course Credits:
            <input type="number" name="CourseCredit" min="0" step="1" max="10"/><br><br>
            <input type="submit" name="action" value="Add The Course"><br><br>

            <button type="button" name="Go To Main Menu" onclick="window.location = 'index.jsp'">Go To Main Menu</button>
        </form>
    </body>
</html>
