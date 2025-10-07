package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.context.ConfigurableApplicationContext;

import com.model.actions.Action;


public class RequestProcessor {
	private ConfigurableApplicationContext ctx;
	
	public void setCtx(ConfigurableApplicationContext ctx) {
		this.ctx=ctx;
	}
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ServletContext application = request.getServletContext();
			String realpath = application.getRealPath("/WEB-INF/lib/config.properties");
			
			Properties prop = new Properties();
			prop.load(new FileInputStream(realpath));
			
			String action = request.getParameter("action");
			System.out.println("Action.................:"+action);
			if(action==null) {
				
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			}
			else {
			System.out.println("\nTHE ACTION IS: "+action+"\n");
			
			
			Action actionObj = (Action)ctx.getBean(action);
			
			String result = actionObj.execute(request, response);
			String nextPage = prop.getProperty(result);
			
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}