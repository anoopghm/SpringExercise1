package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;

import com.controller.RequestProcessor;

//@WebServlet("*.do")
public class ActionServlet extends HttpServlet {
	private RequestProcessor rp;
	private ConfigurableApplicationContext ctx;
    public ActionServlet() {
        rp = new RequestProcessor();
 
    }

    public void setCtx(ConfigurableApplicationContext ctx) {
    		this.ctx=ctx;
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rp.setCtx(ctx);
		rp.doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
