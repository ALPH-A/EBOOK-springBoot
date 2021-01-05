package tn.spring.bookStore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.bookStore.entity.Livre;
import tn.spring.bookStore.repository.LivreRepository;
@Service

public class LivreService implements ILivreService{
	@Autowired
	private LivreRepository livreRepository;
	
	@Override
	public List <Livre>  getLivres() {
		
	 return (List<Livre>) livreRepository.findAll();
		
		
				
				
		
	}

	@Override
	public void addLivre(Livre livre) {
		livreRepository.save(livre);
	}

	@Override
	public void updateLivre(Livre livre) {
		livreRepository.save(livre);

		
	}

	@Override
	public Optional<Livre> getLivre(Long id) {
		 return livreRepository.findById(id);
				 
	}

	@Override
	public void deleteLivre(Long id) {
		
		 livreRepository.deleteById(id);
	}

}