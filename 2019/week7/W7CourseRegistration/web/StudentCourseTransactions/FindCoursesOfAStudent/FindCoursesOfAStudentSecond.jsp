<%-- 
    Document   : FindCoursesOfAStudentSecond
    Author     : Melike Geçer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,ch.unil.doplab.entities.Course"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Find The Courses Of A Student</title>
    </head>
    <body>
        <hr><ol> 
            <%
                @SuppressWarnings(  "unchecked")
                List<Course> courses = (List<Course>) request.getAttribute("courseList");
                for (Course course : courses) {
            %>
            <li> <%= course%> </li> 
                <%
                    }
                %>
        </ol><hr>

        <button type="button" name="Go To Main Menu" onclick="window.location = 'index.jsp'">Go To Main Menu</button>
    </body>
</html>
