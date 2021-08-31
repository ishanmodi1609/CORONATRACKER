<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <c:if test="${not empty param.errMsg}">
            <p style="color:red;font-size:20px;margin:1em;letter-spacing:1.2px;"> <c:out value="${param.errMsg}"/> </p>
        </c:if>
            
        <form action="Validate.jsp" method="post">
            Name:- <input type="text" name="Name"><br>
            Email:-<input type="text" name="Email"><br>
            <input type="submit" value="Submit" name="submit"><br>
        </form>
    </body>
</html>
