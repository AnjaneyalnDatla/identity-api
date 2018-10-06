package com.srkr.identity.domain.model;

import java.io.Serializable;

public class Organization extends AssertionConcern implements Serializable{

	private static final long serialVersionUID = 4808177055697881479L;
	private String name;
	private String description;
	private Address address;

	public Organization(String name,String description,Address address)
	{
		this.name = name;
		this.description = description;
		this.address = address;
	}
	
	public String name() {
		return this.name;
	}
	
	public String description() {
		return this.description;
	}

	public Address address() {
		return this.address;
	}
	

}
