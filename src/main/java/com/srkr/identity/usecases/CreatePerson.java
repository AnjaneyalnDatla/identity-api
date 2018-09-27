package com.srkr.identity.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srkr.identity.domain.model.Person;
import com.srkr.identity.domain.model.postgres.PersonMapper;
import com.srkr.identity.domain.model.postgres.PostgresPersonRepository;

@Service
public class CreatePerson {

	@Autowired
	private PostgresPersonRepository personRepository;

	@Autowired
	private PersonMapper personMapper;

	public Person createPerson(Person person) {
		Person personSave = personMapper.toDomainObject(personRepository.save(personMapper.toPostgresObject(person)));
		return personSave;
	}

}
