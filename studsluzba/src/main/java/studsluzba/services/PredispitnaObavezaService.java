package studsluzba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.PredispitnaObaveza;
import studsluzba.model.Predmet;
import studsluzba.repositories.PredispitnaObavezaRepository;

@Service
public class PredispitnaObavezaService {

	@Autowired
	PredispitnaObavezaRepository poRepo;
	
	public PredispitnaObaveza find(String naziv, int poeni) {
		return poRepo.findByParams(naziv, poeni);
	}
	
	public PredispitnaObaveza save(PredispitnaObaveza po) {
		return poRepo.save(po);
	}
	
}
