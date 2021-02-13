<%-- 
    Document   : listPoterieClient
    Created on : 10 févr. 2021, 12:14:00
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
   <%
           if(session.getAttribute("role")==null || !session.getAttribute("role").equals("client")){
               response.sendRedirect("login.jsp");
           }
       %>
         <jsp:include page="header.jsp" />
         
          
          <h1 class="mt-3 col-12 d-flex justify-content-center">liste poterie</h1>
         
            <div class=" mt-5 container">
              <div class="row">   
                   <c:forEach var="poterie" items="${listPoterie}">
                  
                   <form action="vote" method="post">
                        <input type="hidden" name="id" value="<c:out value='${poterie.idPoterie}'/>" />
                        <input type="hidden" name="vote" value="<c:out value='${poterie.vote}'/>"/>
               <div class="col-lg-4 col-sm-6">
                    <div class="card" style="width: 18rem;">
                        <img class="card-img-top" src="image/${poterie.image}" width="300px" height="200" alt="Card image cap">
                         <div class="card-body">
                           <h5 class="card-title">${poterie.nom}</h5>
                           <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                         </div>
                         <ul class="list-group list-group-flush">
                             <li class="list-group-item">prix: <span>${poterie.prix}</span> </li>

                         </ul>
                         <div class="card-body">
                          <input type="submit" class="btn btn-primary" value="j'aime">

                         </div>
                    </div>
               </div>
                             </form>
                    </c:forEach>
              </div>
            </div>
          
         
         
         
         
         
         
         
         
         
         
         
         
         
         
           <jsp:include page="footer.jsp" />