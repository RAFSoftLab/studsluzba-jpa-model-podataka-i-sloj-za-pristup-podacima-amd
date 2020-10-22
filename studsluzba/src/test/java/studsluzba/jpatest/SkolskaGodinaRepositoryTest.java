package studsluzba.jpatest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.repositories.PredmetRepository;
import studsluzba.repositories.SkolskaGodinaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SkolskaGodinaRepositoryTest {
	
	@Autowired
	SkolskaGodinaRepository skolskaGodinaRepo;
	
	@Test
	public void saveSkolskaGodinaTest() throws Exception {
		
		SkolskaGodina sg = new SkolskaGodina();
		sg.setAktivna(true);
		sg.setGodina("2020-2021");
		
		skolskaGodinaRepo.save(sg);	
	}

}
