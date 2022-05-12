package nl.workingtalentapp.library.repository;
import nl.workingtalentapp.library.domein.Category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CategoryRepository  extends CrudRepository<Category, Long> {
	
}
