package com.srkr.identity.domain.model.postgres;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="Person")
public class Person {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="middlename")
	private String middleName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="cellphone")
	private Long cellPhone;
	
	@Column(name="homephone")
	private Long homePhone;
	
	@Column(name="officephone")
	private Long officePhone;
	
	@Column(name="emailaddress")
	private String emailAddress;
	
	@ManyToOne
	@JoinColumn(name="id")	
	private Organization organization;
	
	@ManyToOne
	@JoinColumn(name="id")	
	private Department departmentID;
	
	@Column(name="id")
	private String designation;
	
	@ManyToOne
	@JoinColumn(name="id")	
	private PersonRole personRole;
	
	// personRole many to one or not ? 
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="supervisor")
	private Person supervisor;
	//Do we want to rename this column to supervisor_id instead ?
	
	@Column(name="dateUpdated")
	private Date dateUpdated;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="USERADDRESS",
				joinColumns= {@JoinColumn(name="id")},
				inverseJoinColumns={@JoinColumn(name="id")})
	private Set<Address> addresses = new HashSet<Address>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Long getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(Long cellPhone) {
		this.cellPhone = cellPhone;
	}

	public Long getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(Long homePhone) {
		this.homePhone = homePhone;
	}

	public Long getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(Long officePhone) {
		this.officePhone = officePhone;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Department getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(Department departmentID) {
		this.departmentID = departmentID;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public PersonRole getPersonRole() {
		return personRole;
	}

	public void setPersonRole(PersonRole personRole) {
		this.personRole = personRole;
	}

	public Person getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Person supervisor) {
		this.supervisor = supervisor;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}	
	
}
