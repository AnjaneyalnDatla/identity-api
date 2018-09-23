package com.srkr.identity.domain.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ZipCodeTest {
	
	@Test
	public void testZipCode(){
		ZipCode zipCode = new ZipCode();
		assertNotNull(zipCode);
		assertEquals("00000", zipCode.digits());
		ZipCode zipCode2 = new ZipCode("50084");
		assertEquals("50084", zipCode2.digits());
		
	}

}
