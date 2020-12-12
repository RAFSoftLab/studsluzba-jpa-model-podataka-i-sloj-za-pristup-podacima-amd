package studsluzba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.Predmet;
import studsluzba.model.StudIndex;
import studsluzba.model.TokStudijaDrziPredmet;
import studsluzba.repositories.TokStudijaDrziPredmetRepository;
import studsluzba.repositories.UpisGodineRepository;

@Service
public class TokStudijaDrziPredmetService {

	@Autowired
	TokStudijaDrziPredmetRepository ugpRepo;
	
	public TokStudijaDrziPredmet save(TokStudijaDrziPredmet ugp) {
		return ugpRepo.save(ugp);
	}
	
	public void delete(TokStudijaDrziPredmet ugp) {
		ugpRepo.delete(ugp);
	}
	
	public List<Predmet> findPredmetiByStudent(StudIndex si) {
		return ugpRepo.findPredmetByStudent(si);
	}
}
