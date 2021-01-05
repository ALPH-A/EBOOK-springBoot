package tn.spring.bookStore.service;

import java.util.List;
import java.util.Optional;

import tn.spring.bookStore.entity.User;

public interface IUserService {
	List<User> retrieveAllUsers();
	void addUser(User u);
	void deleteUser(Long id);
	void updateUser(User u);
	Optional<User> retrieveUser(Long id);
}
