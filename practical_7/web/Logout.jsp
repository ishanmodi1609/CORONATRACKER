<%-- 
    Document   : Logout
    Created on : 19 Apr, 2021, 2:58:54 PM
    Author     : ISHAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    session.invalidate();
    response.sendRedirect("Login.jsp");
%>
