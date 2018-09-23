package com.srkr.identity.domain.model;

import java.io.Serializable;
import java.util.Date;

import com.srkr.identity.domain.model.postgres.Person;

public class Credentials implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Person person;
	
	private String userName;
	
	private String password;
	
	private Date isActive;
	
	private Date lastReset;
	
	private Date dateUpdated;



	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getIsActive() {
		return isActive;
	}

	public void setIsActive(Date isActive) {
		this.isActive = isActive;
	}

	public Date getLastReset() {
		return lastReset;
	}

	public void setLastReset(Date lastReset) {
		this.lastReset = lastReset;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
	
}
