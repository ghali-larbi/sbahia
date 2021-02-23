/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Poterie;
import model.Utilisateur;
import model.Vote;

/**
 *
 * @author DELL
 */
public class daoPoterie implements PoterieInterfaces{
         private static final String INSERT_VOTE = "INSERT INTO vote" + "(idPoterie,idUtilisateur) VALUES (?,?)";
         private static final String INSERT_POTERIE = "INSERT INTO poterie" + "(image,nom,prix,vote,idUtilisateur,choix) VALUES (?,?,?,?,?,?)";
         private static final String SELECT_POTERIE = "select * from poterie  ";
          private static final String SELECT_VOTE2 = "select v.* from poterie p,vote v where p.idPoterie=v.idPoterie ";
         private static final String DELETE_POTERIE = "delete from poterie where idPoterie = ?;";
         private static final String UPDATE_POTERIE = "update poterie set image = ?,nom=?,prix=? where idPoterie = ?;";
         private static final String SELECT_POTERIE_BY_ID = "select * from poterie where idPoterie =?";
         private static final String UPDATE_VOTE = "update poterie set vote= ?,idutilisateur=?,choix=? where idPoterie = ?;";
         private static final String UPDATE_UTILISATEUR = "update vote set idutilisateur=? where idPoterie = ?;";
          private static final String SELECT_VOTE= "select * from poterie   ;";

        Connexion conx=new Connexion();
  public Poterie selectPoterie(int id) {
		Poterie poterie = null;
		// Step 1: Establishing a Connection
		try (Connection connection = conx.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_POTERIE_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String image = rs.getString("image");
                                String nom = rs.getString("nom");
                                int prix = rs.getInt("prix");
                                
				poterie = new Poterie(id,image,nom,prix);
			}
		}catch (SQLException e) {
			printSQLException(e);
		}
		return poterie;
	}
  
	
 public boolean updatePoterie(Poterie poterie)  {
		boolean rowUpdated = false;
		try (Connection connection = conx.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_POTERIE)) {
			        statement.setString(1, poterie.getImage());
                                statement.setString(2, poterie.getNom());
                                statement.setInt(3, poterie.getPrix());
                                statement.setInt(4, poterie.getIdPoterie());
			        rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException ex) {
                Logger.getLogger(daoPoterie.class.getName()).log(Level.SEVERE, null, ex);
            }
		return rowUpdated;
	}
 public boolean updateUtilisateur(Vote vote)  {
		boolean rowUpdated = false;
		try (Connection connection = conx.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_UTILISATEUR)) {
			        statement.setInt(1, vote.getIdUtilisateur());
                                statement.setInt(2, vote.getIdPoterie());
			        rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException ex) {
                Logger.getLogger(daoPoterie.class.getName()).log(Level.SEVERE, null, ex);
            }
		return rowUpdated;
	}
  public boolean updateVote(Poterie poterie)  {
		boolean rowUpdated = false;
		try (Connection connection = conx.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_VOTE)) {                                
			        statement.setInt(1,poterie.getVote());
                                statement.setInt(2,poterie.getIdUtilisateur());
                                statement.setBoolean(3, poterie.getChoix());
                                statement.setInt(4, poterie.getIdPoterie());
			        rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException ex) {
                Logger.getLogger(daoPoterie.class.getName()).log(Level.SEVERE, null, ex);
            }
		return rowUpdated;
	}
  
  
 public void insertPoterie(Poterie poterie)  {
		
		// try-with-resource statement will auto close the connection.
		try (Connection connection = conx.getConnection();
		        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_POTERIE)) {
                    preparedStatement.setString(1,poterie.getImage());
			preparedStatement.setString(2, poterie.getNom());
                        preparedStatement.setInt(3, poterie.getPrix());
                        preparedStatement.setInt(4,poterie.getVote());
                        preparedStatement.setInt(5,poterie.getIdUtilisateur());
                        preparedStatement.setBoolean(6,poterie.getChoix());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
   
 public void insertVote(Vote vote)  {
		
		// try-with-resource statement will auto close the connection.
		try (Connection connection = conx.getConnection();
		        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VOTE)) {
                    preparedStatement.setInt(1,vote.getIdPoterie());
			preparedStatement.setInt(2, vote.getIdUtilisateur());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
  
      public List<Poterie> selectPoterie() {
               
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Poterie> poterie = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = conx.getConnection();
                     
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_POTERIE);) {
                            
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("idPoterie");
                                String image = rs.getString("image");
				String nom = rs.getString("nom");
                                int prix=rs.getInt("prix");
                                int vote=rs.getInt("vote");
                               
                                
				poterie.add(new Poterie(id,image,nom,prix,vote));
			}
		} catch (SQLException e) {
			 printSQLException(e);
		}
		return poterie;
	}
       public List<Poterie> selectVote() {
        
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Poterie> poterie = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = conx.getConnection();
                        
				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_VOTE);) {
                   
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("idPoterie");
                                String image = rs.getString("image");
				String nom = rs.getString("nom");
                                int prix=rs.getInt("prix");
                                int vote=rs.getInt("vote");
                                int iduser=rs.getInt("idutilisateur");
                                boolean choix=rs.getBoolean("choix");
                               
                             
				poterie.add(new Poterie(id,image,nom,prix,vote,iduser,choix));
			}
		} catch (SQLException e) {
			 printSQLException(e);
		}
		return poterie;
	}
        public List<Vote> selectVote2() {
        
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Vote> vote = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = conx.getConnection();
                        
				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_VOTE2);) {
                   
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("idVote");
                                int idP=rs.getInt("idPoterie");
                                int iduser=rs.getInt("idutilisateur");
                               vote.add(new Vote(id,idP, iduser));
			}
		} catch (SQLException e) {
			 printSQLException(e);
		}
		return vote;
	}
        public boolean deletePoterie(int id){
		boolean rowDeleted = false;
		try (Connection connection = conx.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_POTERIE);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		} catch (SQLException ex) {
                Logger.getLogger(daoPoterie.class.getName()).log(Level.SEVERE, null, ex);
            }
		return rowDeleted;
	}

    private void printSQLException(SQLException e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
