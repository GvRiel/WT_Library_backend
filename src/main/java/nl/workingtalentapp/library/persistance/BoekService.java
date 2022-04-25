package nl.workingtalentapp.library.persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingtalentapp.library.domein.Boek;

@Service
public class BoekService {
	@Autowired
	BoekRepository trs;
	
	
	public void proberen() {
		Boek tr = new Boek();
		tr.setTitle("De Naam");
		trs.save(tr);
	}

	public Iterable<Boek> boeken() {
		// TODO Auto-generated method stu
		return trs.findAll();
	}
	
}
