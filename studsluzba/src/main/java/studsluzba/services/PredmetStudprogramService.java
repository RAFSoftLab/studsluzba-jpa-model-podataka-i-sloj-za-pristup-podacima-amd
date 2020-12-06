package studsluzba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.PredmetStudprogram;
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
	
}
