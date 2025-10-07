package com.model.actions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

abstract public class Action {
	public abstract String execute(HttpServletRequest req, HttpServletResponse res) throws Exception;	
}