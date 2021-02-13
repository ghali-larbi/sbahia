
        <%
           if(session.getAttribute("role")==null ){
               if(!session.getAttribute("role").equals("administrateur")){
                 response.sendRedirect("login.jsp");  
               }
               if(!session.getAttribute("role").equals("client")){
                 response.sendRedirect("login.jsp");  
               }
           }     
      
       %>

        <jsp:include page="header.jsp" />
        
    <section id="about" class="about">
        <h1 class="mt-5 col-12 d-flex justify-content-center">about Poterie</h1>
      <div class="container mt-5" data-aos="fade-up">
        <div class="row gx-0">

          <div class="col-lg-6 d-flex flex-column justify-content-center" data-aos="fade-up" data-aos-delay="200">
            <div class="content">
              <h3>poterie a safi</h3>
              <h2>À la rencontre des artisans potiers de Safi au Maroc</h2>
              <p>
                Le secteur de la poterie représente l'activité artisanale la plus importante et constitue un patrimoine culturel et touristique de la ville de Safi. Elle emploie près de 2 000 personnes de façon permanente et un grand nombre de saisonniers
              </p>
              <div class="text-center text-lg-start">
                <a href="#" class="btn-read-more d-inline-flex align-items-center justify-content-center align-self-center">
                  <span>lise Poterie</span>
                  <i class="bi bi-arrow-right"></i>
                </a>
              </div>
            </div>
          </div>

          <div class="col-lg-6 d-flex align-items-center" data-aos="zoom-out" data-aos-delay="200">
            <img src="image/about2.jpg" class="img-fluid" alt="">
          </div>

        </div>
      </div>
     <jsp:include page="footer.jsp" />
 
        
      