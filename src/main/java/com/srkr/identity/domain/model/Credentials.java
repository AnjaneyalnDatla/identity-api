package com.srkr.identity.domain.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Credentials extends AssertionConcern implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String userName;
	
	private String password;

	@JsonCreator
	public Credentials(@JsonProperty("userName") String username, @JsonProperty("password") String password) {
		super();
		this.userName = username;
		this.password = password;
	}
	
	@JsonGetter("userName")
	public String userName() {
		return this.userName;
	}
	
	@JsonGetter("password")
	public String password() {
		return this.password;
	}
	
	
}
