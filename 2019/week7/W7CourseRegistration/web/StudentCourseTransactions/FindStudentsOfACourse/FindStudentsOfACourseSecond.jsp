<%-- 
    Document   : FindStudentsOfACourseSecond
    Author     : Melike Geçer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,ch.unil.doplab.entities.Student"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Find The Students Of A Course</title>
    </head>
    <body>
        <hr><ol> 
            <%
                @SuppressWarnings(  "unchecked")
                List<Student> students = (List<Student>) request.getAttribute("studentList");
                for (Student student : students) {
            %>
            <li> <%= student%> </li> 
                <%
                    }
                %>
        </ol><hr>

        <button type="button" name="Go To Main Menu" onclick="window.location = 'index.jsp'">Go To Main Menu</button>
    </body>
</html>
