package nl.workingtalentapp.library.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exemplaar {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long id; //each defined item here is a column
	
	private float copyID;
	private String state;
	private boolean availability;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public float getCopyID() {
		return copyID;
	}
	public void setCopyID(float copyID) {
		this.copyID = copyID;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
}
