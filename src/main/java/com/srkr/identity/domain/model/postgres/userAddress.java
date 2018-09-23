package com.srkr.identity.domain.model.postgres;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="UserAddress")
public class userAddress {
	
	/*This class is probably not needed */
	
	private String personID;
	
	private String addressID;

	public String getPersonID() {
		return personID;
	}

	public void setPersonID(String personID) {
		this.personID = personID;
	}

	public String getAddressID() {
		return addressID;
	}

	public void setAddressID(String addressID) {
		this.addressID = addressID;
	}
	
	

}
