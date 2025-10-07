package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.servlets.ActionServlet;

@SpringBootApplication(exclude = { 
		  org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.class,
	        org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration.class,
	        org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration.class
		
})
@ServletComponentScan // 👈 tells Boot to scan for @WebServlet, @WebFilter, @WebListener
@ComponentScan("com")
public class ShoppingProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ShoppingProjectApplication.class, args);

		ServletRegistrationBean<ActionServlet>hs = ctx.getBean("actionServlet", ServletRegistrationBean.class);
		ActionServlet actionServlet = hs.getServlet();
		actionServlet.setCtx(ctx);
	}
}
