package com.srkr.identity.domain.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonRole extends AssertionConcern implements Serializable {

	private static final long serialVersionUID = 968111752201932129L;
	private String name;
	private String description;

	@JsonCreator
	public PersonRole(@JsonProperty("name") String name, @JsonProperty("description") String description) {
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
