<%-- 
    Document   : register
    Created on : Apr 17, 2021, 9:59:37 AM
    Author     : Neel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <%
            String name=request.getParameter("name");
            String rollno=request.getParameter("rollno");
            String branch=request.getParameter("branch");
            int year=Integer.parseInt(request.getParameter("year"));
        %>
        
        <jsp:useBean id="st" class="lab7.student" scope="session"></jsp:useBean>
        <jsp:setProperty name="st" property="*"/>
        
        <sql:setDataSource var="db" scope="session" driver="org.apache.derby.jdbc.ClientDriver" user="neel" password="neel" url="jdbc:derby://localhost:1527/prac7"></sql:setDataSource>
        
        <sql:update dataSource="${db}" var="qr">
             INSERT INTO STUDENT VALUES(?,?,?,?)
             <sql:param value="<%=name%>"/>
             <sql:param value="<%=rollno%>"/>
             <sql:param value="<%=branch%>"/>
             <sql:param value="<%=year%>"/>
        </sql:update>
              <%
                             session.setAttribute("Username",name);
                             session.setAttribute("name",rollno);
                         %>
        
        <a href="display.jsp">Click to display</a>
    </body>
</html>
