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

import tn.spring.bookStore.entity.User;
import tn.spring.bookStore.service.IUserService;

@RestController
@RequestMapping("/api/user")

public class UserController {
	@Autowired
	private IUserService userService;
	//******************** Affichage Users **************
		@GetMapping("/users")
		public List<User> retrieveAllUsers() {
		return userService.retrieveAllUsers();
		}
	    //******************** Ajout Users ******************

		@PostMapping("/newuser") 
		public void addUser(@RequestBody User u) {
			userService.addUser(u); 
			
				}
		
	    //********************  Delete Users ***************
		@DeleteMapping("/delete/{id}")
		public void deleteUser(@PathVariable Long  id) {
			userService.deleteUser(id);
			
		}
	    //********************  Update Users ***************
		@PutMapping("/update/user")
		public void updateUser(@RequestBody User u) {
			userService.updateUser(u);	
		}
	    //*******************  Recherche User **************

		@GetMapping("/{id}")
		public Optional<User> retrieveUser(@PathVariable Long id) {
			return userService.retrieveUser(id);
		}
}
