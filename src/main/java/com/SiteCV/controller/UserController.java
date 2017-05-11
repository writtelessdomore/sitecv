package com.SiteCV.controller;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SiteCV.domain.User;
import com.SiteCV.services.UserService;


@RestController
@RequestMapping("/User")
public class UserController {

	@Resource
	private UserService UserService;

	@Autowired
	public void setUserService(UserService UserService) {
		this.UserService = UserService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<User> getAllUsers() {
		return this.UserService.listAllUsers();
	}		

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public User updateUser(@PathVariable(value = "id") int id, @RequestBody User User) {
		User.setIdUser(id);
		return this.UserService.updateUser(User);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable(value = "id") int id) {
		this.UserService.deleteUser(id);
	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
	public void deleteUsers() {
		this.UserService.deleteUsers();
	}

	public UserService getUserService() {
		return UserService;
	}

}
