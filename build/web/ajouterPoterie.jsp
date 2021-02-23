<%-- 
    Document   : ajouterPoterie
    Created on : 5 févr. 2021, 23:30:44
    Author     : DELL
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
           if(session.getAttribute("role")==null || !session.getAttribute("role").equals("administrateur")){
               response.sendRedirect("login.jsp");
           }
       %>
        <jsp:include page="header.jsp" />
        <h1 class="mt-5 col-12 d-flex justify-content-center">ajouter poterie</h1>
        <div class="col-12 d-flex justify-content-center mt-3">   
        <div class="col-6 ">
             <form action="addPoterie" method="post">
             <input type="hidden" name="idUser" value="<%= session.getAttribute("idUser") %>" />
                <div class="form-group">
                <label >image</label>
                <input class="form-control" id="custom-text" type="text" name="image">
                 <input class="form-control" id="real-file" type="file" hidden="hidden">
                 <button type="button" id="custom-button">CHOOSE A FILE</button>
                </div>
                <div class="form-group">
                <label for="exampleInputnom">nom</label>
                <input class="form-control" id="exampleInputnom" type="text" name="nomPoterie">
                </div>
               <div class="form-group">
                <label for="exampleInputprix">prix</label>
                <input class="form-control" id="exampleInputprix" type="text" name="prix"><br>
                <div class="col-12 d-flex justify-content-center">
                <input type="submit" class="btn btn-primary   " value="ajouter Poterie">
                </div>
            </form>
        </div>
        </div>
        </div>
     <jsp:include page="footer.jsp" />

