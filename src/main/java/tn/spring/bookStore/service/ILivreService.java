package tn.spring.bookStore.service;
import java.util.List;
import java.util.Optional;

import tn.spring.bookStore.entity.Livre;



public interface ILivreService {
	List<Livre> getLivres();
	
	void addLivre(Livre livre);
	
	void updateLivre (Livre livre);
	
	Optional<Livre> getLivre(/*@Min(value = 1L, message = "Invalid product ID.")*/ Long id);
	void deleteLivre(Long id);
	

}


