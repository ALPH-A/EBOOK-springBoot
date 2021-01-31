package tn.spring.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import tn.spring.bookStore.beans.AvisBean;
import tn.spring.bookStore.beans.AvisBean;
import tn.spring.bookStore.entity.Avis;
import tn.spring.bookStore.entity.Avis;
import tn.spring.bookStore.entity.User;
import tn.spring.bookStore.exception.ServiceValidationException;
import tn.spring.bookStore.service.AvisService;

@RestController
@RequestMapping(value = "/avis")
public class AvisConntroller {

	@Autowired
	private AvisService avisService;

	@PostMapping
	public Avis createAvis(@Validated @RequestBody AvisBean avisbean) {
		try {
			return avisService.save(avisbean);
		} catch (ServiceValidationException e) {
			throw new ResponseStatusException(e.getStatus(), e.getMessage(), e);
		}
	}

	@GetMapping
	public List<Avis> getAvis() {
		return avisService.findAll();

	}

	@GetMapping("/{id}")
	public Avis findAvisById(@PathVariable int id) {
		try {
			return avisService.findById(id);
		} catch (ServiceValidationException e) {
			throw new ResponseStatusException(e.getStatus(), e.getMessage(), e);
		}
	}

	@DeleteMapping("/{id}")
	public void deleteAvis(@PathVariable int id) {
		try {
			avisService.deleteById(id);
		} catch (ServiceValidationException e) {
			throw new ResponseStatusException(e.getStatus(), e.getMessage(), e);
		}

	}

	@PutMapping("/{id}")
	public Avis updateAvis(@RequestBody AvisBean r, @PathVariable long id) throws ServiceValidationException {
		return avisService.save(r);

	}

}
