package tn.spring.bookStore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.spring.bookStore.entity.Command;
//extend JpaRepository which contains(JpaRepository , CrudRepository and PagingAndSortingRepository) 
@Repository
public interface CommandRepository extends JpaRepository<Command,Long> {
	

	
}
