<%@page import="java.util.Base64"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Files"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <script>
    
        function validateForm() {
            var username = document.forms["loginForm"]["username"].value;
            var password = document.forms["loginForm"]["password"].value;

            if (username === "" || password === "") {
                alert("Username and Password must be filled out");
                return false;
            }
        }
    </script>
    <style>
			.container{
				width: 40%;
				border:1px solid black ;
				margin:auto ;
				padding: 20px;
			}
		</style>
<%@include file="all_css.jsp" %>

</head>
<body>
<%@include file="navbar.jsp" %>
    
    <div class="container ">
        <div class="row">
            <div class="col-md-4">
                <div >
                    <figure>
                         <% 
                   String imagePath = "C:/Users/HP/eclipse-workspace/OnlineExam/src/main/webapp/images/signup-image.jpg";
                   byte[] imageData = Files.readAllBytes(Paths.get(imagePath));
                   String base64Image = Base64.getEncoder().encodeToString(imageData);

                  %>

 
                   <img src="data:image/jpeg;base64, <%= base64Image %>" alt="Image Description" height="400">
                    </figure>
                </div>
            </div>
            <br>
            <div class="col-md-8">
            <br>
                <div class="card">
                    <div class="card-header">
                        <p class="text-center fs-3">Sign Up</p>
                        <c:if test="${not empty errorMsg}">
                            <p class="text-center text-success">${errorMsg}</p>
                            <c:remove var="errorMsg" />
                        </c:if>
                    </div>
                    <div class="card-body">

        
    <form action="login" method="post" onsubmit="return validateForm()" name="loginForm">
       <table>
         <tr>
					  <td>Name</td>
					  <td><input type="text" name="name" id="username" placeholder="Enter Name"/></td>
				 </tr>
	
				  <tr>
					   <td>Password</td>
					  <td><input type="password" name="password" id="password" placeholder="Enter Password"/></td>
				  </tr>
				  <tr>
				  <td>
				  </td>
                     <td>
                         <input type="submit" value="Login">
                      </td>
        </tr>
        </table>
    </form>
    </div>
    </div></div></div></div>
</body>
</html>
