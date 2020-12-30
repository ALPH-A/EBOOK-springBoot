package tn.spring.bookStore.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//extend JpaRepository which contains(JpaRepository , CrudRepository and PagingAndSortingRepository) 
@Repository
public interface CommandRepository extends JpaRepository<Command,Long> {

}
