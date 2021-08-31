<%-- 
    Document   : loginchecker
    Created on : Apr 18, 2021, 10:26:22 AM
    Author     : Neel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    String name=request.getParameter("name");
    String roll=request.getParameter("rollno");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LoginChecker Page</title>
    </head>
    <body>
        
        
        <jsp:useBean id="st" scope="session" class="lab7.student">
        </jsp:useBean>
        
        <jsp:setProperty name="st" property="name" value="<%=name%>"/>
        <jsp:setProperty name="st" property="rollno" value="<%=roll%>"/>
        
        <sql:query dataSource="${db}" var="chk">
             SELECT count(*) as cnt FROM STUDENT WHERE NAME=? AND ROLL=?
             <sql:param value="<%=name%>"/>
             <sql:param value="<%=roll%>"/>
        </sql:query>
             
             <c:forEach var="rd" items="${chk.rows}">
                 <c:choose>
                     <c:when test="${rd.cnt gt 0}">
                         <%
                             session.setAttribute("Username",name);
                             session.setAttribute("Rollno",roll);
                         %>
                         <a href="display.jsp">Display Data</a>
                     </c:when>
                     <c:otherwise>
                         <c:redirect url="login.jsp">
                             <c:param name="errMsg" value="Wrong user Name or Password">
                                 
                             </c:param>
                         </c:redirect>
                     </c:otherwise>
                 </c:choose>
             </c:forEach>
    </body>
</html>
