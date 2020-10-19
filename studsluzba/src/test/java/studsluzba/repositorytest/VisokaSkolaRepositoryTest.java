package studsluzba.repositorytest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import studsluzba.model.SrednjaSkola;
import studsluzba.model.VisokaSkola;
import studsluzba.repositories.SrednjeSkoleRepository;
import studsluzba.repositories.VisokaSkolaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VisokaSkolaRepositoryTest {

	
	@Autowired //spring pravi sam instancu repositorija -------------------------
	VisokaSkolaRepository visokaRepo;
	
	@Test
	public void saveVisokaSkolaTest() {
		
		VisokaSkola vs = new VisokaSkola();
		vs.setImeUstanove("Fakultet dramskih umetnosti");
		vs.setMestoUstanove("Beograd");
		vs.setSmer("Gluma");
		visokaRepo.save(vs);
			
	}
}
