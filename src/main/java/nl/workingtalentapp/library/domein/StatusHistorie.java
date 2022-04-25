package nl.workingtalentapp.library.domein;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StatusHistorie {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)

long id;

int status_id;

int copy_id;

String title;

boolean admin_modif;

LocalDateTime timestamp;

int user_id;

String status_before;

String status_after;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public int getStatus_id() {
	return status_id;
}

public void setStatus_id(int status_id) {
	this.status_id = status_id;
}

public int getCopy_id() {
	return copy_id;
}

public void setCopy_id(int copy_id) {
	this.copy_id = copy_id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
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

public int getUser_id() {
	return user_id;
}

public void setUser_id(int user_id) {
	this.user_id = user_id;
}

public String getStatus_before() {
	return status_before;
}

public void setStatus_before(String status_before) {
	this.status_before = status_before;
}

public String getStatus_after() {
	return status_after;
}

public void setStatus_after(String status_after) {
	this.status_after = status_after;
}



}
