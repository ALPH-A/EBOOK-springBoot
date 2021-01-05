package tn.spring.bookStore.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.bookStore.entity.Evenement;
import tn.spring.bookStore.service.IEvenementService;

@RestController
@RequestMapping("/api/evenement")
public class EvenementController {
	@Autowired
	private IEvenementService evenementService;
	@GetMapping()
	public List<Evenement> getEvenements(){
		return evenementService.getEvenements();
	}
	@GetMapping("/{id}")
	public Evenement getEvenementById(@PathVariable Long id) {
		 return evenementService.getEvenementById(id);
				 
	}

	@PostMapping
	public void addEvenement(@RequestBody Evenement evenement) {
		evenementService.addEvenement(evenement);
	}
	
	@PutMapping("/update")
	public void updateEvenement(@RequestBody Evenement evenement) {
		evenementService.updateEvenement(evenement);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEvenement(@PathVariable Long id) {
		evenementService.deleteEvenement (id);
	}
}
