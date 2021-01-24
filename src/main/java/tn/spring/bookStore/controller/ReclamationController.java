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

import javassist.compiler.ast.ASTList;
import tn.spring.bookStore.beans.ReclamationBean;
import tn.spring.bookStore.entity.Command;
import tn.spring.bookStore.entity.Reclamation;
import tn.spring.bookStore.entity.User;
import tn.spring.bookStore.service.ReclamationService;


@RestController
@RequestMapping(value = "/reclamations")
public class ReclamationController {
	
	@Autowired
	private ReclamationService service ;
	@PostMapping
	public Reclamation createReclamtion(@Validated @RequestBody ReclamationBean reclamation) {
	//reclamation.setRefReclamation(refReclamation);
		return service.saveReclamation(reclamation);
	}
	@GetMapping
	public Iterable<Reclamation> getReclamation(){
		return service.getReclamations();
		
	}
	/*
    @PostMapping("/addCommands")
    public List<Reclamation> addReclamation(@RequestBody List<Reclamation> reclamations) {
        return service.saveReclamation(reclamations);
    }
    */
   
    @GetMapping("/{id}")
    public Reclamation findReclamationById(@PathVariable int id) {
        return service.getReclamationById(id);
    }
    @GetMapping("/{id}/user")
    public User findUserByReclamationId(@PathVariable int id) {
        return service.getReclamationById(id).getUser();
    }
    /*
    @GetMapping("/ReclamationByName/{name}")
    public Reclamation findReclamationByName(@PathVariable String name) {
        return service.getReclamationByName(name);
    }
    */
    @DeleteMapping("/{id}")
    public String deleteReclamation(@PathVariable int id) {
        return service.deleteReclamation(id);
    }
    
    @PutMapping("/{id}")
    public Reclamation updateReclamation (@RequestBody Reclamation r,@PathVariable long id){
    	return service.updateReclamation(r,id);
    	
    	
    }
	
	

}
