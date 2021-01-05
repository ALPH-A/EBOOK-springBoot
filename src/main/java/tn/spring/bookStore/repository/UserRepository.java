package tn.spring.bookStore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.bookStore.entity.*;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
}