<%-- 
    Document   : openAccount
    Created on : 14-Nov-2019, 10:57:48
    Author     : alpha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Banking</title>
    </head>
    <body>
         Open Account<br><br>
      <form method="post" action="insert">
       Last Name   <input type="text" name="lastname" value="Simpson"><br>
       First Name  <input type="text" name="firstname" value="Marge"> <br>
         <input type="submit" name="action" value="Create a new account">
      </form>
    </body>
</html>
