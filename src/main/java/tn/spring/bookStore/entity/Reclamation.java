package tn.spring.bookStore.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table
public class Reclamation implements Serializable {
	private static final long serialVersionUID = 1L;
	 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private LocalDateTime  createdAt;
	private LocalDateTime finishedAt;
	private String sujet;
	private String description;
	private String status;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	private String refReclamation;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getFinishedAt() {
		return finishedAt;
	}
	public void setFinishedAt(LocalDateTime finishedAt) {
		this.finishedAt = finishedAt;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getRefReclamation() {
		return refReclamation;
	}
	public void setRefReclamation(String refReclamation) {
		this.refReclamation = refReclamation;
	}
	
	
	
	public Reclamation() {
		
	}
	public Reclamation(Long id, LocalDateTime createdAt, LocalDateTime finishedAt, String sujet, String description,
			String status, User user, String refReclamation) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.finishedAt = finishedAt;
		this.sujet = sujet;
		this.description = description;
		this.status = status;
		this.user = user;
		this.refReclamation = refReclamation;
	}
	@Override
	public String toString() {
		return "Reclamation [id=" + id + ", createdAt=" + createdAt + ", finishedAt=" + finishedAt + ", sujet=" + sujet
				+ ", description=" + description + ", status=" + status + ", user=" + user + ", refReclamation="
				+ refReclamation + "]";
	}
	
	
}
