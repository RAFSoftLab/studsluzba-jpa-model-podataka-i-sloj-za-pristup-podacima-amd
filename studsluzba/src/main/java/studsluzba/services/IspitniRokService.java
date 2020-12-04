package studsluzba.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.Ispit;
import studsluzba.model.IspitniRok;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.Studprogram;
import studsluzba.repositories.IspitniRokRepository;
import studsluzba.repositories.StudentRepository;

@Service
public class IspitniRokService {
	
	@Autowired
	IspitniRokRepository ispitniRokRepo;

	public IspitniRok saveIspitniRok(LocalDate datumPocetka, LocalDate datumZavrsetka, List<Ispit> ispiti, SkolskaGodina skolskaGodina) {
		IspitniRok ir = new IspitniRok(datumPocetka, datumZavrsetka, null, skolskaGodina);
		return ispitniRokRepo.save(ir);
	}

	public List<IspitniRok> getAll() {
		
		Iterable<IspitniRok> iter = ispitniRokRepo.findAll();
		List<IspitniRok> rez = new ArrayList<IspitniRok>();
		iter.forEach(rez::add);
		return rez;
	}

}
