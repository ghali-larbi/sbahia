/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import DAO.daoPoterie;
import DAO.daoUtilisateur;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Poterie;
import model.Utilisateur;

/**
 *
 * @author DELL
 */
@WebServlet(name = "ServletPoterie", urlPatterns = {"/ServletPoterie"})
public class ServletAuthentification extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletPoterie</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletPoterie at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    daoUtilisateur daopoterie=new daoUtilisateur();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

		try {
			switch (action) {
			case "/login":
				login(request, response);
				break;
                        case "/register":
				register(request, response);
				break;
                        case "/logout":
				logout(request, response);
				break;
                        
                        }                        

		} catch (Exception ex) {
                   printStackTrace();
		}
    }
     private void register(HttpServletRequest request, HttpServletResponse response) 
		throws SQLException, IOException, ServletException {
         
		String nom = request.getParameter("nom");
                String prenom=request.getParameter("prenom");
                String email=request.getParameter("email");
                String password=request.getParameter("password");
                int telephone=Integer.parseInt(request.getParameter("telephone"));
                String role=request.getParameter("role");
                if(nom!="" || prenom!="" || email!="" || String.valueOf(telephone)!="" || role!=""){
                if(password.length()>=8){
                    Utilisateur newPersonne= new Utilisateur(nom,prenom,email,password,telephone,role);
	            daopoterie.insertUtilisateur(newPersonne);
		    response.sendRedirect("register.jsp");
                }
                else{
                    request.setAttribute("error","password invalide");
              RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
		dispatcher.forward(request, response);
                }
                 }else{
                    request.setAttribute("error","champs vide");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
		    dispatcher.forward(request, response);
                }
                   
}
     private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
          String email=request.getParameter("email");
          String password=request.getParameter("password");
           if(email!="" || password!=""){
         List<Utilisateur> listUtilisateur = daopoterie.selectUtilisateur();
         for (int i = 0; i < listUtilisateur.size(); i++){
               if(listUtilisateur.get(i).getRole().equals("client")){
                   if(listUtilisateur.get(i).getEmail().equals(email) && listUtilisateur.get(i).getPassword().equals(password) ){
                     HttpSession client= request.getSession();
                   client.setAttribute("idUser",listUtilisateur.get(i).getIdUtilisateur());
                   client.setAttribute("role",listUtilisateur.get(i).getRole());
                   client.setAttribute("nom",listUtilisateur.get(i).getNom());
		   response.sendRedirect("home.jsp");   
                   }
                
               }
               else if(listUtilisateur.get(i).getRole().equals("administrateur")){
                   if(listUtilisateur.get(i).getEmail().equals(email) && listUtilisateur.get(i).getPassword().equals(password) ){
                     HttpSession admin= request.getSession();
                   admin.setAttribute("idUser",listUtilisateur.get(i).getIdUtilisateur());
                   admin.setAttribute("role",listUtilisateur.get(i).getRole());
                   admin.setAttribute("nom",listUtilisateur.get(i).getNom());
		   response.sendRedirect("home.jsp");   
                   }        
               }
                 
             }                     
          }
           else{
               request.setAttribute("error","erreur validation");
               RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
           }
     }
     
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           this.doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
       request.getSession().invalidate();
       response.sendRedirect("login.jsp");
    }

}
