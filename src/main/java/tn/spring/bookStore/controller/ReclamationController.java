package tn.spring.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.compiler.ast.ASTList;
import tn.spring.bookStore.entity.Command;
import tn.spring.bookStore.entity.Reclamation;
import tn.spring.bookStore.service.ReclamationService;


@RestController

public class ReclamationController {
	
	@Autowired
	private ReclamationService service ;
	@PostMapping("/createReclamation")
	public Reclamation createReclamtion(@RequestBody Reclamation reclamation) {
	//reclamation.setRefReclamation(refReclamation);
		return service.saveReclamation(reclamation);
	}
	@GetMapping("/getReclamations")
	public List<Reclamation> getReclamation(){
		return (List<Reclamation>)service.getReclamations();
		
	}
	/*
    @PostMapping("/addCommands")
    public List<Reclamation> addReclamation(@RequestBody List<Reclamation> reclamations) {
        return service.saveReclamation(reclamations);
    }
    */
    @GetMapping("/AllReclamations")
    public List<Reclamation> findAllProducts() {
        return service.getReclamations();
    }
    @GetMapping("/ReclamationById/{id}")
    public Reclamation findCommandById(@PathVariable int id) {
        return service.getReclamationById(id);
    }
    @DeleteMapping("/ReclamationDelete/{id}")
    public String deleteCommand(@PathVariable int id) {
        return service.deleteReclamation(id);
    }
	
	

}
