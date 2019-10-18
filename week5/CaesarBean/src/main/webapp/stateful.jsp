<%-- 
    Document   : stateful
    Created on : 17-Oct-2019, 01:32:58
    Author     : Admin
--%>

<%@page import="java.util.List"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="ch.unil.doplab.caesar.ejb.CaesarStatefulBeanLocal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
    private static CaesarStatefulBeanLocal converter;
    
    public void jspInit(){
        try
        {
            //The initial context implements the Context interface and provides the starting point for resolution of names
            InitialContext ic = new InitialContext();
            converter = (CaesarStatefulBeanLocal)ic.lookup("java:global/CaesarBean-1.0-SNAPSHOT/CaesarStatefulBean");


        }
        catch(Exception e){
            System.out.println(e);

        }

    }


%>
<%
    if (request.getParameter("key") != null){
        int k = Integer.parseInt(request.getParameter("key"));
        converter.setKey(k);
        String message = request.getParameter("message");
        String encoded_message = converter.encode(message);
        converter.addElement(encoded_message);
    }
    
    
%>




<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stateless session bean</title>
    </head>
    <body>
        <h2>Caesar cipher using stateful session bean</h2>
        <form method="get" action="Stateful">
            <table>
                <tr>
                    <td><label for="key">Key</label></td>
                    <td><input type="text" name="key" id="key"/></td>
                </tr>
                 <tr>
                     <td><label for="message">Message</label></td>
                     <td><input type="text" name="message" id="message"/></td>
                </tr>
                 <tr>
                    <td><input type="submit" value="encode"></td>
                </tr>
            </table>
            
                  
        </form>
        
            <%
                if (converter != null){
                    List<String> k = converter.getMessages();
                    out.println("<br>"+k.size()+" cipher saved");
                    for (String value: k){
                        out.println("<br>"+value);
                    }
                }
                
                if (request.getAttribute("encode") != null){
                    out.print("<h3>sentence encoded</h3>");
                    out.print("<i>"+request.getParameter("message")+"</i>");
                }
                
            %>
    </body>
</html>
