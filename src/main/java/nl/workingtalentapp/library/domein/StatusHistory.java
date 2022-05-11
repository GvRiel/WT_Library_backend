package nl.workingtalentapp.library.domein;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StatusHistory implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	// Foreign key naar exemplaar database
	private long copy_id;
	
	// Foreign key naar user database
	private long user_id;
	
	@ManyToOne
	private Boek book;
//	private Copy copy;
	
	
	@ManyToOne
	private User user;
	
	private boolean admin_modif;
	private LocalDateTime timestamp;
	private String status;
	
	public StatusHistory() {}
	
	public StatusHistory(Long id, Long copy_id, Long user_id, Boolean admin_modif, LocalDateTime timestamp, String status) {
		this.id = id;
		this.copy_id = copy_id;
		this.user_id = user_id;
		this.admin_modif = admin_modif;
		this.timestamp = timestamp;
		this.status = status;
	}	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCopy_id() {
		return copy_id;
	}
	public void setCopy_id(long copy_id) {
		this.copy_id = copy_id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public boolean isAdmin_modif() {
		return admin_modif;
	}
	public void setAdmin_modif(boolean admin_modif) {
		this.admin_modif = admin_modif;
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
				", copy_id='" + copy_id + '\'' +
				", user_id='" + user_id + '\'' +
				", admin_modif='" + admin_modif + '\'' +
				", timestamp=" + timestamp +
				", status='" + status + '\'' +
				'}';
	}

}
