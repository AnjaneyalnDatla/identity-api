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
	
	@JsonCreator
	public Address(@JsonProperty("streetAddress") String streetAddress, @JsonProperty("city") String city, 
			@JsonProperty("state") State state, @JsonProperty("zipCode") ZipCode zipCode) {
		super();
		this.checkstreetAddress(streetAddress);
		this.streetAddress = streetAddress;
		this.zipCode = zipCode;
		this.city = city;
		this.state = state;
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

	private void checkstreetAddress(String astreetAddress) {
		this.assertArgumentNotEmpty(astreetAddress, "a street name is required.");
		this.assertArgumentLength(astreetAddress, 1, MAX_STREET_ADDRESS_LENGTH.intValue(),
				"Street Address must be" + MAX_STREET_ADDRESS_LENGTH + " characters or less.");
	}

	@Override
	public String toString() {
		return "Address [streetAddress=" + streetAddress+", city=" + city + ", state=" + state + ", zipCode=" + zipCode.digits() + "]";
	}

	public static Address emptyDefault() {
		return new Address("default", "default", State.valueOfAbbreviation("AP"), ZipCode.emptyDefault());
	}
	
	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		return this.streetAddress().equals(((Address)object).streetAddress()) && this.city().equals(((Address)object).city()) 
				&& this.state().equals(((Address)object).state()) && this.zipCode().digits().equals(((Address)object).zipCode().digits());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((zipCode == null) ? 0 : zipCode.digits().hashCode());
		return result;
	}
}