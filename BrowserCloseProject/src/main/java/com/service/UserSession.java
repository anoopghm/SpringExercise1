package com.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@Component
@WebListener
public class UserSession implements HttpSessionListener {
	@Autowired
	UserService us;
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().setMaxInactiveInterval(10);
		System.out.println("Session Active");
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		String uname = (String) se.getSession().getAttribute("username");
		try {
			us.updateFlag(uname, 0);
			System.out.println("doneee");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}