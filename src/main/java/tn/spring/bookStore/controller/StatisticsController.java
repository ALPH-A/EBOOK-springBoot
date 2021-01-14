package tn.spring.bookStore.controller;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.type.LongType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.bookStore.entity.Command;
import tn.spring.bookStore.entity.Livre;
import tn.spring.bookStore.service.CommandService;

@RestController
public class StatisticsController {
	
	@Autowired
    private CommandService service;
	@PersistenceContext
	private EntityManager em;
	    
	@GetMapping(value="topTenSelledBook")
	public List<Object[]> getTopTenSelledBook() {
		javax.persistence.Query q = em.createNativeQuery("SELECT `livres_id`, COUNT(`livres_id`) AS `value_occurrence` FROM `command_livres` GROUP BY `livres_id` ORDER BY `value_occurrence` DESC LIMIT 10");
		List<Object[]> list = q.getResultList();
		return list;
	}
	@GetMapping(value="totalCommand")
	public BigInteger getTotalCommand() {
		javax.persistence.Query q = em.createNativeQuery("SELECT COUNT(*) AS count FROM command");
		BigInteger count = (BigInteger) q.getSingleResult();
		return count;
	}
	@GetMapping(value="totalUser")
	public BigInteger getTotalUser() {
		javax.persistence.Query q = em.createNativeQuery("SELECT COUNT(*) AS count FROM user");
		BigInteger count = (BigInteger) q.getSingleResult();
		return count;
	}
	@GetMapping(value="totalLivre")
	public BigInteger getTotalLivre() {
		javax.persistence.Query q = em.createNativeQuery("SELECT COUNT(*) AS count FROM livre");
		BigInteger count = (BigInteger) q.getSingleResult();
		return count;
	}
		

}
