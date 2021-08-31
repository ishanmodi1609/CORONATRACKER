<!DOCTYPE html>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<html>
    <head>
        <title>Register Detail Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <sql:setDataSource var="db" scope="application" driver="org.apache.derby.jdbc.ClientDriver" user="neel" password="neel" url="jdbc:derby://localhost:1527/prac7"></sql:setDataSource>
        <h1>Register yourself!</h1>
        <form action="register.jsp" method="post">
            Name:- <input type="text" name="name"><br>
            Roll No:-<input type="text" name="rollno"><br>
            Branch:-<input type="text" name="branch"><br>
            Year:-<input type="number" min="1" max="4" name="year"><br>
            <input type="submit" value="Submit" name="submit"><br>
            Already Registered<a href="login.jsp"> Click Here </a> to sign in.
        </form>
    </body>
</html>
