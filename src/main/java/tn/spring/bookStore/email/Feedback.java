package tn.spring.bookStore.email;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Feedback {
	
	//utulisateur connecté 
	@NotNull()   
	private String name;
	@NotNull
	@Email
	private String email;
	
	@NotNull(message = "l'email ne doit pas étre vide !!")
	@Min(value = 5)
	 private  String feedback;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	
}
