package studsluzba.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.DrziPredmet;
import studsluzba.model.Nastavnik;
import studsluzba.model.NastavnikZvanja;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.SrednjaSkola;
import studsluzba.model.Zvanje;
import studsluzba.repositories.DrziPredmetRepository;
import studsluzba.repositories.NastavnikRepository;
import studsluzba.repositories.NastavnikZvanjaRepository;
import studsluzba.repositories.ZvanjeRepository;

@Service
public class NastavnikService {
	
	@Autowired
	NastavnikRepository nastavnikRepo;
	
	public Nastavnik saveNastavnik(Nastavnik n) {
		return nastavnikRepo.save(n);
	}
	
	public void delete(Nastavnik n) {
		nastavnikRepo.delete(n);
	}
	
	public List<Nastavnik> findAll() {
		Iterable<Nastavnik> iter = nastavnikRepo.findAll();
		List<Nastavnik> rez = new ArrayList<Nastavnik>();
		iter.forEach(rez::add);
		return rez;
	}
	
	public List<Nastavnik> findNastavnici(String ime, String prezime, String srednje, String obrazovanje, String email) {
		return nastavnikRepo.findAllByParams(ime, prezime, srednje, obrazovanje, email);
	}
	
}
