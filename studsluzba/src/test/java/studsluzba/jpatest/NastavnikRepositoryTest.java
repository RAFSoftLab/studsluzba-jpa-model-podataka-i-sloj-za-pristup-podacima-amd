package studsluzba.jpatest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;
import studsluzba.model.Studprogram;
import studsluzba.repositories.NastavnikRepository;
import studsluzba.repositories.PredmetRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NastavnikRepositoryTest {
	
	@Autowired
	NastavnikRepository nastavnikRepo;
	
	@Test
	public void savePredmetTest() throws Exception {
		
		Nastavnik n = new Nastavnik();
		n.setEmail("adacic9219rn@raf.rs");
		n.setIme("Aleksa");
		n.setPrezime("Dacic");
		n.setObrazovanje("Srednja skola");
		n.setSrednjeIme("Zhilijen");
		n.setZvanja(null);
		
		nastavnikRepo.save(n);
		
	}
	

}
