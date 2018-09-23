package com.srkr.identity.domain.model;

import java.io.Serializable;
import java.util.Set;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person extends AssertionConcern implements Serializable {

	private static final long serialVersionUID = 7397365805727122078L;
	private static final Integer MAX_NAME_LENGTH = 32;
	public static final int MAX_EMAIL_LENGTH = 100;

	private String firstName;
	private String middleName;
	private String lastName;
	private Long cellPhone;
	private Long homePhone;
	private Long officePhone;
	private String emailAddress;
	private Organization organization;
	private Department department;
	private String designation;
	private PersonRole personRole;
	private Person supervisor;
	private Set<Address> addresses;

	@JsonCreator
	public Person() {

	}

	@JsonCreator
	public Person(@JsonProperty("firstName") String firstName, @JsonProperty("middleName") String middleName,
			@JsonProperty("lastName") String lastName, @JsonProperty("cellPhone") Long cellPhone,
			@JsonProperty("homePhone") Long homePhone, @JsonProperty("officePhone") Long officePhone,
			@JsonProperty("emailAddress") String emailAddress, @JsonProperty("Organisation") Organization organization,
			@JsonProperty("Department") Department department, @JsonProperty("designation") String designation,
			@JsonProperty("personRole") PersonRole personRole, @JsonProperty("superVisior") Person supervisior,
			@JsonProperty("address") Set<Address> addresses) {
		super();
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

	@JsonGetter("firstName")
	public String firstName() {
		return this.firstName;
	}

	@JsonGetter("lastName")
	public String lastName() {
		return this.lastName;
	}

	@JsonGetter("middleName")
	public String middleName() {
		return this.middleName;
	}

	@JsonGetter("cellPhone")
	public Long cellPhone() {
		return this.cellPhone;
	}

	@JsonGetter("homePhone")
	public Long homePhone() {
		return this.homePhone;
	}

	@JsonGetter("officePhone")
	public Long OfficePhone() {
		return this.officePhone;
	}

	@JsonGetter("emailAddress")
	public String emailAddress() {
		return this.emailAddress;
	}

	@JsonGetter("organisation")
	public Organization organization() {
		return this.organization;
	}

	@JsonGetter("department")
	public Department department() {
		return this.department;
	}

	@JsonGetter("designation")
	public String designation() {
		return this.designation;
	}

	@JsonGetter("personRole")
	public PersonRole personRole() {
		return this.personRole;
	}

	@JsonGetter("supervisior")
	public Person superVisior() {
		return this.supervisor;
	}

	@JsonGetter("addresses")
	public Set<Address> addresses() {
		return this.addresses;
	}

	private void checkName(String aName, String aMsg) {
		this.assertArgumentNotEmpty(aName, aMsg + " is required.");
		this.assertArgumentLength(aName, 1, MAX_NAME_LENGTH.intValue(),
				"Name must be" + MAX_NAME_LENGTH + " characters or less.");
	}

	private void checkPhone(Long aNumber, String phoneType) {
		if (aNumber != null) {
			String digits = aNumber + "";
			this.assertRegexTrue(digits, "[0-9]*$", phoneType + " phone should only contain numbers");
			this.assertArgumentLength(digits, 5, 5, phoneType + " phone should only contain 10 digits");
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
