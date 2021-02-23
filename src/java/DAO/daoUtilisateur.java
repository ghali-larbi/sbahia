/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connexion.Connexion;
import java.sql.Connection;
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
  
public class daoUtilisateur implements UtilisateurInterfaces{
    Connexion conx=new Connexion(); 
            private static final String INSERT_UTILISATEUR = "INSERT INTO utilisateur" + "(nom,prenom,email,password,telephone,role) VALUES (?,?,?,?,?,?)";
             private static final String SELECT_UTILISATEUR = "select * from utilisateur";

 
   public void insertUtilisateur(Utilisateur utilisateur)  {
		System.out.println(INSERT_UTILISATEUR);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = conx.getConnection();
		        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_UTILISATEUR)) {
			preparedStatement.setString(1, utilisateur.getNom());
                        preparedStatement.setString(2, utilisateur.getPrenom());
                        preparedStatement.setString(3, utilisateur.getEmail());
                        preparedStatement.setString(4, utilisateur.getPassword());
                        preparedStatement.setInt(5,utilisateur.getTelephone());
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
		try (Connection connection = conx.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_UTILISATEUR);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
                                String prenom=rs.getString("prenom");
                                String email=rs.getString("email");
                                String password=rs.getString("password");
                                int telephone=rs.getInt("telephone");
                                String role=rs.getString("role");
                             
				utilisateur.add(new Utilisateur(id,nom,prenom,email,password,telephone,role));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return utilisateur;
	}

    private void printSQLException(SQLException e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
