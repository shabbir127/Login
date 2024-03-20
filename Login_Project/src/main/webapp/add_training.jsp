<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
<%@include file="all_css.jsp" %>

</head>
<body class="bg-light">
<%@include file="navbar.jsp" %>

<div class="container p-4">
<div class="row">
<div class="col-md-6 offset-md-3">
<div class="card">
<div class="card-body">
<p class="fs-3 text-center">Add Student</p>

<c:if test="${not empty succMsg}">
<p class="text-center text-success">${succMsg}</p>
<c:remove var="succMsg"/>
</c:if>
<c:if test="${not empty errorMsg}">
<p class="text-center text-success">${errorMsg}</p>
<c:remove var="errorMsg"/>
</c:if>
      
      <form action="register" method="post">
  <div class="mb-3">
    <label class="form-label">TrainingName</label>
    <input type="text" class="form-control" name="trainingname">
    </div>
    
  <div class="mb-3">
    <label class="form-label">Start Date</label>
    <input type="date" class="form-control" name="startdate">
   </div>
   
    <div class="mb-3">
    <label class="form-label">EndDate</label>
    <input type="date" class="form-control" name="enddate">
   </div>
   
  <div class="mb-3">
    <label  class="form-label">TrainingMode</label>
    <input type="text" class="form-control" name="trainingmode" >
   </div>
   
   <div class="mb-3">
    <label  class="form-label">BusinisessUnit</label>
    <input type="text" class="form-control" name="businisessunit">
   </div>
   
   <div class="mb-3">
    <label  class="form-label">ContactpersonID</label>
    <input type="email" class="form-control" name="contactpersonid" >
   </div>
   
   
   
  <button type="submit" class="btn btn-primary">Submit</button>
</form>


     
</div>
</div>
</div>
</div>
</div>




</body>
</html>