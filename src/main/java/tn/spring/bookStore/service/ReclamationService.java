package tn.spring.bookStore.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.bookStore.beans.ReclamationBean;
import tn.spring.bookStore.entity.Reclamation;
import tn.spring.bookStore.entity.User;
import tn.spring.bookStore.repository.ReclamationRepository;
import tn.spring.bookStore.repository.UserRepository;

@Service
public class ReclamationService {

	@Autowired
	private ReclamationRepository repository;
	@Autowired
	private UserRepository userRepository;

	public Reclamation saveReclamation(ReclamationBean r) {
		 Optional<User> user =userRepository.findById(54L);
		 Reclamation rec =new Reclamation();
		 rec.setUser(user.get());
		 rec.setCreatedAt(LocalDateTime.now());
		 rec.setFinishedAt(LocalDateTime.now());
		 rec.setSujet(r.getSujet());
		 rec.setDescription(r.getDescription());
		 rec.setStatus("en cours");
		return repository.save(rec);
	}

	public List<Reclamation> saveReclamation(List<Reclamation> r) {
		return repository.saveAll(r);
	}

	public Iterable<Reclamation> getReclamations() {
		return repository.findAll();
	}

	public Reclamation getReclamationById(int id) {
		return repository.findById((long) id).orElse(null);
	}
/*
	public Reclamation getReclamationByName(String name) {

		return repository.findByName(name);

	}
	*/

	public String deleteReclamation(int id) {
		repository.deleteById((long) id);
		return "Reclamation removed !! " + id;
	}

	public Reclamation updateReclamation(Reclamation r,long id) {
		Reclamation existingReclamation = repository.findById(id).orElse(null);
		existingReclamation.setSujet(r.getSujet());
		existingReclamation.setDescription(r.getDescription());
		return repository.save(existingReclamation);

	}

}
