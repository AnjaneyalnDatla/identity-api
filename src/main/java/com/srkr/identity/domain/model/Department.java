package com.srkr.identity.domain.model;

import java.io.Serializable;
import java.util.Set;

public class Department extends AssertionConcern implements Serializable {

	private static final long serialVersionUID = -8570635909657967523L;

	private String name;
	private String description;
	private Set<Lab> labs;

	public Department(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Department(String name, String description, Set<Lab> labs) {
		super();
		this.name = name;
		this.description = description;
		this.checkLabs(labs);
		this.labs = labs;
	}

	private void checkLabs(Set<Lab> labs) {
		this.assertCollectionNotEmpty(labs, "Labs cannot be empty");
	}

	public String name() {
		return this.name;
	}

	public String description() {
		return this.description;
	}

	public Set<Lab> labs() {
		return this.labs;
	}

}
