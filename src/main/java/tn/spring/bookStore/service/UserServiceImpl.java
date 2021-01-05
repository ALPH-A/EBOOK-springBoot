package tn.spring.bookStore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import tn.spring.bookStore.entity.User;
import tn.spring.bookStore.repository.UserRepository;
import tn.spring.bookStore.service.UserServiceImpl;
import tn.spring.bookStore.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	UserRepository userRepository;
	
	
	//******************** Affichage Users **************
	 @Override
	public List<User> retrieveAllUsers() {
	return (List<User>) userRepository.findAll() ;
	}
    //******************** Ajout Users ******************

	 @Override
	 public void addUser(User u) {
		 userRepository.save(u);
		}
	
    //********************  Delete Users ***************
	 @Override
	 public void deleteUser(Long  id) {
		userRepository.deleteById(id);
	}
    //********************  Update Users ***************
	 @Override
	 public void updateUser(User u) {
		userRepository.save(u);
	}
    //*******************  Recherche User **************

	 @Override
	 public Optional<User> retrieveUser( Long id) {
	   return userRepository.findById(id);
	}
}