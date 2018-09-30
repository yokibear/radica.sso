package com.radica.sso.service.account;

import java.util.List;

import com.radica.sso.entity.account.UserDBVO;


public interface UserService {
	
	void deleteUser(List<String> userIds);
	
	UserDBVO saveUser(UserDBVO user);
	
	UserDBVO getUserById(Integer id);
}
