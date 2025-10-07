package com.encora.service;

import com.encora.model.Users;

public interface UserService {
	public Users getUser(String username) throws UserNotFoundException;
	public boolean checkUser(String username,String userpass)  throws UserNotFoundException ;
	public boolean checkFlag(String uname);
	public void updateFlag(String uname,int flag);
	public Users createUser(String uname, String password);
	public Users checkUserByNameAndPassword(String uname, String password) throws UserNotFoundException;
}