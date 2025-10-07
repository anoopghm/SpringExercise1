package com.model.actions;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.User;
import com.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component("login")
public class LoginAction extends Action {
	@Autowired
	UserService userservice;
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception{
		String uname = req.getParameter("uname");
		String upass = req.getParameter("upass");
		boolean checkuser = userservice.checkUser(uname, upass);
		 if(checkuser == false) return "login.failure";
		User user = userservice.checkUserByNameAndPassword(uname,upass);
		HttpSession session=req.getSession();
		session.setAttribute("uname",user.getUsername());
		return Optional.ofNullable(user)
				.map(n->
					Optional.ofNullable(n.getUsername())
					.filter(u->{
						try {
							return userservice.checkFlag(u);
						}catch(Exception e) {e.printStackTrace();return true;}
					})
					.map(usern->{
						try {
							userservice.updateFlag(uname, 1);
						}catch(Exception e) {e.printStackTrace();}
						return "login.success";
					})
					.orElse("login.already")  
				)
				.orElse("login.failure");
	     }
	 
}
