package studsluzba.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.Zvanje;
import studsluzba.repositories.ZvanjeRepository;

@Service
public class ZvanjaService {
	
	@Autowired
	ZvanjeRepository zvanjeRepo;
	
	public Zvanje saveZvanje(Zvanje z) {
		return zvanjeRepo.save(z);
	}
	
	public List<Zvanje> getZvanja() {
		Iterable<Zvanje> iter = zvanjeRepo.findAll();
		List<Zvanje> rez = new ArrayList<Zvanje>();		
		iter.forEach(rez::add);
		return rez;		
	}
	

//	public void deleteZvanje(Zvanje z) {
//		zvanjeRepo.delete(z);
//	}

}
