<%-- 
    Document   : DeleteCourseFirst
    Author     : Melike Geçer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,ch.unil.doplab.entities.Course"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete A Course</title>
    </head>
    <body>
        Select A Course: <br><br>
        <form action="courseRegistration" method="post">
            <hr><ol>
                <%
                    @SuppressWarnings("unchecked")
                    List<Course> courses = (List<Course>) request.getAttribute("courseList");
                %>
                <select name="Select A Course Name To Delete">
                    <%
                        for (Course course : courses) {
                    %>
                    <option value="<%= course.getCourseName() %>"><%= course.getCourseName() %></option>
                    <%
                        }
                    %>
                </select>
                <input type="submit" name="action" value="Delete The Course">
            </ol><hr>
            <button type="button" name="Go To Main Menu" onclick="window.location = 'index.jsp'">Go To Main Menu</button>
        </form>
    </body>
</html>
