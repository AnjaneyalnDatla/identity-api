package com.srkr.identity.domain.model.postgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredentialsMapper {

	@Autowired
	private PersonMapper personMapper;

	public Credentials toPostgresObject(com.srkr.identity.domain.model.Credentials credentials) {
		Credentials creds = new Credentials();
		creds.setUserName(credentials.userName());
		creds.setPassword(credentials.password());
		creds.setPerson(personMapper.toPostgresObject(credentials.person()));
		return creds;
	}

	public com.srkr.identity.domain.model.Credentials toDomainObject(Credentials credentials) {
		return new com.srkr.identity.domain.model.Credentials(credentials.getUserName(), credentials.getPassword(),
				personMapper.toDomainObject(credentials.getPerson()));
	}

}
