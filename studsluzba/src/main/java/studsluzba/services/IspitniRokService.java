package studsluzba.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.Ispit;
import studsluzba.model.IspitniRok;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.Student;
import studsluzba.model.Studprogram;
import studsluzba.repositories.IspitniRokRepository;
import studsluzba.repositories.StudentRepository;

@Service
public class IspitniRokService {
	
	@Autowired
	IspitniRokRepository ispitniRokRepo;

	public IspitniRok saveIspitniRok(IspitniRok ir) {
		return ispitniRokRepo.save(ir);
	}

	public List<IspitniRok> getAll() {
		
		Iterable<IspitniRok> iter = ispitniRokRepo.findAll();
		List<IspitniRok> rez = new ArrayList<IspitniRok>();
		iter.forEach(rez::add);
		return rez;
	}
	
	public SkolskaGodina findSkolskaGodina(IspitniRok ir) {
		return ispitniRokRepo.findSkolskaGodina(ir);
	}
	
	public IspitniRok findByParams(SkolskaGodina sg, String mesec) {
		return ispitniRokRepo.findByParams(sg, mesec);
	}

}
