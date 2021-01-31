package tn.spring.bookStore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author sami-PC
 *
 */
@Entity
public class Avis {
	@Id
	@GeneratedValue
	private Integer id;
	private String commentaire;
	private Integer rate;
	@ManyToOne
	@JoinColumn(name = "livre_id")
	private Livre livre;

	@ManyToOne
	@JoinColumn(name ="user_id" )
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public Avis(Integer id, String commentaire, Integer rate, Livre livre) {
		super();
		this.id = id;
		this.commentaire = commentaire;
		this.rate = rate;
		this.livre = livre;
	}

	public Avis() {
		super();
		this.rate = 1;
	}

}
