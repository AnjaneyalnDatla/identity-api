package com.srkr.identity.repository;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.srkr.identity.domain.model.postgres.Address;
import com.srkr.identity.domain.model.postgres.Credentials;
import com.srkr.identity.domain.model.postgres.Department;
import com.srkr.identity.domain.model.postgres.Organisation;
import com.srkr.identity.domain.model.postgres.Person;
import com.srkr.identity.domain.model.postgres.PersonRole;
import com.srkr.identity.domain.model.postgres.PostgresAuthenticationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PostgresAuthenticationRepositoryTest {
	
	@Autowired
	private PostgresAuthenticationRepository authenticationRepository;
	
	Person person;
	Credentials credentials = new Credentials();
	
	@Before
	public void setUp(){
		
		person = new Person();
		person.setFirstName("FirstNameTest");
		person.setMiddleName("MiddleNameTest");
		person.setLastName("LastNameTest");
		person.setCellPhone(new String("1111111111"));
		person.setHomePhone(new String("2222222222"));
		person.setOfficePhone(new String("3333333333"));
		person.setEmailAddress("test@test.com");

		Organisation organization = new Organisation();
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
		person.setDepartment(department);
		
		PersonRole personRole = new PersonRole();
		personRole.setName("PersonRoleTest");
		personRole.setDescription("PersonRoleDescriptionTest");
		person.setPersonRole(personRole);
		
		person.setDesignation("DesignationTest");
		
		credentials = new Credentials();
		credentials.setUserName("admin@admin.com");
		credentials.setPassword("Admin123!");
		credentials.setPerson(person);
		credentials.setIsActive(new Date());
		
	}
	@Test
	public void saveCredentials() {
		Credentials credentials = authenticationRepository.save(this.credentials);
		assertNotNull(credentials);
	}

}
