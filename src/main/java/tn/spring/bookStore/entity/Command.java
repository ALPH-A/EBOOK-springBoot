package tn.spring.bookStore.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Command {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private LocalDateTime createdAt;
	@ManyToMany(
            cascade = CascadeType.REMOVE)
    private Set<Livre> livres ;
	@OneToOne
	private User user;
	private Double totalPrize;
	
	public Command() {
		super();
	}
	
	public Command(LocalDateTime createdAt) {
		super();
		this.createdAt = createdAt;
	}

	public Command(LocalDateTime createdAt, Set<Livre> livres) {
		super();
		this.createdAt = createdAt;
		this.livres = livres;
	}
	

	public Command(LocalDateTime createdAt, Set<Livre> livres, User user) {
		super();
		this.createdAt = createdAt;
		this.livres = livres;
		this.user = user;
	}
	

	public Command(LocalDateTime createdAt, Set<Livre> livres, User user, Double totalPrize) {
		super();
		this.createdAt = createdAt;
		this.livres = livres;
		this.user = user;
		this.totalPrize = totalPrize;
	}

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

	public Set<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	public Double getTotalPrize() {
		return totalPrize;
	}

	public void setTotalPrize(Double totalPrize) {
		this.totalPrize = totalPrize;
	}

	@Override
	public String toString() {
		return "Command [id=" + id + ", createdAt=" + createdAt + ", livres=" + livres + "]";
	}
	
	
	
	
}
