package com.srkr.identity.domain.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Credentials extends AssertionConcern implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userName;

	private String password;

	@JsonCreator
	public Credentials(@JsonProperty("userName") String username, @JsonProperty("password") String password) {
		super();
		checkUserName(username);
		this.userName = username;
		checkPassword(password);
		this.password = password;
	}


	@JsonGetter
	public String userName() {
		return this.userName;
	}

	
	@JsonGetter("password")
	public String password() {
		return this.password;
	}

	private void checkPassword(String password) {
		this.assertRegexTrue(password, "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
				"Contains atleast one digit, Contains at least one lower alpha char and one upper alpha char,Contains at least one char within a set of special chars,Does not contain space,length at least 8 chars");
	}
	
	private void checkUserName(String userName) {
		this.assertRegexTrue(userName, "^[a-zA-Z0-9._-]{3,}$", "Length >=3,Valid characters: a-z, A-Z, 0-9, points, dashes and underscores");
		
	}

}
