package tn.spring.bookStore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long id;
	private String firstName;
	private String lastName ;
	private String Email;
	private String password;
	private Long num_tele;
	private String adresse;
	private String role;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getNumtele() {
		return num_tele;
	}
	public void setNumtele(Long num_tele) {
		this.num_tele = num_tele;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public User() {
		
	}
	public User( String firstName, String lastName,String Email,String password,Long num_tele,String adresse,String role) {
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.Email = Email;
		this.password = password;
		this.num_tele = num_tele;
		this.adresse = adresse;
		this.role = role;
	}
	
	
}