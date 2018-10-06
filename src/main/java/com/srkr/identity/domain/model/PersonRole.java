package com.srkr.identity.domain.model;

import java.io.Serializable;

public class PersonRole extends AssertionConcern implements Serializable {

	private static final long serialVersionUID = 968111752201932129L;
	private String name;
	private String description;

	public PersonRole(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String name() {
		return this.name;
	}

	public String description() {
		return this.description;
	}
}
