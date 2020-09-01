<%-- 
    Document   : index
    Author     : Melike Geçer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Registration</title>
    </head>
    <body>
        Course Transactions
        <form method="post" action="courseRegistration">
            <br>
            <input type="submit" name="action" value="Add A New Course"><br><br>
            <input type="submit" name="action" value="Delete A Course"><br><br>
            <input type="submit" name="action" value="Find A Course"><br><br>
            <input type="submit" name="action" value="Find All Courses"><br><br>
        </form><br><br><br>
        Student Transactions
        <form method="post" action="courseRegistration">
            <br>
            <input type="submit" name="action" value="Add A New Student"><br><br>
            <input type="submit" name="action" value="Delete A Student"><br><br>
            <input type="submit" name="action" value="Find A Student"><br><br>
            <input type="submit" name="action" value="Find All Students"><br><br>
        </form><br><br><br>
        Student-Course Transactions
        <form method="post" action="courseRegistration">
            <br>
            <input type="submit" name="action" value="Student Takes A Course"><br><br>
            <input type="submit" name="action" value="Student Withdraws From A Course"><br><br>
            <input type="submit" name="action" value="Show Students Of A Course"><br><br>
            <input type="submit" name="action" value="Show Courses of A Student"><br><br>
        </form>
    </body>
</html>
