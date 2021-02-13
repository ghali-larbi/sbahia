<%-- 
    Document   : listeProduit
    Created on : 5 févr. 2021, 22:32:08
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
        <style>
        body{
        overflow-x:hidden;
        } 
        .table td{
            vertical-align: middle;
        }
        </style>
    </head>
    <body>
         <%
           if(session.getAttribute("role")==null || !session.getAttribute("role").equals("administrateur")){
               response.sendRedirect("login.jsp");
           }
       %>
        <jsp:include page="header.jsp" />
     <div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center mt-5">List of Poterie</h3>
			
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/ajouterPoterie.jsp" class="btn btn-success">ajouter Poterie</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>image</th>
                                                <th>nom</th>
                                                <th>prix</th>
                                                <th>vote</th>
                                                <th>action</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
                                     
                                    <c:forEach var="poterie" items="${listPoterie}">

						<tr>
							<td><c:out value="${poterie.idPoterie}" /></td>
							 <td><img src="image/<c:out value="${poterie.image}" />" width="200px" height="150px"></td>
                                                        <td><c:out value="${poterie.nom}" /></td>
                                                        <td><c:out value="${poterie.prix}" /></td>
                                                        <td><c:out value="${poterie.vote}" /></td>
							
							<td><a class="btn btn-md btn-warning" href="edit?id=<c:out value='${poterie.idPoterie}' />">Edit</a>
                                                            &nbsp;&nbsp;&nbsp;&nbsp; <a class="btn btn-md btn-danger"
								href="delete?id=<c:out value='${poterie.idPoterie}' />">Delete</a></td>
						</tr>
					</c:forEach>
                              
					
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
  <jsp:include page="footer.jsp" />
