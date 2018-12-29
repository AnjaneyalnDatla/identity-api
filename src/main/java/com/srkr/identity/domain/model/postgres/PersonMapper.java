package com.srkr.identity.domain.model.postgres;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srkr.identity.domain.model.Country;
import com.srkr.identity.domain.model.Organization;
import com.srkr.identity.domain.model.State;
import com.srkr.identity.domain.model.ZipCode;

@Service
public class PersonMapper {

	@Autowired
	private DepartmentMapper departmentMapper;

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
		for (com.srkr.identity.domain.model.Address address : person.addresses()) {
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

		pgPerson.setDepartment(department);
		PersonRole personRole = new PersonRole();
		personRole.setName(person.personRole().name());
		personRole.setDescription(person.personRole().description());
		pgPerson.setPersonRole(personRole);
		if (null != person.superVisior()) {
			pgPerson.setSupervisor(toPostgresObject(person.superVisior()));
		}
		return pgPerson;
	}

	public com.srkr.identity.domain.model.Person toDomainObject(Person pgPerson) {

		if (pgPerson == null) {
			return null;
		}

		com.srkr.identity.domain.model.Department department = new com.srkr.identity.domain.model.Department(
				pgPerson.getDepartment().getId(), pgPerson.getDepartment().getName(),
				pgPerson.getDepartment().getDescription());

		Set<com.srkr.identity.domain.model.Address> addresses = new HashSet<>();
		for (Address address : pgPerson.getAddresses()) {
			com.srkr.identity.domain.model.Address address2 = new com.srkr.identity.domain.model.Address(
					address.getStreetAddress(), address.getCity(), State.valueOfAbbreviation(address.getState()),
					new ZipCode(address.getZipcode() + ""), address.getLandmark(),
					Country.valueOfAbbreviation(address.getCountry()));
			addresses.add(address2);
		}

		Organization organization = new Organization(pgPerson.getOrganization().getName(),
				pgPerson.getOrganization().getDescription(),
				new com.srkr.identity.domain.model.Address(pgPerson.getOrganization().getStreetAddress(),
						pgPerson.getOrganization().getCity(),
						State.valueOfAbbreviation(pgPerson.getOrganization().getState()),
						new ZipCode(pgPerson.getOrganization().getZipcode() + ""),
						pgPerson.getOrganization().getLandmark(),
						Country.valueOfAbbreviation(pgPerson.getOrganization().getCountry())),
				this.departmentMapper.toListDomainObjects(pgPerson.getOrganization().getDepartments()));

		com.srkr.identity.domain.model.Person person = new com.srkr.identity.domain.model.Person(pgPerson.getId(),
				pgPerson.getFirstName(), pgPerson.getMiddleName(), pgPerson.getLastName(), pgPerson.getCellPhone(),
				pgPerson.getHomePhone(), pgPerson.getOfficePhone(), pgPerson.getEmailAddress(), organization,
				department, pgPerson.getDesignation(),
				new com.srkr.identity.domain.model.PersonRole(pgPerson.getPersonRole().getName(),
						pgPerson.getPersonRole().getDescription()),
				toDomainObject(pgPerson.getSupervisor()), addresses);

		return person;
	}

	public List<com.srkr.identity.domain.model.Person> toListOfDomainObjects(List<Person> persons) {
		List<com.srkr.identity.domain.model.Person> persons2 = new ArrayList<>();
		persons.forEach(p -> {
			persons2.add(toDomainObject(p));
		});
		return persons2;
	}
}
