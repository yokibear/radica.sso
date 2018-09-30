package com.radica.sso.repository.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.radica.sso.entity.account.UserDBVO;
import com.radica.sso.repository.account.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepoTest {
	@Autowired
	private UserRepository userRepo;
	
	@Before
	public void init() {
		
		UserDBVO user1 = new UserDBVO("Bob", "Po", "bob@162.com"); 
		UserDBVO user2 = new UserDBVO("Ivy", "Po", "Ivy@162.com"); 
		assertNull(user1.getId());
		assertNull(user2.getId());
		
		this.userRepo.save(user1);
		this.userRepo.save(user2);
		
		assertNotNull(user1.getId());
		assertNotNull(user2.getId());
	}
	
	
	@Test
	public void testFetchUser() {
		UserDBVO user = userRepo.findByFirstNameAndLastName("Bob", "Po");
		assertNotNull(user);
		assertEquals("bob@162.com", user.getEmail());
		
		Iterable<UserDBVO> users = userRepo.findAll();
		int userCount = 0;
		for(UserDBVO p : users) {
			userCount++;
		}
		assertEquals(2, userCount);
	}
	
}
