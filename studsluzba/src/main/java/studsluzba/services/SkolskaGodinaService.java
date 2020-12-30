package studsluzba.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.SkolskaGodina;
import studsluzba.repositories.SkolskaGodinaRepository;

@Service
public class SkolskaGodinaService {
	
	@Autowired
	SkolskaGodinaRepository sgRepo;
	
	public List<SkolskaGodina> getSkolskeGodine() {
		Iterable<SkolskaGodina> iter = sgRepo.findAll();
		List<SkolskaGodina> rez = new ArrayList<SkolskaGodina>();
		iter.forEach(rez::add);
		return rez;
	}
	
	public SkolskaGodina getByValue(String godina) {
		return sgRepo.getByValue(godina);
	}
	
	public SkolskaGodina saveSkolskaGodina(SkolskaGodina sg) {
		return sgRepo.save(sg);
	}

	public SkolskaGodina getAktivna() {
		return sgRepo.getAktivna();
	}
	
//	public SkolskaGodina updateSkolskaGodina(SkolskaGodina sg) {
//		sgRepo.updateSkolskaGodina(sg.getIdSkolskeGodine());
//		return sgRepo.findSkolskaGodina(sg.getIdSkolskeGodine());
//	}
}
