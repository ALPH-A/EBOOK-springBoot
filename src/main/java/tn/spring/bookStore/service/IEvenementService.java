package tn.spring.bookStore.service;

import java.util.List;
import tn.spring.bookStore.entity.Evenement;

public interface IEvenementService {
	List<Evenement> getEvenements();

	void addEvenement(Evenement evenement);

	void updateEvenement(Evenement evenement);

	Evenement getEvenementById(Long id);

	void deleteEvenement(Long id);
}
