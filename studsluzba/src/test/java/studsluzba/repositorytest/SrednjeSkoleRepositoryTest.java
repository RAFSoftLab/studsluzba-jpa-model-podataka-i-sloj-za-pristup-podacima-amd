package studsluzba.repositorytest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import studsluzba.model.SrednjaSkola;
import studsluzba.model.Student;
import studsluzba.repositories.SrednjeSkoleRepository;
import studsluzba.repositories.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SrednjeSkoleRepositoryTest {
	
	@Autowired //spring pravi sam instancu repositorija -------------------------
	SrednjeSkoleRepository srednjeRepo;
	
	@Test
	public void saveSrednjaSkolaTest() {
		
		SrednjaSkola sk = new SrednjaSkola();
		sk.setImeSkole("Mileta Micka");
		sk.setMesto("Sombor");
		sk.setVrsta("srednja");
		
		srednjeRepo.save(sk);
			
	}
}
