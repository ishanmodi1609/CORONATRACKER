<%-- 
    Document   : logout
    Created on : Apr 18, 2021, 10:18:55 AM
    Author     : Neel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    session.invalidate();
    response.sendRedirect("login.jsp");
%>
