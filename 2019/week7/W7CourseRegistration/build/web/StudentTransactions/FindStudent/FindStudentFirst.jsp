<%-- 
    Document   : FindStudentFirst
    Author     : Melike Geçer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,ch.unil.doplab.entities.Student"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Find A Student</title>
    </head>
    <body>
        Select A Student: <br><br>
        <form action="courseRegistration" method="post">
            <hr><ol>
                <%
                    @SuppressWarnings("unchecked")
                    List<Student> students = (List<Student>) request.getAttribute("studentList");
                %>
                <select name="Select A Student To Find">
                    <%
                        for (Student student : students) {
                    %>
                    <option value="<%= student.getStudentFirstName() + "," + student.getStudentLastName() %>"><%= student.getStudentFirstName() + " " + student.getStudentLastName()%></option>
                    <%
                        }
                    %>
                </select>
                <input type="submit" name="action" value="Find The Student" >
            </ol><hr>
            <button type="button" name="Go To Main Menu" onclick="window.location='index.jsp'">Go To Main Menu</button>
        </form>
    </body>
</html>
