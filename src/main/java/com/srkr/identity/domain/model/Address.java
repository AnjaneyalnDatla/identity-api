package com.srkr.identity.domain.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class Address extends AssertionConcern implements Serializable {
	public static final Integer MAX_STREET_ADDRESS_LENGTH = 250;
	private static final long serialVersionUID = 149011875407286550L;

	private String streetAddress;
	private ZipCode zipCode;
	private String city;
	private State state;
	private String landMark;
	private Country country;

	@JsonCreator
	public Address(@JsonProperty("streetAddress") String streetAddress, @JsonProperty("city") String city,
			@JsonProperty("state") State state, @JsonProperty("zipCode") ZipCode zipCode,
			@JsonProperty("landmark") String landMark, @JsonProperty("Country") Country country) {
		super();
		this.checkstreetAddress(streetAddress);
		this.streetAddress = streetAddress;
		this.zipCode = zipCode;
		this.city = city;
		this.state = state;
		this.landMark = landMark;
		this.country = country;
	}

	@JsonGetter("streetAddress")
	public String streetAddress() {
		return streetAddress;
	}

	@JsonGetter("city")
	public String city() {
		return city;
	}

	@JsonGetter("state")
	public State state() {
		return state;
	}

	@JsonGetter("zipCode")
	public ZipCode zipCode() {
		return zipCode;
	}
	
	@JsonGetter("landMark")
	public String landMark() {
		return landMark;
	}
	
	@JsonGetter("Country")
	public Country country() {
		return country;
	}

	private void checkstreetAddress(String astreetAddress) {
		this.assertArgumentNotEmpty(astreetAddress, "a street name is required.");
		this.assertArgumentLength(astreetAddress, 1, MAX_STREET_ADDRESS_LENGTH.intValue(),
				"Street Address must be" + MAX_STREET_ADDRESS_LENGTH + " characters or less.");
	}

	@Override
	public String toString() {
		return "Address [streetAddress=" + streetAddress + ", city=" + city + ", state=" + state + ", zipCode="
				+ zipCode.digits() + ", landMark="+landMark+", country="+country.name()+"]";
	}

	public static Address emptyDefault() {
		return new Address("default", "default", State.valueOfAbbreviation("AP"), ZipCode.emptyDefault(), "default",
				Country.valueOfAbbreviation("IN"));
	}

}