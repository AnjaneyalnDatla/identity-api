package com.srkr.identity.domain.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class DepartmentTest {

	@Test
	public void testDepartment() {

		Department department = new Department(new String("Civil engineering"), 
				new String("deals with the design, construction, and maintenance of the physical and naturally built environment"));
		assertEquals("Civil engineering", department.name());
		assertEquals("deals with the design, construction, and maintenance of the physical and naturally built environment", department.description());
		assertNotNull(department);
		
		

	}

}
