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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public int getN_o_copies() {
		return n_o_copies;
	}
	public void setN_o_copies(int n_o_copies) {
		this.n_o_copies = n_o_copies;
	}
	
	
}
