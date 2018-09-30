package com.radica.sso.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.radica.sso.model.account.UserModel;
import com.radica.sso.repository.account.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	
	//add user
	@RequestMapping(value = "/user/new", method = RequestMethod.GET)
	public String newUser(Model model) {
		model.addAttribute("user", new UserModel());
		return "userform";
	}
	
	//edit user
	@RequestMapping(value = "/user/edit/{id}", method = RequestMethod.PUT)
	public String editUser(@PathVariable Integer id, Model model) {
		//model.addAttribute("user", userService.getUserById(id));
		
		return "userform";
	}
	
	//get user info
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public String showUser(@PathVariable Integer id, Model model) {
		//model.addAttribute("user", userService.getUserById(id));
		
		return "showUser";
	}
	
	//get all user list
	@RequestMapping(value = "/searchUser", method = RequestMethod.GET)
	public String searchAllUser(Map<String, Object> model) {
		
		model.put("userList", userRepo.findAll());
		
		return "searchUser";
	}
	
	//save user
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String saveUser(UserModel userModel) {
		//userService.saveUser(userModel);
		return "redirect:/searchUser";
	}
	
	//delete user
	@RequestMapping(value = "/users/delete/{id}", method = RequestMethod.DELETE)
	public String deleteUser() {
		
		return "redirect:/searchUser";
	}
	
	
}
