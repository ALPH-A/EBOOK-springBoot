package tn.spring.bookStore.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Evenement {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String Titre;
	private String Lieu;
	private String Description;
	private Date date;
	
	
	public Evenement() {
		
	}
	public Evenement(Long id, String titre, String lieu, String description, Date date) {
		
		this.id = id;
		Titre = titre;
		Lieu = lieu;
		Description = description;
		this.date = date;
	}
	
public Evenement(String titre, String lieu, String description, Date date) {
		
		
		Titre = titre;
		Lieu = lieu;
		Description = description;
		this.date = date;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
	}
	public String getLieu() {
		return Lieu;
	}
	public void setLieu(String lieu) {
		Lieu = lieu;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Evenement [id=" + id + ", Titre=" + Titre + ", Lieu=" + Lieu + ", Description=" + Description
				+ ", date=" + date + "]";
	}
	
	
}
