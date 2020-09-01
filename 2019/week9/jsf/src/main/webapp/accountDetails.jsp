<%-- 
    Document   : accountDetails
    Created on : 14-Nov-2019, 10:58:43
    Author     : alpha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation message</title>
    </head>
    <body>
        <h1>Welcome 
            
            <%
                String firstname = request.getParameter("firstname");
                
out.print(firstname);
                
            %>
            ${param.firstname} ${param.lastname}</h1>
    </body>
</html>
