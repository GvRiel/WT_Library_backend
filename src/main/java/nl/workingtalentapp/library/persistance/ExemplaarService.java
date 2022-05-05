package nl.workingtalentapp.library.persistance;



import java.util.Optional;
import java.util.UUID;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingtalentapp.library.domein.Exemplaar;

@Service
public class ExemplaarService {
	@Autowired
	ExemplaarRepository er;
	
	
	public Exemplaar nieuwExemplaarOpslaan() {
		Exemplaar e = new Exemplaar();
//		e.setState("beschadigd");
//		er.save(e);
		System.out.println("doet hij iets?");
		return er.save(e);
	}
	
	public Iterable<Exemplaar> alleExemplaren(){
		return er.findAll();
	}
	
	public void deleteExemplaar(Long id) {
		er.deleteById(id);
	}
	
	public Exemplaar vindExemplaar(Long id) {
		return er.vindExemplaar(id).
				orElseThrow(() -> new ExemplaarNotFoundException ("Exemplaar not found"));
	}
	


	
	
//	public void exemplaarVerwijderen(long id) {
//		er.deleteById(id);
//	}
//
//	public Exemplaar vindExemplaarByID(long id) {
//		Exemplaar e = er.findById(id).orElseThrow(() -> new ObjectNotFoundException (id, "User by id " + id + " was not found"));
//		return e;
//	}
//	
//	public Iterable<Exemplaar> alleExemplaren() {
//		return er.findAll();
//	}
	

	
	
}
