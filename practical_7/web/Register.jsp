<%-- 
    Document   : Register
    Created on : 19 Apr, 2021, 2:59:11 PM
    Author     : ISHAN
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
            String Name=request.getParameter("Name");
            String Email=request.getParameter("Email");
            String Phone_no=request.getParameter("Phone_no");
            String Age=request.getParameter("Age");
        %>
        
        <jsp:useBean id="st" class="prac_7.bean" scope="session"></jsp:useBean>
        <jsp:setProperty name="st" property="*"/>
        
        <sql:setDataSource var="db" scope="session" driver="org.apache.derby.jdbc.ClientDriver" user="Ishan" password="Ishan" url="jdbc:derby://localhost:1527/pract_6"></sql:setDataSource>
        
        <sql:update dataSource="${db}" var="qr">
             INSERT INTO PRAC_6 VALUES(?,?,?,?)
             <sql:param value="<%=Email%>"/>
             <sql:param value="<%=Name%>"/>
             <sql:param value="<%=Phone_no%>"/>
             <sql:param value="<%=Age%>"/>
        </sql:update>
              <%
                             session.setAttribute("Username",Name);
                             session.setAttribute("Email",Email);
                         %>
        
        <a href="show.jsp">Click to display</a>
    </body>
</html>