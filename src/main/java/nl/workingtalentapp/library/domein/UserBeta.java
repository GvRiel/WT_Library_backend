package nl.workingtalentapp.library.domein;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserBeta implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	long id;

	boolean admin;
	String function;
	String password;
	String name;
	String email;
	String phoneNumber;
	String imageUrl;
	String linkedinURL;
	
	@Column(nullable = false, updatable = false)
	String userID;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getlinkedinURL() {
		return linkedinURL;
	}

	public void setlinkedinURL(String linkedinURL) {
		this.linkedinURL = linkedinURL;
	}
	
	
	
//	@Override
//	public String toString() {
//		return "UserBeta{" +
//				"id=" + id +
//				", name = '" + name + '\'' +
//				", email = " + email + '\'' +
//				'}';
//	}

	

}
