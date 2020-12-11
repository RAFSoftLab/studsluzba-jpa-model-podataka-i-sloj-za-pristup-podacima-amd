package studsluzba.jpatest;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import studsluzba.model.ObnovaGodine;
import studsluzba.model.StudIndex;
import studsluzba.model.TokStudija;
import studsluzba.model.UpisGodine;
import studsluzba.repositories.StudIndexRepository;
import studsluzba.repositories.TokStudijaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TokStudijaRepositoryTest {
//
//	@Autowired
//	TokStudijaRepository tokStudijaRepo;
//
//	@Autowired
//	StudIndexRepository indeksRepo;
//
//	@Test
//	public void saveStudentTest() throws Exception {
//
//		StudIndex si = new StudIndex(45, 2019);
//		indeksRepo.save(si);
//
//		ObnovaGodine og = new ObnovaGodine();
//		og.setDatum(new Date(2018, 9, 22));
//		og.setGodina(2);
//		// og.setIndeks(si);
//
//		UpisGodine ug = new UpisGodine();
//		ug.setDatum(new Date(2019, 9, 25));
//		ug.setGodina(3);
//		// ug.setIndeks(si);
//
//		//tokStudijaRepo.save(ug);
//		//tokStudijaRepo.save(og);
//
//		List<TokStudija> tokStudija = tokStudijaRepo.getTokStudijaZaIndex(si);
//		for (TokStudija ts : tokStudija)
//			System.out.println(ts.getDatum() + "  " + ts.getClass().getSimpleName());
//
//	}

}
