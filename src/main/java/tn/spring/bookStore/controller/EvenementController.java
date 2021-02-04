package tn.spring.bookStore.controller;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.bookStore.entity.Evenement;
import tn.spring.bookStore.service.IEvenementService;

@RestController
@RequestMapping("/api/evenement")
public class EvenementController {
	@Autowired
	private IEvenementService evenementService;
	@PersistenceContext
	private EntityManager entity;

	@GetMapping()
	public List<Evenement> getEvenements() {
		return evenementService.getEvenements();
	}

	@GetMapping("/{id}")
	public Evenement getEvenementById(@PathVariable Long id) {
		return evenementService.getEvenementById(id);
	}

	@PostMapping
	public void addEvenement(@RequestBody Evenement evenement) {
		evenementService.addEvenement(evenement);
	}

	@PutMapping("/update")
	public void updateEvenement(@RequestBody Evenement evenement) {
		evenementService.updateEvenement(evenement);
	}

	@DeleteMapping("/{id}")
	public void deleteEvenement(@PathVariable Long id) {
		evenementService.deleteEvenement(id);
	}

	@GetMapping("/totalEvents")
	public BigInteger getTotalEvents() {
		javax.persistence.Query query = entity.createNativeQuery("SELECT COUNT(*) AS count FROM evenement");
		BigInteger count = (BigInteger) query.getSingleResult();
		return count;
	}

	@GetMapping("/EventOrder")
	public List<Evenement> getEvenementByDateOrder() {
		javax.persistence.Query query = entity.createNativeQuery("SELECT * FROM evenement ORDER BY date DESC");
		List<Evenement> list = query.getResultList();
		return list;
	}

	@GetMapping("/nom/{title}")
	public List<Evenement> getEvenementByTitre(@PathVariable String title) {
		javax.persistence.Query query = entity.createNativeQuery("SELECT * FROM evenement where titre='" + title + "'");
		List<Evenement> list = query.getResultList();
		return list;
	}

	@GetMapping("/place/{lieu}")
	public List<Evenement> getEvenementByLieu(@PathVariable String lieu) {
		javax.persistence.Query query = entity.createNativeQuery("SELECT * FROM evenement where lieu='" + lieu + "'");
		List<Evenement> list = query.getResultList();
		return list;
	}

	@GetMapping("/EventStill")
	public List<Evenement> getEvenementByDateNotHappened() {
		Date da = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String d = (formatter.format(da));
		javax.persistence.Query query = entity.createNativeQuery("SELECT * FROM evenement where date > '" + d + "' ");
		List<Evenement> list = query.getResultList();
		return list;
	}
}
