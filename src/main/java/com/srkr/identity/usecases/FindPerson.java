package com.srkr.identity.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srkr.identity.domain.model.Credentials;
import com.srkr.identity.domain.model.Person;
import com.srkr.identity.domain.model.postgres.CredentialsMapper;
import com.srkr.identity.domain.model.postgres.PersonMapper;
import com.srkr.identity.domain.model.postgres.PostgresAuthenticationRepository;
import com.srkr.identity.domain.model.postgres.PostgresPersonRepository;

@Service
public class FindPerson {

	@Autowired
	private PostgresPersonRepository personRepository;

	@Autowired
	private PostgresAuthenticationRepository personAuthRepository;

	@Autowired
	private PersonMapper personMapper;

	@Autowired
	private CredentialsMapper credentialsMapper;

	public List<Person> findAllPersonByFirstName(String firstName) {
		return personMapper.toListOfDomainObjects(personRepository.findByFirstName(firstName));
	}

	public List<Person> findAllPersonByLastName(String lastName) {
		return personMapper.toListOfDomainObjects(personRepository.findByLastName(lastName));
	}

	public Credentials findPersonByCredentials(Credentials credentials) {
		return credentialsMapper.toDomainObject(
				personAuthRepository.findByUserNameAndPassword(credentials.userName(), credentials.password()));
	}
}
