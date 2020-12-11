package studsluzba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.TokStudija;
import studsluzba.repositories.TokStudijaRepository;

@Service
public class TokStudijaService {

	@Autowired
	TokStudijaRepository tsRepo;
	

	public TokStudija save(TokStudija ts) {
		return tsRepo.save(ts);
	}
	
	public void delete(TokStudija ts) {
		tsRepo.delete(ts);
	}
	
}
