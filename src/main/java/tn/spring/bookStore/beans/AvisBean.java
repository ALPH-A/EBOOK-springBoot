package tn.spring.bookStore.beans;

/**
 * @author sami-PC
 *
 */
public class AvisBean {

	private Integer id;
	private String commentaire;
	private Integer rate;
	
	private Integer livreId;
	private Long userId;
	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public AvisBean() {
		super();
	}

	public AvisBean(Integer id, String commentaire, Integer rate) {
		super();
		this.id = id;
		this.commentaire = commentaire;
		this.rate = rate;
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

	public Integer getLivreId() {
		return livreId;
	}

	public void setLivreId(Integer livreId) {
		this.livreId = livreId;
	}


}
