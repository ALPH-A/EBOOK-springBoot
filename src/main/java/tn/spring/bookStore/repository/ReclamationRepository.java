package tn.spring.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.spring.bookStore.entity.Reclamation;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long>{

	//Reclamation findByName(String name);

}
