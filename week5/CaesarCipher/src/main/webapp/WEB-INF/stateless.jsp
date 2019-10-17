<%-- 
    Document   : stateless
    Created on : 17-Oct-2019, 01:32:58
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stateless session bean</title>
    </head>
    <body>
        <h2>Caesar cipher using stateless session bean</h2>
        <form method="get" action="stateless">
            <table>
                <tr>
                    <td><label for="key">Clé</label></td>
                    <td><input type="text" name="key" id="key"/></td>
                </tr>
                 <tr>
                     <td><label for="sentence">Phrase</label></td>
                     <td><input type="text" name="sentence" id="sentence"/></td>
                </tr>
                 <tr>
                    <td><input type="submit" value="encode"></td>
                </tr>
            </table>
            
                  
        </form>
        
            <%
                if (request.getAttribute("encode") != null){
                    out.print("<h3>sentence decoded</h3>");
                    out.print("<i>"+request.getAttribute("encode")+"</i>");
                }
                
            %>
    </body>
</html>




 
   
