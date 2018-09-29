package com.srkr.identity.domain.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class PersonTest {
	
	@Test
	public void testPerson() {
		
		Organization organization = new Organization(new String ("name"), new String ("description"),Address.emptyDefault());
		Set<Lab> labs = new HashSet<>();
		Lab lab = new Lab(new String("LabName"), new String("LabDescription"));
		labs.add(lab);
		Department department = new Department(new String("Civil engineering"), 
				new String("deals with the design, construction, and maintenance of the physical and naturally built environment"),labs);
		PersonRole personrole = new PersonRole(new String("name"), new String("description"));
		Set <Address> addresses = new HashSet<>();
		Address address = Address.emptyDefault();
		Address address2 = Address.emptyDefault();
		addresses.add(address);
		addresses.add(address2);
		Person supervisor = new Person(new String("Anjaneya"), new String("Datla"), new String("9769098780"), 
				new String("anjaneya@gmail.com"), organization, department, new String ("designation"));
		Person person = new Person(new String("Sneha"),new String(""),new String("Gokaraju"),
				new String("9876500110"), new String("9876500110"),new String("9876500110"),
				new String("sneha92@gmail.com"),organization,department,new String("designation"),
				personrole,supervisor,addresses);
		assertNotNull(personrole);
		assertEquals("Anjaneya", supervisor.firstName());
		assertEquals("Gokaraju", person.lastName());
		assertNotNull(address2);
		assertEquals("name", personrole.name());
		assertNotEquals("sneha@gmail.com", person.emailAddress());
		assertEquals("9769098780", supervisor.cellPhone());
		assertEquals("designation", person.designation());
		
		
		
	}

}
