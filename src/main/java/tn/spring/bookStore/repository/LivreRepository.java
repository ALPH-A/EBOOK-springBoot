package tn.spring.bookStore.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import tn.spring.bookStore.entity.Livre;

public interface LivreRepository extends JpaRepository<Livre,Long>{

}
