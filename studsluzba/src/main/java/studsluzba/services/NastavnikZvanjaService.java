package studsluzba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.Nastavnik;
import studsluzba.model.NastavnikZvanja;
import studsluzba.model.Zvanje;
import studsluzba.repositories.NastavnikZvanjaRepository;

@Service
public class NastavnikZvanjaService {
	@Autowired
	NastavnikZvanjaRepository nzRepo;
	
	public NastavnikZvanja saveNastavnikZvanja(NastavnikZvanja nz) {
		return nzRepo.save(nz);
	}
	
	public void deleteNastavnikZvanja(NastavnikZvanja nz) {
		nzRepo.delete(nz);
	}
	
	public List<Zvanje> findZvanjaByNastavnik(Nastavnik n) {
		Integer i = n.getIdNastavnik();
		return nzRepo.findZvanjeByNastavnik(i);
	}
	
}
