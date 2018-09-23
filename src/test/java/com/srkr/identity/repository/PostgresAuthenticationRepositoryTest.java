package com.srkr.identity.repository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.srkr.identity.domain.model.postgres.PostgresAuthenticationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostgresAuthenticationRepositoryTest {
	
	@Autowired
	private PostgresAuthenticationRepository authenticationRepository;
	
	

}
