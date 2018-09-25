package com.srkr.identity.domain.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class LabTest {
	
	@Test
	public void testLab() {
		Lab lab = new Lab(new String("Computer Programming lab"), new String("CPL description"));
		assertEquals("Computer Programming lab", lab.name());
		assertEquals("CPL description", lab.description());
		assertNotNull(lab);
		assertNotEquals("Computer", lab.name());
	}

}
