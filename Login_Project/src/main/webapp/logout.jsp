<%@ page import="com.java.conn.DBConnect" %>   
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogOut</title>
</head>
<body>
<%
HttpSession session2=request.getSession();
session.invalidate();
response.sendRedirect("login.jsp");

%>
</body>
</html>