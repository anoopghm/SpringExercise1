package com.encora.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.encora.model.Users;
import com.encora.service.UserService;

@Component
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	public String login(String uname,String password)throws Exception {
		Users user=userservice.checkUserByNameAndPassword(uname, password);
		return Optional.ofNullable(user)
				.map(n->
					Optional.ofNullable(n.getUsername())
					.filter(u->{
						try {
							return userservice.checkFlag(u);
						}catch(Exception e) {e.printStackTrace();return false;}
					})
					.map(usern->{
						try {
							userservice.updateFlag(uname, 1);
						}catch(Exception e) {e.printStackTrace();}
						return "Login.Successfull";
					})
					.orElse("Login.AlreadyLogedIn")
				)
				.orElse("Login.invalid user...");
	}
	public void logout(String uname) {
		userservice.updateFlag(uname, 0);
	}
}