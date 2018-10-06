package com.srkr.identity.domain.model.postgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredentialsMapper {

	@Autowired
	private PersonMapper personMapper;

	public Credentials toPostgresObject(com.srkr.identity.domain.model.Credentials credentials) {
		Credentials creds = new Credentials();
		creds.setUserName(credentials.getUserName());
		creds.setPassword(credentials.getPassword());
		creds.setPerson(personMapper.toPostgresObject(credentials.getPerson()));
		return creds;
	}

	public com.srkr.identity.domain.model.Credentials toDomainObject(Credentials credentials) {
		return new com.srkr.identity.domain.model.Credentials(credentials.getUserName(), credentials.getPassword(),
				(null != credentials.getPerson() ? personMapper.toDomainObject(credentials.getPerson()) : null));
	}

}
