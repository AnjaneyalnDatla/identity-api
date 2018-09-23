package com.srkr.identity.domain.model;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Department extends AssertionConcern implements Serializable {

	private static final long serialVersionUID = -8570635909657967523L;

	private String name;

	private String description;

	private Set<Lab> labs;
	
	@JsonCreator
	public Department(@JsonProperty("name") String name, @JsonProperty("description") String description) {
		super();
		this.name = name;
		this.description = description;
	}

	@JsonCreator
	public Department(@JsonProperty("name") String name, @JsonProperty("description") String description,
			@JsonProperty("Labs") Set<Lab> labs) {
		super();
		this.name = name;
		this.description = description;
		this.checkLabs(labs);
		this.labs = labs;
	}
	
	private void checkLabs(Set<Lab> labs) {
		this.assertCollectionNotEmpty(labs, "Labs cannot be empty");
	}
	
	@JsonGetter
	public String name() {
		return this.name;
	}
	
	@JsonGetter
	public String description() {
		return this.description;
	}
	
	@JsonGetter
	public Set<Lab> labs() {
		return this.labs;
	}

}
