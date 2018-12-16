package com.srkr.identity.domain.model;

import java.io.Serializable;
import java.util.Set;
import java.util.regex.Pattern;

public class Person extends AssertionConcern implements Serializable {

	private static final long serialVersionUID = 7397365805727122078L;
	private static final Integer MAX_NAME_LENGTH = 32;
	public static final int MAX_EMAIL_LENGTH = 100;

	private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String cellPhone;
	private String homePhone;
	private String officePhone;
	private String emailAddress;
	private Organization organization;
	private Department department;
	private String designation;
	private PersonRole personRole;
	private Person supervisor;
	private Set<Address> addresses;

	public Person(String firstName, String lastName, String cellPhone, String emailAddress, Organization organization,
			Department department, String designation) {
		super();
		checkName(firstName, "First Name");
		this.firstName = firstName;
		checkName(firstName, "Last Name");
		this.lastName = lastName;
		checkPhone(cellPhone, "Cell");
		this.cellPhone = cellPhone;
		checkEmailAddress(emailAddress);
		this.emailAddress = emailAddress;
		this.organization = organization;
		this.department = department;
		this.designation = designation;

	}

	public Person(Long id,String firstName, String middleName, String lastName, String cellPhone, String homePhone,
			String officePhone, String emailAddress, Organization organization, Department department,
			String designation, PersonRole personRole, Person supervisior, Set<Address> addresses) {
		super();
		this.id = id;
		checkName(firstName, "First Name");
		this.firstName = firstName;
		this.middleName = middleName;
		checkName(firstName, "Last Name");
		this.lastName = lastName;
		checkPhone(cellPhone, "Cell");
		this.cellPhone = cellPhone;
		checkPhone(cellPhone, "Office");
		this.officePhone = officePhone;
		checkPhone(cellPhone, "Home");
		this.homePhone = homePhone;
		checkEmailAddress(emailAddress);
		this.emailAddress = emailAddress;
		this.organization = organization;
		this.department = department;
		this.designation = designation;
		this.personRole = personRole;
		this.supervisor = supervisior;
		checkAddress(addresses);
		this.addresses = addresses;
	}
	
	public Long id() {
		return this.id;
	}

	public String firstName() {
		return this.firstName;
	}

	public String lastName() {
		return this.lastName;
	}

	public String middleName() {
		return this.middleName;
	}

	public String cellPhone() {
		return this.cellPhone;
	}

	public String homePhone() {
		return this.homePhone;
	}

	public String OfficePhone() {
		return this.officePhone;
	}

	public String emailAddress() {
		return this.emailAddress;
	}

	public Organization organization() {
		return this.organization;
	}

	public Department department() {
		return this.department;
	}

	public String designation() {
		return this.designation;
	}

	public PersonRole personRole() {
		return this.personRole;
	}

	public Person superVisior() {
		return this.supervisor;
	}

	public Set<Address> addresses() {
		return this.addresses;
	}

	private void checkName(String aName, String aMsg) {
		this.assertArgumentNotEmpty(aName, aMsg + " is required.");
		this.assertArgumentLength(aName, 1, MAX_NAME_LENGTH.intValue(),
				"Name must be" + MAX_NAME_LENGTH + " characters or less.");
	}

	private void checkPhone(String digits, String phoneType) {
		if (digits != null) {
			this.assertRegexTrue(digits, "[0-9]*$", phoneType + " phone should only contain numbers");
			this.assertArgumentLength(digits, 10, 10, phoneType + " phone should only contain 10 digits");
		}
	}

	private void checkEmailAddress(String anAddress) {
		this.assertArgumentNotEmpty(anAddress, "Email address is required.");
		this.assertArgumentLength(anAddress, 1, MAX_EMAIL_LENGTH, "Email address must be 100 characters or less.");
		this.assertArgumentTrue(Pattern.matches(
				"((?!\\_)([a-zA-Z0-9][\\_\\-\\.]{0,1})){1,63}(?<!\\.)(?<!\\_)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]{1,63}\\.)+))([a-zA-Z]{2,6}|[0-9]{1,3})(\\]?)",
				anAddress), "Email address format is invalid.");
	}

	private void checkAddress(Set<Address> addresses) {
		this.assertCollectionNotEmpty(addresses, "Addresses cannot be empty");

	}

}
