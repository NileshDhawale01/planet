package com.jpamapping.relation.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpamapping.relation.Services.JwtService;
import com.jpamapping.relation.Services.UserService;
import com.jpamapping.relation.dto.AuthReq;
import com.jpamapping.relation.entities.UserInfo;

@RestController
@RequestMapping("/basic")
public class BasicController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;

	@PostMapping
	public ResponseEntity<Map<Object, Object>> saveUser(@RequestBody UserInfo userInfo) {

		Map<Object, Object> map = new HashMap<>();
		map.put("data", userService.saveUser(userInfo));
		map.put("success", true);
		return new ResponseEntity<Map<Object, Object>>(map, HttpStatus.CREATED);
	}

	@PostMapping("/authenticate")
	public ResponseEntity<Map<Object, Object>> authenticateAndGetToken(@RequestBody AuthReq authReq) {

		Authentication manager = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authReq.getName(), authReq.getPassword()));
		if (manager.isAuthenticated()) {
			Map<Object, Object> map = new HashMap<>();
			map.put("token", jwtService.generateToken(authReq.getName()));
			map.put("success", true);
			return new ResponseEntity<Map<Object, Object>>(map, HttpStatus.CREATED);
		} else {
			throw new UsernameNotFoundException(authReq.getName());
		}
	}
}
