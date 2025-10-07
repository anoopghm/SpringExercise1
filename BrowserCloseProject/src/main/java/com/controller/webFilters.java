package com.controller;

import java.io.IOException;

import com.model.User;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/form1/*")
public class webFilters implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        HttpSession session = req.getSession(false);
        boolean isLoginPage = uri.endsWith("/login") || uri.endsWith("/logout");

        if (session == null || session.getAttribute("username") == null) {
            if (!isLoginPage) {
                User user = new User();  
                req.setAttribute("userObj", user);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
                dispatcher.forward(request, response);
                return;
            }
         }
        chain.doFilter(request, response);
    }
}