package studsluzba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.UpisGodine;
import studsluzba.repositories.UpisGodineRepository;

@Service
public class UpisGodineService {

	@Autowired
	UpisGodineRepository ugRepo;
	
	public UpisGodine save(UpisGodine ug) {
		return ugRepo.save(ug);
	}
	
	public void delete(UpisGodine ug) {
		ugRepo.delete(ug);
	}
}
