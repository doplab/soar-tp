<%-- 
    Document   : StudentTakesCourse
    Author     : Melike Geçer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,ch.unil.doplab.entities.Student,ch.unil.doplab.entities.Course"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Takes A Course</title>
    </head>
    <body>

        Select A Student: <br><br>
        <form action="courseRegistration" method="post">
            <hr><ol>
                <%
                    @SuppressWarnings(  "unchecked")
                    List<Student> students = (List<Student>) request.getAttribute("studentList");
                %>
                <select name="Select A Student To Take A Course">
                    <%
                        for (Student student : students) {
                    %>
                    <option value="<%= student.getStudentFirstName() + "," + student.getStudentLastName()%>"><%= student.getStudentFirstName() + " " + student.getStudentLastName()%></option>
                    <%
                        }
                    %>
                </select><br><br>
                Select A Course: <br><br>
                <%
                    @SuppressWarnings(  "unchecked")
                    List<Course> courses = (List<Course>) request.getAttribute("courseList");
                %>
                <select name="Select A Course Name For A Student">
                    <%
                        for (Course course : courses) {
                    %>
                    <option value="<%= course.getCourseName()%>"><%= course.getCourseName()%></option>
                    <%
                        }
                    %>
                </select>
            </ol><hr>
            <input type="submit" name="action" value="Student Takes The Course">
        </form>


        <button type="button" name="Go To Main Menu" onclick="window.location = 'index.jsp'">Go To Main Menu</button>
    </body>
</html>
