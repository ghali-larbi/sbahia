<%-- 
    Document   : register
    Created on : 5 févr. 2021, 00:55:45
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
                <link href="styleLogin.css" rel="stylesheet">

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
    <form  action="register" method="post">
        <input type="text" placeholder="nom" name="nom"/>
        <input type="text" placeholder="prenom" name="prenom"/>
        <input type="text" placeholder="email" name="email"/>
        <input type="password" placeholder="password" name="password"/>
                 <input type="text" placeholder="telephone" name="telephone"/>
        <input type="text" placeholder="role" name="role"/>

      <button type="submit">register</button>
      <p class="message">Already registered? <a href="login.jsp">Sign In</a></p>
    </form>
       </div>
        </div>
        
    </body>
</html>
