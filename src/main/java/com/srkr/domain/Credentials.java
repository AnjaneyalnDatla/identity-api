package com.srkr.domain;

import java.util.Date;

public class Credentials {

	private String id;
	
	private String personID;
	
	private String userName;
	
	private Date isActive;
	
	private Date lastReset;
	
	private Date dateUpdated;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPersonID() {
		return personID;
	}

	public void setPersonID(String personID) {
		this.personID = personID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
