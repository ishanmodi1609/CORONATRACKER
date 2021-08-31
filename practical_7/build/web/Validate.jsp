
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    String name=request.getParameter("Name");
    String email=request.getParameter("Email");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validation Page</title>
    </head>
    <body>
        
        
        <jsp:useBean id="st" scope="session" class="prac_7.bean">
        </jsp:useBean>
        
        <jsp:setProperty name="st" property="name" value="<%=name%>"/>
        <jsp:setProperty name="st" property="email" value="<%=email%>"/>
        
        <sql:setDataSource var="db" scope="session" driver="org.apache.derby.jdbc.ClientDriver" user="Ishan" password="Ishan" url="jdbc:derby://localhost:1527/pract_6"></sql:setDataSource>
        
        <sql:query dataSource="${db}" var="chk">
             SELECT count(*) as cnt FROM PRAC_6 WHERE NAME=? AND EMAIL=?
             <sql:param value="<%=name%>"/>
             <sql:param value="<%=email%>"/>
        </sql:query>
             
             <c:forEach var="rd" items="${chk.rows}">
                 <c:choose>
                     <c:when test="${rd.cnt gt 0}">
                         <%
                             session.setAttribute("Username",name);
                             session.setAttribute("Email",email);
                         %>
                         <a href="show.jsp">Display Data</a>
                     </c:when>
                     <c:otherwise>
                         <c:redirect url="Login.jsp">
                             <c:param name="errMsg" value="Wrong user Name or Password">
                                 
                             </c:param>
                         </c:redirect>
                     </c:otherwise>
                 </c:choose>
             </c:forEach>
    </body>
</html>
