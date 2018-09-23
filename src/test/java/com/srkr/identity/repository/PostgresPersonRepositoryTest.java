package com.srkr.identity.repository;

import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.srkr.identity.domain.model.postgres.Address;
import com.srkr.identity.domain.model.postgres.Department;
import com.srkr.identity.domain.model.postgres.Lab;
import com.srkr.identity.domain.model.postgres.Organization;
import com.srkr.identity.domain.model.postgres.Person;
import com.srkr.identity.domain.model.postgres.PersonRole;
import com.srkr.identity.domain.model.postgres.PostgresPersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostgresPersonRepositoryTest {
	
	@Autowired
	PostgresPersonRepository personRepository;
	
	Person person;
	
	@Before
	public void setUp() {
		person = new Person();
		person.setFirstName("FirstNameTest");
		person.setMiddleName("MiddleNameTest");
		person.setLastName("LastNameTest");
		//person.setCellPhone(new Long(1111111111));
		//person.setHomePhone(new Long(2222222222));
		//person.setOfficePhone(new Long(3333333333));
		person.setEmailAddress("test@test.com");

		Organization organization = new Organization();
		organization.setName("OrganisationNameTest");
		organization.setDescription("OrganisationDescriptionTest");
		organization.setStreetAddress("StreetAddressTest");
		organization.setCity("CityTest");
		organization.setState("StateTest");
		organization.setCountry("CountryTest");
		organization.setLandmark("LandMarkTest");
		organization.setZipcode(11111);

		person.setOrganization(organization);
		
		Set<Address> addresses = new HashSet<>();
		Address address = new Address();
		address.setStreetAddress("StreetAddressTest");
		address.setCity("CityTest");
		address.setState("StateTest");
		address.setCountry("CountryTest");
		address.setLandmark("LandMarkTest");
		addresses.add(address);
		person.setAddresses(addresses);
		
		Department department = new Department();
		department.setName("DepartmentNameTest");
		department.setDescription("DepartmentDescriptionTest");
		Set<Lab> labs = new HashSet<>();
		Lab lab = new Lab();
		lab.setName("LabNameTest");
		lab.setDescription("LabDescriptionTest");
		labs.add(lab);
		department.setLabs(labs);
		person.setDepartment(department);
		
		PersonRole personRole = new PersonRole();
		personRole.setName("PersonRoleTest");
		personRole.setDescription("PersonRoleDescriptionTest");
		person.setPersonRole(personRole);
		
		person.setDesignation("DesignationTest");
	}
	
	@Test
	public void saveTest() {
		Person person = personRepository.save(this.person);
		assertNotNull(person.getId());
		
	}


}
