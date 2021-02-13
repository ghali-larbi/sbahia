<%-- 
    Document   : home
    Created on : 5 févr. 2021, 02:00:03
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
       
       
       <link rel="stylesheet"href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"crossorigin="anonymous">
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    <link rel="stylesheet" href="footerStyle.css">
    <link href="style.css" rel="stylesheet" >
    </head>
    <body>
       
      <header>
		<nav class=" bg-dark navbar navbar-expand-md navbar-dark ">
			<div>
				<a href="" class="navbar-brand">poterie   </a>
			</div>

			<ul class="navbar-nav ml-auto">
				<li><a href="home.jsp"class="nav-link">home</a></li>
                                    <%
                                        if(session.getAttribute("role")!=null ){
                                            if(session.getAttribute("role").equals("administrateur")){%>
                                             <li><a href="listePoterie" class="nav-link">list Poterie</a></li>
                                           <%}
                                            if(session.getAttribute("role").equals("client")){%>
                                             <li><a href="listePoterieClient"class="nav-link">list Poterie</a></li>
                                            <%}
                                        }     
                                    %>

                                      
                                        <li><a href=""class="nav-link"><i class="fas fa-user-circle" style="font-size:30px;margin-top:-7px"></i>&nbsp <%= session.getAttribute("nom")%></a></li>
                                        <li><a href="logout" class="btn btn-md btn-danger">deconnexion</a></li>
			</ul>
		</nav>
	</header> 
        <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
              <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
              <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
              <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img src="image/img1.jpg"  class="d-block w-100" height="400" alt="...">
                <div class="carousel-caption d-none d-md-block">
                
                </div>
              </div>
              <div class="carousel-item">
                <img src="image/img2.jpg"  class="d-block w-100" height="400" alt="...">
                <div class="carousel-caption d-none d-md-block">
                 
                </div>
              </div>
              <div class="carousel-item">
                <img src="image/img3.jpg"  class="d-block w-100" height="400" alt="...">
                <div class="carousel-caption d-none d-md-block">
                </div>
              </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>