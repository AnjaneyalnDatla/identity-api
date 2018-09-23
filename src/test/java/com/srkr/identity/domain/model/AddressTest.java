package com.srkr.identity.domain.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AddressTest {
	
	@Test
	public void testAddress(){
	
	String streetAddress = "Officers Colony";
	String city = "city";
	State state = State.ANDHRA_PRADESH;
	ZipCode zipCode = new ZipCode();
	Address address = new Address(streetAddress, city, state, zipCode);
	assertNotNull(address);
	assertEquals(streetAddress, address.streetAddress());
	assertEquals(city, address.city());
	assertEquals(state, address.state());
	assertEquals(zipCode, address.zipCode());
	
	
	}
	
}
