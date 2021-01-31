package tn.spring.bookStore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import tn.spring.bookStore.beans.AvisBean;
import tn.spring.bookStore.entity.Avis;
import tn.spring.bookStore.entity.Livre;
import tn.spring.bookStore.entity.User;
import tn.spring.bookStore.exception.ServiceValidationException;
import tn.spring.bookStore.repository.AvisRepository;
import tn.spring.bookStore.repository.LivreRepository;
import tn.spring.bookStore.repository.UserRepository;

@Service
public class AvisServiceImpl implements AvisService {

	@Autowired
	private AvisRepository avisRepository;
	@Autowired
	private LivreRepository livrerepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public Avis findById(Integer id) throws ServiceValidationException{
		 Optional<Avis> avisOpt =avisRepository.findById(id);
		 if(!avisOpt.isPresent()) {
			 throw new ServiceValidationException(HttpStatus.NOT_FOUND.value(), "avis non trouvé");
		 }
		return avisOpt.get();
	}

	@Override
	public List<Avis> findAll() {
		return avisRepository.findAll();
	}

	@Override
	public Avis save(AvisBean t) throws ServiceValidationException{
		Avis avis = new Avis();
		avis.setId(t.getId());
		avis.setCommentaire(t.getCommentaire());
		avis.setRate(t.getRate());
		Optional<Livre> optLivre = livrerepository.findById(t.getLivreId().longValue());
		Optional<User> optuser = userRepository.findById(t.getUserId());
		if (!optLivre.isPresent()) {
			 throw new ServiceValidationException(HttpStatus.NOT_FOUND.value(), "livre non trouvé");
		}
		if (!optuser.isPresent()) {
			 throw new ServiceValidationException(HttpStatus.NOT_FOUND.value(), "user non trouvé");
		}
		avis.setLivre(optLivre.get());
		return avisRepository.save(avis);
	}

	@Override
	public void deleteById(Integer id) throws ServiceValidationException {
		 Optional<Avis> avisOpt =avisRepository.findById(id);
		 if(!avisOpt.isPresent()) {
			 throw new ServiceValidationException(HttpStatus.NOT_FOUND.value(), "avis non trouvé");
		 }
		
		avisRepository.deleteById(id);
	}

}
