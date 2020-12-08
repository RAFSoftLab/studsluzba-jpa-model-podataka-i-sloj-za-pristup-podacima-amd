package studsluzba.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.VrstaStudija;
import studsluzba.repositories.VrstaStudijaRepository;

@Service
public class VrstaStudijaService {

	@Autowired
	VrstaStudijaRepository vsRepo;
	
	public VrstaStudija save(VrstaStudija vs) {
		return vsRepo.save(vs);
	}
	
	public List<VrstaStudija> getVrsteStudija() {
		Iterable<VrstaStudija> iter = vsRepo.findAll();
		List<VrstaStudija> rez = new ArrayList<VrstaStudija>();
		iter.forEach(rez::add);
		return rez;
	}
}
