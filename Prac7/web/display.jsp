<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : display
    Created on : Apr 18, 2021, 9:17:03 AM
    Author     : Neel
--%>
<%--<%! 
    int totalUser;
    int currentUser;
%>

<%
    totalUser=sessionCnt.getTotalUser();
    currentUser=sessionCnt.getTotalUser();
%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Page</title>
        <style>
            
            body{
                text-align: center;
            }
            
            table{
                max-width: 680px;
                margin: 1em auto;
            }
        </style>
    </head>
    <body>
        <jsp:useBean id="st" class="lab7.student" scope="session"></jsp:useBean>
            <h1>Hello, <jsp:getProperty name="st" property="name"/>!</h1>
        
            <div class="count">
                <p></p>
                <p></p>
            </div>
        
        
        
        
        <form>
            Rollno:-<jsp:getProperty name="st" property="rollno"/><br>
        </form>
        
            <sql:query var="row" dataSource="${db}">
                SELECT * FROM STUDENT
            </sql:query>
                
                    <table border="1">
                        <thead>
                            <tr>
                                <th>Rollno</th>
                                <th>Branch</th>
                                <th>Year</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%! int cnt=0; %>
                            <c:forEach var="rd" items="${row.rows}">
                                <tr>
                                    <td><c:out value="${rd.ROLL}"/></td>
                                    <td><c:out value="${rd.BRANCH}"/></td>
                                    <td><c:out value="${rd.SYEAR}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                <a href="logout.jsp">Logout</a>
    </body>
</html>
