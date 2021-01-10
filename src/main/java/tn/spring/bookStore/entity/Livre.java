package tn.spring.bookStore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity

public class Livre {

	
	@Id
	 @GeneratedValue
	    private Long id;
	    private String titre;
	    private String description; 
	    private String auteur ;
	    private double prix;
	    private String genre;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTitre() {
			return titre;
		}
		public void setTitre(String titre) {
			this.titre = titre;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getAuteur() {
			return auteur;
		}
		public void setAuteur(String auteur) {
			this.auteur = auteur;
		}
		public double getPrix() {
			return prix;
		}
		public void setPrix(double prix) {
			this.prix = prix;
		}
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		public Livre(Long id, String titre, String description, String auteur, double prix, String genre) {
		
			this.id = id;
			this.titre = titre;
			this.description = description;
			this.auteur = auteur;
			this.prix = prix;
			this.genre = genre;
		}
		public Livre(Long id) {
			
			this.id = id;
			
		}
		public Livre() {
			
		}
	    
	
	
	
	
	
	
	
	
	
}
