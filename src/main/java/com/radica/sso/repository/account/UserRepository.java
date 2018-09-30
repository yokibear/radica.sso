package com.radica.sso.repository.account;

import org.springframework.data.repository.CrudRepository;

import com.radica.sso.entity.account.UserDBVO;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete
public interface UserRepository extends CrudRepository<UserDBVO, Integer> {
	UserDBVO findByFirstNameAndLastName(String firstName, String lastName);
	
}
