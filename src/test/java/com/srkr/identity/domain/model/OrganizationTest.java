package com.srkr.identity.domain.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class OrganizationTest {

	@Test
	public void testOrganization() {
		
		Organization organization = new Organization(new String("SRKR"),new String("Org Description"), Address.emptyDefault(),null);
		assertEquals("SRKR", organization.name());
		assertEquals("Org Description", organization.description());
		assertNotNull(organization.address());
		
	}
}
