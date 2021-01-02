package studsluzba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.PrijavaIspita;
import studsluzba.repositories.PrijavaIspitarepository;

@Service
public class PrijavaIspitaService {

	@Autowired
	PrijavaIspitarepository pirepo;
	
	public PrijavaIspita save(PrijavaIspita pi) {
		return pirepo.save(pi);
	}
	
}
