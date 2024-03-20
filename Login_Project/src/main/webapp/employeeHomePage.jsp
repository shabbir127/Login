<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Home Page</title>
<%@include file="all_css.jsp" %>

</head>
<body>
<%@include file="navbar.jsp" %>

<%
  if(session.getAttribute("Ename")==null){
	 response.sendRedirect("login.jsp"); 
  }

%>

    <h1 style="text-align: center;">Welcome Employee!</h1>
    
</body>
</html>
