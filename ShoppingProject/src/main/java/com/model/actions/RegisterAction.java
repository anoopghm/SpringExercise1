package com.model.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.User;
import com.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("register")
public class RegisterAction extends Action{
	@Autowired
	UserRepository userrepo;
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		User user = new User();
		user.setUsername(req.getParameter("uname"));
		user.setUserpass(req.getParameter("upass"));
		user.setFlag(0);
		userrepo.save(user);
		return "logout.success";
	}
}