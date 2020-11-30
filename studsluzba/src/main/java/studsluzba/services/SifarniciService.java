package studsluzba.services;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.SrednjaSkola;
import studsluzba.repositories.SrednjeSkoleRepository;

@Service
public class SifarniciService {
	
	@Autowired
	SrednjeSkoleRepository srednjeSkoleRepo;
	
	public List<SrednjaSkola> getSrednjeSkole(){		
		Iterable<SrednjaSkola> iter = srednjeSkoleRepo.findAll();
		List<SrednjaSkola> rez = new ArrayList<SrednjaSkola>();		
		iter.forEach(rez::add);
		return rez;		
	}
	
	public SrednjaSkola saveSrednjaSkola(SrednjaSkola ss) {
		return srednjeSkoleRepo.save(ss);
	}
}
