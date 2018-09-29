package com.srkr.identity.domain.model.postgres;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface PostgresPersonRepository extends Repository<Person, Long>{


	Person save(Person person);
	
	void delete(Person person);
	
	List<Person> findByFirstName(String firstName);
	
	List<Person> findByLastName(String lastName);

}
