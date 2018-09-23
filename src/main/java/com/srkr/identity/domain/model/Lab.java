package com.srkr.identity.domain.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Lab extends AssertionConcern implements Serializable{
	
	private static final long serialVersionUID = 5961668550427704053L;
	private String name;
	private String description;
	
	@JsonCreator
	public Lab(@JsonProperty("name")String name,@JsonProperty("description")String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	@JsonGetter
	public String name() {
		return this.name;
	}

	@JsonGetter
	public String description() {
		return this.description;
	}
}
