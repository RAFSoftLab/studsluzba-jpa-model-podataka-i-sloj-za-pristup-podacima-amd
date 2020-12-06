package studsluzba.services;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import studsluzba.model.Studprogram;
import studsluzba.model.VrstaStudija;
import studsluzba.repositories.StudProgramRepository;
import studsluzba.repositories.VrstaStudijaRepository;

@Service
public class StudProgramService {

	@Autowired
	StudProgramRepository studProgramRepo;
	@Autowired
	VrstaStudijaRepository vsRepo;

	public Studprogram saveStudProgram(String naziv, String skraceniNaziv, String zvanje, Year godina, int trajanje, VrstaStudija vs) {
		Studprogram sp = new Studprogram();
		sp.setNaziv(naziv);
		sp.setSkraceniNaziv(skraceniNaziv);
		sp.setNazivZvanja(zvanje);
		sp.setGodinaAkreditovanja(godina);
		sp.setSemestriTrajanje(trajanje);
		sp.setVrstaStudija(vs);
		return studProgramRepo.save(sp);
	}

	public List<Studprogram> getAllPrograms() {
		Iterable<Studprogram> iter = studProgramRepo.findAll();
		List<Studprogram> rez = new ArrayList<Studprogram>();
		iter.forEach(rez::add);
		return rez;
	}
	
	public List<VrstaStudija> getVrsteStudija() {
		Iterable<VrstaStudija> iter = vsRepo.findAll();
		List<VrstaStudija> rez = new ArrayList<VrstaStudija>();
		iter.forEach(rez::add);
		return rez;
	}
}
