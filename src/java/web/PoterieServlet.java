/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import DAO.daoPoterie;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.io.File;
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
import javax.servlet.http.Part;
import model.Poterie;
import model.Utilisateur;
import model.Vote;

/**
 *
 * @author DELL
 */
@WebServlet(name = "PoterieServlet", urlPatterns = {"/PoterieServlet"})
public class PoterieServlet extends HttpServlet {

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
            out.println("<title>Servlet PoterieServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PoterieServlet at " + request.getContextPath() + "</h1>");
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
        daoPoterie daopoterie=new daoPoterie();
public static final String UPLOAD_DIR = "image";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String action = request.getServletPath();

		try {
			switch (action) {
			case "/addPoterie":
				insertPoterie(request, response);
				break;
                        case "/listePoterie":
				listPoterie(request, response);
				break;
                        case "/delete":
				deletePoterie(request, response);
				break;
                      case "/edit":
				modifierFormPoterie(request, response);
				break;
                        case "/update":
				updatePoterie(request, response);
				break;
                        case "/listePoterieClient":
				listPoterieClient(request, response);
				break;
                          
                         case "/vote":
				voter(request, response);
                                
				break;
                        }      

		} catch (Exception ex) {
                   printStackTrace();
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

    private void insertPoterie(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {  
        String img=request.getParameter("image");
        String nom=request.getParameter("nomPoterie");
        int prix=Integer.parseInt(request.getParameter("prix"));
        int vote=0;
        int idU=Integer.parseInt(request.getParameter("idUser"));
        System.out.println(idU);
         Poterie newPoterie=new Poterie(img,nom,prix,vote,false);
         daopoterie.insertPoterie(newPoterie);
       
         response.sendRedirect("listePoterie");

    }

    private void listPoterie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                List<Poterie> listPoterie= daopoterie.selectPoterie();
	        request.setAttribute("listPoterie", listPoterie);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listePoterie.jsp");
		dispatcher.forward(request, response);
    }

    private void deletePoterie(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
      	
		int id = Integer.parseInt(request.getParameter("id"));
		daopoterie.deletePoterie(id);
		response.sendRedirect("listePoterie");
    }

    private void modifierFormPoterie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                int id = Integer.parseInt(request.getParameter("id"));
		Poterie existingUser = daopoterie.selectPoterie(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("modifierPoterie.jsp");
		request.setAttribute("poterie", existingUser);
		dispatcher.forward(request, response);
    }

    private void updatePoterie(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
       
		 int id = Integer.parseInt(request.getParameter("id"));
                 String img=request.getParameter("image");
                 String nom=request.getParameter("nomPoterie");
                 int prix=Integer.parseInt(request.getParameter("prix"));   
		Poterie poterie = new Poterie(id,img,nom,prix);
		daopoterie.updatePoterie(poterie);
		response.sendRedirect("listePoterie");
    }

    private void listPoterieClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
                List<Poterie> listPoterie=daopoterie.selectVote();
		request.setAttribute("listPoterie", listPoterie);
                List<Vote>listVote=daopoterie.selectVote2();
                request.setAttribute("listVote", listVote);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listPoterieClient.jsp");
		dispatcher.forward(request, response);
    }
    private void voter(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
                int id = Integer.parseInt(request.getParameter("id"));
                 int idU = Integer.parseInt(request.getParameter("idUser"));
                int vote =Integer.parseInt(request.getParameter("vote")); 
                 System.out.println(id+" "+idU+" "+vote);
                vote++;
               Poterie p=new Poterie(id,vote,true);
               daopoterie.updateVote(p);
                Vote v =new Vote(id, 1);
                daopoterie.insertVote(v);
                 Vote v2 =new Vote(id, idU);
                 daopoterie.updateUtilisateur(v2);
                 
		response.sendRedirect("listePoterieClient");
		

             
               
               

        
        
        
    }
}
