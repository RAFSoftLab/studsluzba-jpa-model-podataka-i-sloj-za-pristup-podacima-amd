package studsluzba.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.Ispit;
import studsluzba.model.IspitniRok;
import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.Student;
import studsluzba.repositories.IspitRepository;

@Service
public class IspitService {

	@Autowired
	IspitRepository ispitRepo;

	public Ispit saveIspit(LocalDate datumOdrzavanja, String vremePocetka, String vremeZavrsetka, Nastavnik nastavnik,
			Predmet predmet, IspitniRok ir, boolean zakljucen) {

		Ispit i = new Ispit(datumOdrzavanja, vremePocetka, vremeZavrsetka, nastavnik, predmet, ir, zakljucen);

		return ispitRepo.save(i);
	}
	
	public List<Student> findStudentiByIspit(Ispit i) {
		return ispitRepo.findPrijavljeni(i);
	}
	
	public List<Object[]> findfindRezultatiIspitaPoIspitu(Ispit i) {
		return ispitRepo.findRezultatiIspitaPoIspitu(i);
	}
}
