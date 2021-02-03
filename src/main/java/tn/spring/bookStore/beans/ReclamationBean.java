package tn.spring.bookStore.beans;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * @author sami-PC
 *
 */
public class ReclamationBean {
	@NotNull(message = "le sujet de la reclamation est obligatoir")
	@Size(min = 5)
	private String sujet;
	@NotNull(message = "la description de la reclamation est obligatoir")
	@Size(min = 10)
	private String description;
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
	
	public ReclamationBean() {
		super();
		
	}
	

}
