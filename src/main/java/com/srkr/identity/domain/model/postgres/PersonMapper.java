package com.srkr.identity.domain.model.postgres;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class PersonMapper {

	public Person toPostgresObject(com.srkr.identity.domain.model.Person person) {
		Person pgPerson = new Person();
		pgPerson.setFirstName(person.firstName());
		pgPerson.setMiddleName(person.middleName());
		pgPerson.setLastName(person.lastName());
		pgPerson.setCellPhone(person.cellPhone());
		pgPerson.setHomePhone(person.homePhone());
		pgPerson.setOfficePhone(person.OfficePhone());
		pgPerson.setEmailAddress(person.emailAddress());
		pgPerson.setDesignation(person.designation());
		Set<Address> addresses = new HashSet<>();
		for(com.srkr.identity.domain.model.Address address: person.addresses()) {
			Address address2 = new Address();
			address2.setStreetAddress(address.streetAddress());
			address2.setZipcode(Integer.parseInt(address.zipCode().digits()));
			address2.setCity(address.city());
			address2.setState(address.state().abbreviation());
			address2.setCountry(address.country().abbreviation());
			addresses.add(address2);
		}
		pgPerson.setAddresses(addresses);
		Department department = new Department();
		department.setName(person.department().name());
		department.setDescription(person.department().description());
		Set<Lab> labs = new HashSet<>();
		for(com.srkr.identity.domain.model.Lab lab: person.department().labs()) {
			Lab lab2 = new Lab();
			lab2.setName(lab.name());
			lab2.setDescription(lab.description());
			labs.add(lab2);
		}
		department.setLabs(labs);
		pgPerson.setDepartment(department);
		return pgPerson;
	}
	
}
