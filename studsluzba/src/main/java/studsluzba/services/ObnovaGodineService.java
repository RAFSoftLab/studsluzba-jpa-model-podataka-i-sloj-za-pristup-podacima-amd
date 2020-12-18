package studsluzba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.ObnovaGodine;
import studsluzba.model.StudIndex;
import studsluzba.repositories.ObnovaGodineRepository;

@Service
public class ObnovaGodineService {

	@Autowired
	ObnovaGodineRepository ogRepo;
	
	public ObnovaGodine save(ObnovaGodine og) {
		return ogRepo.save(og);
	}
	
	public void delete(ObnovaGodine og) {
		ogRepo.delete(og);
	}
	
	public List<ObnovaGodine> findByStudIndex(StudIndex si) {
		return ogRepo.findByStudIndex(si);
	}
	
}
