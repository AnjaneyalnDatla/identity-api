package com.srkr.identity.domain.model;

import java.io.Serializable;

public class Department extends AssertionConcern implements Serializable {

	private static final long serialVersionUID = -8570635909657967523L;
	private Long id;
	private String name;
	private String description;

	public Department(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Department(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Long id() {
		return this.id;
	}

	public String name() {
		return this.name;
	}

	public String description() {
		return this.description;
	}


}
