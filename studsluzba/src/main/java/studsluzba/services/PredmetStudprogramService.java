package studsluzba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.Predmet;
import studsluzba.model.PredmetStudprogram;
import studsluzba.model.Studprogram;
import studsluzba.repositories.PredmetStudprogramRepository;

@Service
public class PredmetStudprogramService {

	@Autowired
	PredmetStudprogramRepository pspRepo;
	
	public PredmetStudprogram save(PredmetStudprogram psp) {
		return pspRepo.save(psp);
	}
	
	public void delete(PredmetStudprogram p) {
		pspRepo.delete(p);
	}
	
	public List<Predmet> findBySP(Studprogram sp) {
		return pspRepo.findPredmetByStudprogram(sp);
	}
	
	public List<Studprogram> findByPredmet(Predmet p) {
		return pspRepo.findStudprogramByPredmet(p);
	}
}
