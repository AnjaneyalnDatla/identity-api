package com.srkr.identity.usecases;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.srkr.identity.domain.model.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FindPersonTest {
	@Autowired
	FindPerson findPerson;
	
	@Before
	public void setUp() {
		//this.findPerson = new FindPerson();
	}

	@Test
	public void findAllPersonByFirstNameTest() {
		//List<Person> allPersons = this.findPerson.findAllPersonByFirstName("FirstNameTest");
		//assertNotNull(allPersons);
		//assertEquals(allPersons.size(),1);
	}

}
