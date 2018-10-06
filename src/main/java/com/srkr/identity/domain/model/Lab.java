package com.srkr.identity.domain.model;

import java.io.Serializable;

public class Lab extends AssertionConcern implements Serializable{
	
	private static final long serialVersionUID = 5961668550427704053L;
	private String name;
	private String description;
	
	public Lab(String name,String description) {
		super();
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
