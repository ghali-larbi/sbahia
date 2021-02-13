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

    public Poterie(int id, int vote) {
        this.idPoterie=id;
        this.vote=vote;
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
}
