package studsluzba.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.Ispit;
import studsluzba.model.IspitniRok;
import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.StudIndex;
import studsluzba.model.Student;
import studsluzba.repositories.IspitRepository;

@Service
public class IspitService {

	@Autowired
	IspitRepository ispitRepo;

	public Ispit saveIspit(Ispit i) {
		return ispitRepo.save(i);
	}
	
	public List<Student> findStudentiByIspit(Ispit i) {
		return ispitRepo.findPrijavljeni(i);
	}
	
	public List<Object[]> findfindRezultatiIspitaPoIspitu(Ispit i) {
		return ispitRepo.findRezultatiIspitaPoIspitu(i);
	}
	
	public List<Ispit> findAll() {
		Iterable<Ispit> iter = ispitRepo.findAll();
		List<Ispit> rez = new ArrayList<Ispit>();
		iter.forEach(rez::add);
		return rez;
	}
}
