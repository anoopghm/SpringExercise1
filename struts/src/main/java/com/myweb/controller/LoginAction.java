package com.myweb.controller;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("login")
public class LoginAction extends Action{
@Override
public String execute(HttpServletRequest req, HttpServletResponse res) {
	// TODO Auto-generated method stub
	return "login.success";
}
}
