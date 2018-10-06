package com.srkr.identity.domain.model;

import java.io.Serializable;

public class ZipCode extends AssertionConcern implements Serializable {

	private static final long serialVersionUID = -8708752614022217292L;
	private final String digits;

	public ZipCode() {
		super();
		this.digits = "00000";
	}

	public ZipCode(String digits) {
		super();
		checkDigits(digits);
		this.digits = digits;
	}

	public String digits() {
		return digits;
	}

	private void checkDigits(String digits) {
		this.assertRegexTrue(digits, "^[0-9]*$", "Zip code should only contain numbers");
		this.assertArgumentLength(digits, 0, 10, "Zip code should not contain more than 10 digits");
	}

	public static ZipCode emptyDefault() {
		return new ZipCode("00000");
	}

}
