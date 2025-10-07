package com.model.actions;

import java.util.Enumeration;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component("shopping")
public class ShoppingAction extends Action {
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		String shopId = req.getParameter("shopid");
		addToSession(req);
		return shopId;
	}

	public void addToSession(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Enumeration<String> e = req.getParameterNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			String value = req.getParameter(name);
			session.setAttribute(name, value);
		}
	}

}
