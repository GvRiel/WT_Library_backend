package nl.workingtalentapp.library.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Boek {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	int book_id;
	String isbn;
	String title;
	boolean available;
	int n_o_copies;
}
