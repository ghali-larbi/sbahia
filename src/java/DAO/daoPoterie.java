/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Poterie;
import model.Utilisateur;

/**
 *
 * @author DELL
 */
public class daoPoterie {
     private String jdbcURL = "jdbc:mysql://localhost:3306/sbahia?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
        private static final String INSERT_UTILISATEUR = "INSERT INTO utilisateur" + "(nom,prenom,email,password,telephone,role) VALUES (?,?,?,?,?,?)";
         private static final String INSERT_POTERIE = "INSERT INTO poterie" + "(image,nom,prix,vote) VALUES (?,?,?,?)";
        private static final String SELECT_UTILISATEUR = "select * from utilisateur";
         private static final String SELECT_POTERIE = "select * from poterie";
         private static final String DELETE_POTERIE = "delete from poterie where idPoterie = ?;";
         private static final String UPDATE_POTERIE = "update poterie set image = ?,nom=?,prix=? where idPoterie = ?;";
         private static final String SELECT_POTERIE_BY_ID = "select * from poterie where idPoterie =?";
         private static final String UPDATE_VOTE = "update poterie set vote= ? where idPoterie = ?;";

 protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
  public Poterie selectPoterie(int id) {
		Poterie poterie = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
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
 public boolean updatePoterie(Poterie poterie) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_POTERIE)) {
			        statement.setString(1, poterie.getImage());
                                statement.setString(2, poterie.getNom());
                                statement.setInt(3, poterie.getPrix());
                                statement.setInt(4, poterie.getIdPoterie());
			        rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
  public boolean updateVote(Poterie poterie) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_VOTE)) {                                
			        statement.setInt(1, poterie.getVote());
                                statement.setInt(2, poterie.getIdPoterie());
                                
			        rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
 public void insertPoterie(Poterie poterie) throws SQLException {
		System.out.println(INSERT_POTERIE);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
		        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_POTERIE)) {
                    preparedStatement.setString(1,poterie.getImage());
			preparedStatement.setString(2, poterie.getNom());
                        preparedStatement.setInt(3, poterie.getPrix());
                        preparedStatement.setInt(4,poterie.getVote());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
   public void insertUtilisateur(Utilisateur utilisateur) throws SQLException {
		System.out.println(INSERT_UTILISATEUR);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
		        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_UTILISATEUR)) {
			preparedStatement.setString(1, utilisateur.getNom());
                        preparedStatement.setString(2, utilisateur.getPrenom());
                        preparedStatement.setString(3, utilisateur.getEmail());
                        preparedStatement.setString(4, utilisateur.getPassword());
                        preparedStatement.setString(5, Integer.toString(utilisateur.getTelephone()));
                        preparedStatement.setString(6, utilisateur.getRole());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
    public List<Utilisateur> selectUtilisateur() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Utilisateur> utilisateur = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_UTILISATEUR);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("idUtilisateur");
				String nom = rs.getString("nom");
                                String prenom=rs.getString("prenom");
                                String email=rs.getString("email");
                                String password=rs.getString("password");
                                int telephone=rs.getInt("telephone");
                                String role=rs.getString("role");
                             
				utilisateur.add(new Utilisateur(nom,prenom,email,password,telephone,role));
			}
		} catch (SQLException e) {
			 printSQLException(e);
		}
		return utilisateur;
	}
      public List<Poterie> selectPoterie() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Poterie> poterie = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
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
        public boolean deletePoterie(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_POTERIE);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

    private void printSQLException(SQLException e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}