package com.srkr.identity.domain.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Organization extends AssertionConcern implements Serializable{

	private static final long serialVersionUID = 4808177055697881479L;
	private String name;
	private String description;
	private Address address;

	@JsonCreator
	public Organization(@JsonProperty("name")String name,@JsonProperty("description")String description,@JsonProperty("Address")Address address)
	{
		this.name = name;
		this.description = description;
		this.address = address;
	}
	
	
	@JsonGetter("name")
	public String name() {
		return this.name;
	}
	
	@JsonGetter("description")
	public String description() {
		return this.description;
	}
	
	@JsonGetter("address")
	public Address address() {
		return this.address;
	}
	

}
