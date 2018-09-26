package com.srkr.identity.domain.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class DepartmentTest {

	@Test
	public void testDepartment() {

		Set<Lab> labs = new HashSet<>();
		Lab lab = new Lab(new String("LabName"), new String("LabDescription"));
		labs.add(lab);
		Department department = new Department(new String("Civil engineering"), 
				new String("deals with the design, construction, and maintenance of the physical and naturally built environment"),labs);
		assertEquals("Civil engineering", department.name());
		assertEquals("deals with the design, construction, and maintenance of the physical and naturally built environment", department.description());
		assertNotNull(department);
		
		

	}

}
