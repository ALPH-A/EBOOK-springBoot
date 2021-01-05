package tn.spring.bookStore.repository;
import tn.spring.bookStore.entity.Evenement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement,Long>{

}
