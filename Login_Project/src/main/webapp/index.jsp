
<%@page import="com.java.entity.Training"%>
<%@page import="java.util.List"%>
<%@page import="com.java.dao.TrainingDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.java.conn.DBConnect" %>   
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@include file="all_css.jsp" %>

</head>
<body>
<%@include file="navbar.jsp" %>
<%
  if(session.getAttribute("Aname")==null){
	 response.sendRedirect("login.jsp"); 
  }

%>





<div class="container p-5">
<div class="card">
<div class="card-body">
<p class="text-center fs-1">All Training Data</p>
<c:if test="${not empty succMsg}">
<p class="text-center text-success">${succMsg}</p>
<c:remove var="succMsg"/>
</c:if>
<c:if test="${not empty errorMsg}">
<p class="text-center text-success">${errorMsg}</p>
<c:remove var="errorMsg"/>
</c:if>

<table class="table">
  <thead>
    <tr>
      <th scope="col">trainingID</th>
      <th scope="col">TrainingName</th>
      <th scope="col">StartDate</th>
      <th scope="col">EndDate</th>
       <th scope="col">TrainingMode</th>
       <th scope="col">BusinisessUnit</th>
       <th scope="col">ContactpersonID</th>
       <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  
  
  <%
  TrainingDAO dao=new TrainingDAO(DBConnect.getConn());
  List<Training> list=dao.getAllTraining();
  for(Training t:list)
  {
	  %> 
	
   <tr>
      <th scope="row"><%=t.getTrainingID() %></th>
      <td><%=t.getTrainingName() %></td>
      <td><%=t.getStartDate() %></td>
      <td><%=t.getEndDate() %></td>
      <td><%=t.getTrainingMode() %></td>
       <td><%=t.getBusinisessUnit() %></td>
        <td><%=t.getContactpersonID() %></td>
        
      <td> <a href="edit_training.jsp?trainingID=<%=t.getTrainingID() %>" class="btn btn-sm btn-primary">Edit</a></td>
       <td> <a href="delete?trainingID=<%=t.getTrainingID() %>" class="btn btn-sm btn-danger ms-1">Delete</a></td>
    </tr>
   
      <% 
  }
  
  %>
  </tbody>
</table>
</div>


</div></div>

</body>
</html>