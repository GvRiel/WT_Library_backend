package nl.workingtalentapp.library.domein;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Exemplaar {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long id; //each defined item here is a column
	
	private String copyID;
	private String bookCode;
	private String staat;
	private boolean availability;


	@ManyToOne()
	@JoinColumn(name = "boekId", referencedColumnName = "id")
	private Boek boek;



	@JsonIgnore
	@OneToMany(mappedBy ="exemplaar")
	private Set<StatusHistory> statusHistories= new HashSet<>();

	public Exemplaar() {}


	public Exemplaar(String staat, boolean availability, Boek boek) {
		this.staat = staat;
		this.availability = availability;
		this.boek = boek;
	}
	public Boek getBoek() {
		return boek;
	}

	public void setBoek(Boek boek) {
		this.boek = boek;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCopyID() {
		return copyID;
	}
	public void setCopyID(String copyID) {
		this.copyID = copyID;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookID(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getStaat() {
		return staat;
	}
	public void setStaat(String staat) {
		this.staat = staat;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public Set<StatusHistory> getStatusHistories() {
		return statusHistories;
	}
	
	
}
