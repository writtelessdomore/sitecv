	package com.SiteCV.services;

import java.util.Collection;

import com.SiteCV.domain.User;

public interface UserService {

	Collection<User> listAllUsers();

	User getUserById(Integer id);

	User addUser(User User);

	User updateUser(User User);

	void deleteUser(int id);

	void deleteUsers();

}
