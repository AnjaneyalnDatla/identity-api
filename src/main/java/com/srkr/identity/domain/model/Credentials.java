package com.srkr.identity.domain.model;

import java.io.Serializable;
import java.util.regex.Pattern;

public class Credentials extends AssertionConcern implements Serializable {
	private static final int MAX_EMAIL_LENGTH = 100;
	private static final long serialVersionUID = 1L;

	private Long id;
	private String userName;
	private String password;
	private Person person;

	public Credentials() {

	}

	public Credentials(String username, String password, Person person) {
		super();
		checkUserName(username);
		this.userName = username;
		checkPassword(password);
		this.password = password;
		this.person = person;
	}

	public Credentials(Long id, String username, String password, Person person) {
		super();
		checkUserName(username);
		this.id = id;
		this.userName = username;
		checkPassword(password);
		this.password = password;
		this.person = person;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		if (null != userName)
			this.userName = userName.toUpperCase();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	private void checkPassword(String password) {
		this.assertRegexTrue(password, "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}$",
				"Contains atleast one digit, Contains at least one lower alpha char and one upper alpha char,Contains at least one char within a set of special chars,Does not contain space,length at least 8 chars");
	}

	private void checkUserName(String userName) {
		this.assertArgumentNotEmpty(userName, "Email address is required.");
		this.assertArgumentLength(userName, 1, MAX_EMAIL_LENGTH, "Email address must be 100 characters or less.");
		this.assertArgumentTrue(Pattern.matches(
				"((?!\\_)([a-zA-Z0-9][\\_\\-\\.]{0,1})){1,63}(?<!\\.)(?<!\\_)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]{1,63}\\.)+))([a-zA-Z]{2,6}|[0-9]{1,3})(\\]?)",
				userName), "Email address format is invalid.");
	}

}
