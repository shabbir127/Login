<%@page import="com.java.entity.Training"%>
<%@page import="com.java.conn.DBConnect"%>
<%@page import="com.java.dao.TrainingDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
<%@include file="all_css.jsp" %>

</head>
<body>
<%@include file="navbar.jsp" %>

<div class="container p-4">
<div class="row">
<div class="col-md-6 offset-md-3">
<div class="card">
<div class="card-body">
<p class="fs-3 text-center">Edit Student</p>
      
      
      <%
      int trainingID=Integer.parseInt(request.getParameter("trainingID"));
     TrainingDAO dao=new TrainingDAO(DBConnect.getConn());
     Training t=dao.getTrainingById(trainingID);
      
      %>
      
      <form action="update" method="post">
<div class="mb-3">
    <label class="form-label">TrainingName</label>
    <input type="text" class="form-control" name="trainingname" value="<%=t.getTrainingName()%>" />
    </div>
    
  <div class="mb-3">
    <label class="form-label">Start Date</label>
    <input type="date" class="form-control" name="startdate" value="<%=t.getStartDate()%>">
   </div>
   
    <div class="mb-3">
    <label class="form-label">EndDate</label>
    <input type="date" class="form-control" name="enddate" value="<%=t.getEndDate()%>">
   </div>
   
  <div class="mb-3">
    <label  class="form-label">TrainingMode</label>
    <input type="text" class="form-control" name="trainingmode" value="<%=t.getTrainingMode()%>">
   </div>
   
   <div class="mb-3">
    <label  class="form-label">BusinisessUnit</label>
    <input type="text" class="form-control" name="businisessunit" value="<%=t.getBusinisessUnit()%>">
   </div>
   
   <div class="mb-3">
    <label  class="form-label">ContactpersonID</label>
    <input type="email" class="form-control" name="contactpersonid" value="<%=t.getContactpersonID()%>" >
   </div>
   
   
   
   <input type="hidden" name="id" value="<%=t.getTrainingID()%>">
   
  <button type="submit" class="btn btn-primary">Submit</button>
</form>


     
</div>
</div>
</div>
</div>
</div>




</body>
</html>