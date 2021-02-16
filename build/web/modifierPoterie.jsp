

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <title>JSP Page</title>
    </head>
    <body>
          <%
           if(session.getAttribute("role")==null || !session.getAttribute("role").equals("administrateur")){
               response.sendRedirect("login.jsp");
           }
       %>
               <jsp:include page="header.jsp" />
      <h1 class="mt-5 col-12 d-flex justify-content-center">modifier poterie</h1>
        <div class="col-12 d-flex justify-content-center mt-3">   
        <div class="col-6 ">
             <form action="update" method="post">
                 
                <div class="form-group">
                    <input type="hidden" name="id" value="<c:out value='${poterie.idPoterie}' />" />
                <label for="exampleInputimage">image</label>
                <input class="form-control" id="custom-text" type="text" name="image" value="${poterie.image}">
                 <input class="form-control" id="real-file" type="file" hidden="hidden">
                 <button type="button" id="custom-button">CHOOSE A FILE</button>
                </div>
                <div class="form-group">
                <label for="exampleInputnom">nom</label>
                <input class="form-control" id="exampleInputnom" type="text" name="nomPoterie" value="<c:out value='${poterie.nom}' />">
                </div>
               <div class="form-group">
                <label for="exampleInputprix">prix</label>
                <input class="form-control" id="exampleInputprix" type="text" name="prix" value="<c:out value='${poterie.prix}' />"><br>
                <div class="col-12 d-flex justify-content-center">
                <input type="submit" class="btn btn-primary   " value="modifier Poterie">
                </div>
               </div>
             </form>
        </div>
        </div>
   <jsp:include page="footer.jsp" />