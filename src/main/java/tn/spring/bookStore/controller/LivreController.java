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


import tn.spring.bookStore.entity.Livre;
import tn.spring.bookStore.service.ILivreService;



@RestController
@RequestMapping("/api/livre")
public class LivreController {
	@Autowired
	private ILivreService livreService;
	@GetMapping()
	public List<Livre> getLivres(){
		return livreService.getLivres();
	}
	@GetMapping("/{id}")
	public Optional<Livre> getLivre(@PathVariable Long id) {
		 return livreService.getLivre(id);
				 
	}

	@PostMapping("/newLivre")
	public void addLivre(@RequestBody Livre livre) {
		livreService.addLivre(livre);
	}
	
	@PutMapping("/update")
	public void updateLivre(@RequestBody Livre livre) {
		livreService.updateLivre(livre);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProduit(@PathVariable Long id) {
		livreService.deleteLivre (id);
	}
	
}
