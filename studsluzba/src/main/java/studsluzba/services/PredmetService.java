package studsluzba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.Predmet;
import studsluzba.repositories.PredmetRepository;

@Service
public class PredmetService {

	@Autowired
	PredmetRepository predmetRepo;
	
	public Predmet savePredmet(Predmet p) {
		return predmetRepo.save(p);
	}
	
	public void deletePredmet(Predmet p) {
		predmetRepo.delete(p);
	}
}
