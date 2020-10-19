package studsluzba.repositorytest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import studsluzba.model.StudIndex;
import studsluzba.model.Student;
import studsluzba.repositories.StudIndexRepository;
import studsluzba.repositories.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudIndexRepositoryTest {
	@Autowired //spring pravi sam instancu repositorija -------------------------
	StudIndexRepository studIndexRepo;
	
	@Test
	public void saveStudentTest() {
		
		StudIndex index = new StudIndex();
		index.setDatumaktivnosti("01.10.2019");
		index.setBroj(100);
		index.setAktivan(true);
		index.setGodinaUpisa(2019);
		
		studIndexRepo.save(index);
			
	}
}
