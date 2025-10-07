package com;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.servlets.ActionServlet;

@Configuration
public class ServletConfig {

	@Bean
	public ServletRegistrationBean<ActionServlet> actionServlet() {
		ServletRegistrationBean srb=new ServletRegistrationBean<>(new ActionServlet(), "*.do");
		srb.setLoadOnStartup(1);
		return srb;
	}
}