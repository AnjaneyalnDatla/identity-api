package com.srkr.identity.domain.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AddressTest {

	@Test
	public void testAddress() {
		Address address = new Address(new String("Officers Colony"), new String("city"), State.ANDHRA_PRADESH,
				new ZipCode(), new String("Near Biryani Point"), Country.INDIA);
		assertNotNull(address);
		assertEquals("Officers Colony", address.streetAddress());
		assertEquals("city", address.city());
		assertEquals(State.ANDHRA_PRADESH, address.state());
		assertEquals("00000", address.zipCode());
	}
}
