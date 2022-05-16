package nl.workingtalentapp.library.domein;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class StatusHistory implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
		
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="exemplaar_id", referencedColumnName = "id")
	private Exemplaar exemplaar;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id", referencedColumnName = "id")
	private User user;
	
	private boolean admin_modif;
	private boolean active;
	private String shCode;
	
	@CreationTimestamp
	private LocalDateTime timestamp;
	
	private String status;
	
	public StatusHistory() {}
	
	public StatusHistory(Boolean admin_modif, Boolean active, String status) {
		this.admin_modif = admin_modif;
		this.active = active;
		this.status = status;
	}	
	
	public Exemplaar getExemplaar() {
		return exemplaar;
	}

	public void assignExemplaar(Exemplaar exemplaar) {
		this.exemplaar = exemplaar;
	}

	public User getUser() {
		return user;
	}

	public void assignUser(User user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
//	public long getCopy_id() {
//		return copy_id;
//	}
//	public void setCopy_id(long copy_id) {
//		this.copy_id = copy_id;
//	}
//	public long getUser_id() {
//		return user_id;
//	}
//	public void setUser_id(long user_id) {
//		this.user_id = user_id;
//	}
	
	public boolean isAdmin_modif() {
		return admin_modif;
	}
	public void setAdmin_modif(boolean admin_modif) {
		this.admin_modif = admin_modif;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getShCode() {
		return shCode;
	}

	public void setShCode(String shCode) {
		this.shCode = shCode;
	}

	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "StatusHistory{" +
				"id=" + id +
				", admin_modif='" + admin_modif + '\'' +
				", timestamp=" + timestamp +
				", status='" + status + '\'' +
				'}';
	}
	
}

