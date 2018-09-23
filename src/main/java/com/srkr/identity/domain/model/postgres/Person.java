package com.srkr.identity.domain.model.postgres;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="middlename")
	private String middleName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="cellphone")
	private String cellPhone;
	
	@Column(name="homephone")
	private String homePhone;
	
	@Column(name="officephone")
	private String officePhone;
	
	@Column(name="emailaddress")
	private String emailAddress;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="organisation_id",referencedColumnName="id")	
	private Organisation organization;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="department_id",referencedColumnName="id")	
	private Department department;
	
	@Column(name="designation")
	private String designation;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="person_role",referencedColumnName="id")	
	private PersonRole personRole;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="supervisor",referencedColumnName="id")
	private Person supervisor;

	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="PERSON_ADDRESS",
				joinColumns= {@JoinColumn(referencedColumnName="id")},
				inverseJoinColumns={@JoinColumn(name="address_id",referencedColumnName="id")})
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

	public Organisation getOrganization() {
		return organization;
	}

	public void setOrganization(Organisation organization) {
		this.organization = organization;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
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


	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}	
	
}
