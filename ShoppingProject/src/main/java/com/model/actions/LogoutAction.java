package com.model.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component("logout")
public class LogoutAction extends Action {
	
	@Autowired
	private UserService userservice;
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		  HttpSession session = req.getSession();
		  userservice.updateFlag((String)session.getAttribute("uname"), 0);
		  return "logout.success";
	}
}
