package jpatest;

import java.awt.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import studsluzba.repositories.PredmetRepository;

import studsluzba.model.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PredmetRepositoryTest {

	@Autowired
	PredmetRepository predmetRepo;
	
	@Test
	public void savePredmetTest() throws Exception {
		
		Studprogram sp = new Studprogram();
		sp.setNaziv("Racunarkse Mreze");
		sp.setPredmeti(null);
		sp.setSkraceniNaziv("RM");
		sp.setStudents(null);
		
		Predmet p = new Predmet();
		p.setNaziv("Matematika");
		p.setSifra("2020god");
		p.setStudProgram(sp);
		
		predmetRepo.save(p);
		
	}
	
}
