package com.srkr.identity.domain.model.postgres;

import org.springframework.data.repository.Repository;

public interface PostgresAuthenticationRepository extends Repository<Credentials, Long>{

	Credentials save(Credentials credentials);
	
	Credentials findByUserNameAndPassword(String userName,String password);
}
