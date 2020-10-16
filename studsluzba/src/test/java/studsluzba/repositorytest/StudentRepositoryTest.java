package studsluzba.repositorytest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import studsluzba.model.Student;
import studsluzba.repositories.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {
	
	@Autowired //spring pravi sam instancu repositorija -------------------------
	StudentRepository studentRepo;
	
	@Test
	public void saveStudentTest() {
		
		Student s = new Student();
		s.setIme("Mika");
		s.setPrezime("Mikic");
		s.setSrednjeIme("Mikota");
		s.setGodinaUpisa(2019);
		studentRepo.save(s);
			
	}
}
