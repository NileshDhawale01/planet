package com.jpamapping.relation.Services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jpamapping.relation.Services.UserService;
import com.jpamapping.relation.entities.UserInfo;
import com.jpamapping.relation.reposities.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public UserInfo saveUser(UserInfo userInfo) {
		userInfo.setPassword(encoder.encode(userInfo.getPassword()));
		return userRepo.save(userInfo);
	}

}
