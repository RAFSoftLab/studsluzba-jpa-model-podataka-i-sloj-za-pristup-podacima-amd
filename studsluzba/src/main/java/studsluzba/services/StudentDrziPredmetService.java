package studsluzba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.Predmet;
import studsluzba.model.StudIndex;
import studsluzba.model.Student;
import studsluzba.model.StudentDrziPredmet;
import studsluzba.repositories.StudentDrziPredmetRepository;

@Service
public class StudentDrziPredmetService {

	@Autowired
	StudentDrziPredmetRepository sdpRepo;
	
	
	public StudentDrziPredmet save(StudentDrziPredmet sdp) {
		return sdpRepo.save(sdp);
	}
	
	public List<Predmet> findPredmetiByStudent(StudIndex s) {
		return sdpRepo.findPredmetByStudent(s);
	}
}
