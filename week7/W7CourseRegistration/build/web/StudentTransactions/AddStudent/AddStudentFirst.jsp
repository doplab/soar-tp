<%-- 
    Document   : AddStudentFirst
    Author     : Melike Geçer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A New Student</title>
    </head>
    <body>
        <form action="courseRegistration" method="post">
            Student First Name: 
            <input type="text" name="StudentFirstName" value=""><br>
            Student Last Name:
            <input type="text" name="StudentLastName" value=""><br>
            <input type="submit" name="action" value="Add The Student"><br><br>

            <button type="button" name="Go To Main Menu" onclick="window.location = 'index.jsp'">Go To Main Menu</button>
        </form>
    </body>
</html>
