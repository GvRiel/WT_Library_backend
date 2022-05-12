package nl.workingtalentapp.library.service;



import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import nl.workingtalentapp.library.repository.ExemplaarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingtalentapp.library.domein.Exemplaar;

@Service
public class ExemplaarService {
	@Autowired
    ExemplaarRepository er;
	private static List<Exemplaar> exemplaren = new ArrayList<>();
	private List<Exemplaar> boekExemplaren = new ArrayList<>();
	
	public Exemplaar addExemplaar(Exemplaar exemplaar) {
		exemplaar.setCopyID(UUID.randomUUID().toString());
	    return er.save(exemplaar);
	}
	
	
    public List<Exemplaar> findAllExemplaren() {
        return (List<Exemplaar>) er.findAll();
    }

    public Exemplaar updateExemplaar(Exemplaar exemplaar) {
        return er.save(exemplaar);
    }
    
    public Exemplaar findExemplaarById(long id) {
		Optional<Exemplaar> optionalExemplaar = er.findById(id);
		if (optionalExemplaar.isPresent()) {
			Exemplaar exemplaar = optionalExemplaar.get();
			return exemplaar;
		}
		else {
			return null;
		}
    	
    	//		for(Exemplaar exemplaar:exemplaren) {
//			if(exemplaar.getId() == id) {
//				return exemplaar;
//			}
//		}
//		return null;
	}
    
    public List<Exemplaar> findExemplaarByBookCode(String bookCode) {
    	for(Exemplaar exemplaar:exemplaren) {
			if(exemplaar.getBookCode() == bookCode) {
				boekExemplaren.add(exemplaar);
				return boekExemplaren;
			}
		}
		
		return null;
    }

    public void deleteExemplaar(Long id) {
        er.deleteExemplaarById(id);
    }

}
