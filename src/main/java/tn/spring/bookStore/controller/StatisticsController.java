package tn.spring.bookStore.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping(value="totalMoneyMade")
	public Double totalMoneyMade() {
		javax.persistence.Query q = em.createNativeQuery("SELECT SUM(total_Prize) FROM command");
		Double totalMoney = (Double) q.getSingleResult();
		return totalMoney;
	}
	@GetMapping(value="totalMoneyMadeByPeriod/{firstDate}/{lastDate}")
	public long totalMoneyMadeByPeriod(@PathVariable String firstDate,@PathVariable String lastDate) {
		javax.persistence.Query q = em.createNativeQuery("SELECT SUM(total_Prize) FROM command where created_at BETWEEN '"+firstDate+"' AND '"+lastDate+"'");
		long totalMoney = (long) q.getSingleResult();
		return totalMoney;
	}
	@GetMapping(value="predicationMoneyNextMounth")
	public Double predictionMoneyNextMounth() {
		Double totalMoney = totalMoneyMade();
		javax.persistence.Query q = em.createNativeQuery("SELECT DATE_FORMAT(created_at, '%Y%m%d') FROM command");
		List<Object> list = q.getResultList();
		String first = list.get(0).toString();
		String last = list.get(list.size()-1).toString();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd"); 
		LocalDate  dateTime = LocalDate.parse(first,formatter);
		LocalDate  dateTime2 = LocalDate.parse(last,formatter);
		LocalDateTime firstDate = LocalDateTime.of(dateTime, LocalTime.of(0,0));
		LocalDateTime lastDate = LocalDateTime.of(dateTime2, LocalTime.of(0,0));
		long firstDateSecondes = firstDate.toEpochSecond(ZoneOffset.UTC);
		long lastDateSecondes = lastDate.toEpochSecond(ZoneOffset.UTC);
		int nbMounth =(int) ((lastDateSecondes-firstDateSecondes)/(60*60*24*30));
		long avgMoneyPerMounth = (long) (totalMoney/nbMounth);
		javax.persistence.Query q1 = em.createNativeQuery("SELECT DATE_FORMAT(created_at, '%Y%m'),total_prize FROM command");
		List<Object[]> list1 = q1.getResultList();
		String n = new String();
		Double b = 0.0;
		List<Double> list2 =  new ArrayList<Double>();
		for (Object[] objects : list1) {
			if (!n.equals(objects[0].toString())) {
				n = objects[0].toString();
				if (objects[1]!= null) {
					b=b+(Double) objects[1];
				}
				list2.add(b);
				b=0.0;
			}
			if (n.equals(objects[0].toString())) {
				if (objects[1]!= null) {
					b=b+(Double) objects[1];
				}
				
			}
			 
		}
		Double d = 0.0;
		Double growth = 1.0;
		for (Double double1 : list2) {
			if (d==0.0) {
				d=double1;
			}
			else {
				growth = growth + ((double1-d)/d);
				d=double1;
			}
		}
		
		
		
		
		return avgMoneyPerMounth*growth;
	}
	
	
	
	
}
