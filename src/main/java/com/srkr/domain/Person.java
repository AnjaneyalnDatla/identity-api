package com.srkr.domain;

import java.util.Date;

public class Person {

	private String id;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String cellPhone;
	
	private String homePhone;
	
	private String officePhone;
	
	private String emailAddress;
	
	private int organizationID;
	
	private int departmentID;
	
	private String designation;
	
	private int personRole;
	
	//private ValueHolderInterface personRole;
	/* import eclipse persistance jar ? or can this be done any other way ? */
	
	private int supervisor;
	
	private Date dateUpdated;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public int getOrganizationID() {
		return organizationID;
	}

	public void setOrganizationID(int organizationID) {
		this.organizationID = organizationID;
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getPersonRole() {
		return personRole;
	}

	public void setPersonRole(int personRole) {
		this.personRole = personRole;
	}

	public int getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(int supervisor) {
		this.supervisor = supervisor;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	
}
