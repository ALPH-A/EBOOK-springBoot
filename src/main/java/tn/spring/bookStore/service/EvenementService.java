package tn.spring.bookStore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.bookStore.entity.Evenement;
import tn.spring.bookStore.repository.EvenementRepository;

@Service
public class EvenementService implements IEvenementService {
	@Autowired
	private EvenementRepository evenementRepository;

	@Override
	public List<Evenement> getEvenements() {

		return (List<Evenement>) evenementRepository.findAll();

	}

	@Override
	public void addEvenement(Evenement evenement) {
		evenementRepository.save(evenement);
	}

	@Override
	public void updateEvenement(Evenement evenement) {

		evenementRepository.save(evenement);

	}

	@Override
	public Evenement getEvenementById(Long id) {
		return evenementRepository.findById(id).orElse(null);

	}

	@Override
	public void deleteEvenement(Long id) {

		evenementRepository.deleteById(id);
	}

}
