<%-- 
    Document   : show
    Created on : 19 Apr, 2021, 2:59:26 PM
    Author     : ISHAN
--%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Page</title>
    </head>
    <body>
        <jsp:useBean id="st" class="prac_7.bean" scope="session"></jsp:useBean>
        
            <sql:query var="row" dataSource="${db}">
                SELECT * FROM PRAC_6
            </sql:query>
                
                    <table border="1">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Age</th>
                                <th>Phone_no</th>
                                <th>Email</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%! int cnt=0; %>
                            <c:forEach var="rd" items="${row.rows}">
                                <tr>
                                    <td><c:out value="${rd.NAME}"/></td>
                                    <td><c:out value="${rd.AGE}"/></td>
                                    <td><c:out value="${rd.PHONENO}"/></td>
                                    <td><c:out value="${rd.EMAIL}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                <a href="Logout.jsp">Logout</a>
    </body>
</html>