<!DOCTYPE html>

<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<html>
    <head>
        <title>Register Detail Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    
    <body>
        <sql:setDataSource var="db" scope="application" driver="org.apache.derby.jdbc.ClientDriver" user="Ishan" password="Ishan" url="jdbc:derby://localhost:1527/pract_6"></sql:setDataSource>
        <h1>Register page!</h1>
        <form action="Register.jsp" method="post">
            Name:- <input type="text" name="Name"><br>
            Email:-<input type="text" name="Email"><br>
            Phone_no:-<input type="text" name="Phone_no"><br>
            Age:-<input type="number" name="Age"><br>
            <input type="submit" value="Submit" name="submit"><br>
            <a href="Login.jsp">Login , if already registered</a>
        </form>
    </body>
</html>
