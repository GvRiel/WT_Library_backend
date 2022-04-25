package nl.workingtalentapp.library.persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingtalentapp.library.domein.Category;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository cr;
	
	public void proberen() {
		Category cat = new Category();
		cat.setCat_name("Java");
		cr.save(cat);
	}	
	
}
