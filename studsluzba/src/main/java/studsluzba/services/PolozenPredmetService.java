package studsluzba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.PolozenPredmet;
import studsluzba.model.Predmet;
import studsluzba.model.StudIndex;
import studsluzba.repositories.PolozenPredmetRepository;

@Service
public class PolozenPredmetService {

	@Autowired
	PolozenPredmetRepository ppRepo;
	
	public PolozenPredmet save(PolozenPredmet pp) {
		return ppRepo.save(pp);
	}
	
	public List<Predmet> findPredmetiByStudent(StudIndex si) {
		return ppRepo.findPredmetByStudIndex(si);
	}
	
}
