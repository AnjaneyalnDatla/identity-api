package com.srkr.identity.domain.model.postgres;

import org.springframework.data.repository.Repository;

public interface PostgresPersonRepository extends Repository<Person, Long>{


	Person save(Person person);
	
	Person findByFirstName(String firstName);
	
	Person findByLastName(String lastName);

}
