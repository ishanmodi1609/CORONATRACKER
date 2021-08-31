<%-- 
    Document   : login
    Created on : Apr 18, 2021, 9:17:57 AM
    Author     : Neel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <style>
            body{
                text-align: center;
            }
            
            form{
                max-width: 50vw;
                width:100%;
                height:100%;
                display: block;
                margin:0 auto;
                text-align: center;
            }
            
        </style>
    </head>
    <body>
        <h1>Login</h1>
        <c:if test="${not empty param.errMsg}">
            <p style="color:red;font-size:20px;margin:1em;letter-spacing:1.2px;"> <c:out value="${param.errMsg}"/> </p>
        </c:if>
        <form action="loginchecker.jsp" method="post">
            Name:- <input type="text" name="name"><br>
            Roll No:-<input type="text" name="rollno"><br>
            <input type="submit" value="Submit" name="submit"><br>
            New User! Register by <a href="index.jsp"> Clicking Here </a>.
        </form>
    </body>
</html>
