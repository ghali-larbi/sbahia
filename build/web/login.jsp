<%-- 
    Document   : login
    Created on : 5 févr. 2021, 00:55:33
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="styleLogin.css" rel="stylesheet" >
    </head>
    <body>
        <div class="login-page">
            <div class="form">
                   <div col-12>
               <%
        if(request.getAttribute("error") != null){
        %>
        <p class="d-flex justify-content-center" style="color:red"> <%= request.getAttribute("error") %> </p>
     <% } %>

           </div>
            <form class="login-form" action="login" method="post">
        <input type="text" placeholder="email" name="email"/>
        <input type="password" placeholder="password" name="password"/>
        <button type="submit">login</button>
       
     <p class="message">Not registered? <a href="register.jsp">Create an account</a></p>
    </form>
  </div>
        </div>

    </body>
</html>
