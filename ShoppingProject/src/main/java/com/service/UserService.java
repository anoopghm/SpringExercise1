package com.service;

import com.model.User;

public interface UserService {
	public User getUser(String username) throws UserNotFoundException;
	public boolean checkUser(String username,String userpass)  throws UserNotFoundException ;
	public boolean checkFlag(String uname);
	public void updateFlag(String uname,int flag);
	public User createUser(String uname, String password);
	public User checkUserByNameAndPassword(String uname, String password) throws UserNotFoundException;
}