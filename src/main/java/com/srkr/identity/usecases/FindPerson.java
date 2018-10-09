package com.srkr.identity.usecases;

import java.util.List;

import javax.naming.NameNotFoundException;
import javax.transaction.Transactional;

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

	@Transactional
	public List<Person> findPersonByName(String firstName, String lastName) throws NameNotFoundException {
		if (null != lastName) {
			return personMapper.toListOfDomainObjects(personRepository.findByLastName(firstName));
		} else if (null != firstName) {
			return personMapper.toListOfDomainObjects(personRepository.findByFirstName(lastName));
		}
		throw new NameNotFoundException();
	}

	@Transactional
	public Credentials findPersonByCredentials(Credentials credentials) throws NameNotFoundException {
		Object object = personAuthRepository.findByUserNameAndPassword(credentials.getUserName(),
				credentials.getPassword());
		if (object == null) {
			throw new NameNotFoundException();
		}
		Credentials creds = credentialsMapper
				.toDomainObject((com.srkr.identity.domain.model.postgres.Credentials) object);
		return creds;
	}
}
