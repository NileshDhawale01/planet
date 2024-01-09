package com.jpamapping.relation.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.jpamapping.relation.config.UserInfoUserDetails;
import com.jpamapping.relation.entities.UserInfo;
import com.jpamapping.relation.reposities.UserRepo;

@Component
public class UserInfoUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userInfo = userRepo.findByName(username);
		return userInfo.map(UserInfoUserDetails::new).orElseThrow(() -> new UsernameNotFoundException(username));
	}

}
