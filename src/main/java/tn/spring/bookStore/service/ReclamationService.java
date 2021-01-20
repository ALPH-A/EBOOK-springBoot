package tn.spring.bookStore.service;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import tn.spring.bookStore.entity.Command;
import tn.spring.bookStore.entity.Reclamation;
import tn.spring.bookStore.repository.ReclamationRepository;

@Service
public class ReclamationService {

	@Autowired
	private ReclamationRepository repository;

	public Reclamation saveReclamation(Reclamation r) {
		return repository.save(r);
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

	public Reclamation updateReclamation(Reclamation r) {
		Reclamation existingReclamation = repository.findById(r.getId()).orElse(null);
		existingReclamation.setSujet(r.getSujet());
		existingReclamation.setDescription(r.getDescription());
		return repository.save(existingReclamation);

	}

}
