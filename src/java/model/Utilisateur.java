/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DELL
 */
public class Utilisateur {
     private int idUtilisateur;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private int telephone;
    private String role;
    
    	public Utilisateur( String nom, String prenom, String email, String password, int telephone,String role) {
			
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.password = password;
			this.telephone = telephone;
			this.role = role;
		}

    public Utilisateur(int id, String nom, String prenom, String email, String password, int telephone, String role) {
                        this.idUtilisateur=id;
                        this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.password = password;
			this.telephone = telephone;
			this.role = role;
    }
    
    
    	        public int getIdUtilisateur() {
			return idUtilisateur;
		}
		public void setIdUtilisateur(int id) {
			this.idUtilisateur = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getTelephone() {
			return telephone;
		}
		public void setTelephone(int telephone) {
			this.telephone = telephone;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
    
}
