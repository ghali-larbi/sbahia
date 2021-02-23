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
public class Poterie {
    private int idPoterie;
    private String image;
    private String nom;
    private int prix;
    private int vote;
    private int idUtilisateur;
    private boolean choix;
     public Poterie(String image,String nom, int prix, int vote,int id,boolean choix) {
	        this.image=image;
		this.nom = nom;
		this.prix = prix;
		this.vote = vote;
                this.idUtilisateur=id;
                this.choix=choix;
	}
    public Poterie(String image,String nom, int prix, int vote) {
	        this.image=image;
		this.nom = nom;
		this.prix = prix;
		this.vote = vote;
	}
     public Poterie(int id,String image,String nom, int prix, int vote) {
         this.idPoterie=id;
	        this.image=image;
		this.nom = nom;
		this.prix = prix;
		this.vote = vote;
	}
       public Poterie(int id,String image,String nom, int prix) {
         this.idPoterie=id;
	        this.image=image;
		this.nom = nom;
		this.prix = prix;
		
	}
        public Poterie(int id,String image,String nom, int prix, int vote,int idU,boolean choix) {
            
         this.idPoterie=id;
	        this.image=image;
		this.nom = nom;
		this.prix = prix;
                this.vote=vote;
                this.idUtilisateur=idU;
	this.choix=choix;	
	}

    public Poterie(int id, int vote,int idU,boolean choix) {
        this.idPoterie=id;
        this.vote=vote;
        this.idUtilisateur=idU;
        this.choix=choix;
    }

    
	public int getIdPoterie() {
		return idPoterie;
	}
	public void setIdPoterie(int idPoterie) {
		this.idPoterie = idPoterie;
	}
        public String getImage() {
		return image;
	}
	public String getNom() {
		return nom;
	}
        public void getImage(String image) {
		this.image =image;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public int getVote() {
		return vote;
	}
	public void setVote(int vote) {
		this.vote = vote;
	}
        public boolean getChoix() {
		return choix;
	}
	public void setChoix(boolean choix) {
		this.choix = choix;
	}
        public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idU) {
		this.idUtilisateur = idU;
	}
}
