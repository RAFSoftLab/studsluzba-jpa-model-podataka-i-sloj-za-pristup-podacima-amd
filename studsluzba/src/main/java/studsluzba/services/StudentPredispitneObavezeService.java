package studsluzba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.StudentPredispitneObaveze;
import studsluzba.repositories.StudentPredispitneObavezeRepository;

@Service
public class StudentPredispitneObavezeService {

	@Autowired
	StudentPredispitneObavezeRepository spoRepo;
	
	public StudentPredispitneObaveze save(StudentPredispitneObaveze spo) {
		return spoRepo.save(spo);
	}
	
}
