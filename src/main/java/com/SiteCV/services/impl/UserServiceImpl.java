package com.SiteCV.services.impl;

import java.util.Collection;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SiteCV.domain.User;
import com.SiteCV.repositories.UserRepository;
import com.SiteCV.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository UserRepository;

	@Autowired
	public void setUserRepository(UserRepository UserRepository) {
		this.UserRepository = UserRepository;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<User> listAllUsers() {
		return IteratorUtils.toList(this.UserRepository.findAll().iterator());
	}

	@Override
	public User getUserById(Integer id) {
		return this.UserRepository.findOne(id);
	}

	
	@Override
	public User updateUser(User User) {
		return this.UserRepository.save(User);
	}

	@Override
	public void deleteUser(int id) {
		this.UserRepository.delete(id);
	}

	@Override
	public void deleteUsers() {
		this.UserRepository.deleteAll();
	}


	@Override
	public User addUser(User User) {
		return this.UserRepository.save(User);
	}

}
