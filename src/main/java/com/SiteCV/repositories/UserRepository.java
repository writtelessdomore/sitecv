package com.SiteCV.repositories;

import org.springframework.data.repository.CrudRepository;

import com.SiteCV.domain.User;

public interface UserRepository  extends CrudRepository<User, Integer> {

}
