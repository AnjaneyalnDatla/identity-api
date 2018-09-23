package com.srkr.identity.domain.model.postgres;

import org.springframework.data.repository.Repository;

public interface PostgresAuthenticationRepository extends Repository<Credentials, Long>{

	Credentials findByUserNameAndPassword(String userName,String password);
}
