<%-- 
    Document   : DeleteStudentSecond
    Author     : Melike Geçer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete The Student</title>
    </head>
    <body>
        <p> <%= (String) request.getAttribute("resultMessage") %> </p> 
        <button type="button" name="Go To Main Menu" onclick="window.location = 'index.jsp'">Go To Main Menu</button>
    </body>
</html>
