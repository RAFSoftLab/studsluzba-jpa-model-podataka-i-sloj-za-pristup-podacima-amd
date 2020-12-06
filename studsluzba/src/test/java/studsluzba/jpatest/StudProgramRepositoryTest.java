package studsluzba.jpatest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import studsluzba.model.Predmet;
import studsluzba.model.Studprogram;
import studsluzba.repositories.PredmetRepository;
import studsluzba.repositories.StudProgramRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudProgramRepositoryTest {

	@Autowired
	StudProgramRepository studProgramRepo;

	@Autowired
	PredmetRepository predmetRepo;

	@Test
	public void saveStudentTest() throws Exception {
		/*Studprogram sp = new Studprogram();
		sp.setNaziv("Racunarske nauke");
		sp.setSkraceniNaziv("RN");
		studProgramRepo.save(sp);

		Predmet p = new Predmet();
		p.setNaziv("Upravljanje informacijama");
		p.setSifra("888");
		p.setStudProgram(sp);
		predmetRepo.save(p);

		Predmet p1 = new Predmet();
		p1.setNaziv("Softverske komponente");
		p1.setSifra("882");
		p1.setStudProgram(sp);
		predmetRepo.save(p1);

		Studprogram sp1 = studProgramRepo.getStudprogramWithPredmeti(sp.getIdstudProgram());
		System.out.println(sp1.getPredmeti().size());
		for (Predmet pr : sp1.getPredmeti()) {
			System.out.println(pr.getNaziv());
		}
*/
	}

}
