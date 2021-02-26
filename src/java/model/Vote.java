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
public class Vote {
     private int idVote;
    private int idPoterie;
    private int idUtilisateur;

    
		public Vote(int idPoterie, int idUtilisateur) {
			super();
			this.idPoterie = idPoterie;
			this.idUtilisateur = idUtilisateur;
			
		}
                public Vote(int idV,int idPoterie, int idUtilisateur) {
			super();
                        this.idVote=idV;
			this.idPoterie = idPoterie;
			this.idUtilisateur = idUtilisateur;
                      
			
		}

   
		public int getIdVote() {
			return idVote;
		}
		public void setIdVote(int idVote) {
			this.idVote = idVote;
		}
		public int getIdPoterie() {
			return idPoterie;
		}
		public void setIdPoterie(int idPoterie) {
			this.idPoterie = idPoterie;
		}
		public int getIdUtilisateur() {
			return idUtilisateur;
		}
		public void setIdUtilisateur(int idUtilisateur) {
			this.idUtilisateur = idUtilisateur;
		}
	
  
}
