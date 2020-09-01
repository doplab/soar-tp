<%-- 
    Document   : StudentWithdrawsSecond
    Author     : Melike Geçer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Withdraws From The Course</title>
    </head>
    <body>
        <p> <%= (String) request.getAttribute("message")%> </p> 
        <button type="button" name="Go To Main Menu" onclick="window.location = 'index.jsp'">Go To Main Menu</button>
    </body>
</html>
