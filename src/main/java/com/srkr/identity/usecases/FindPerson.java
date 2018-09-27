package com.srkr.identity.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srkr.identity.domain.model.Person;
import com.srkr.identity.domain.model.postgres.PersonMapper;
import com.srkr.identity.domain.model.postgres.PostgresPersonRepository;

@Service
public class FindPerson {
	
	@Autowired
	private PostgresPersonRepository personRepository;

	@Autowired
	private PersonMapper personMapper;

	
	public List<Person> findAllPersonByFirstName(String firstName) {
		List<Person> listPersons = personMapper.toListOfDomainObjects(personRepository.findByFirstName(firstName));
		return listPersons;
	}
	
	public List<Person> findAllPersonByLastName(String lastName) {
		List<Person> listPersons = personMapper.toListOfDomainObjects(personRepository.findByLastName(lastName));
		return listPersons;
	}
	
}
