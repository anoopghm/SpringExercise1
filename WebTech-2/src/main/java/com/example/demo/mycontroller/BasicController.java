package com.example.demo.mycontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/bc1")
public class BasicController{
	//http://localhost:8080/bc1/hello--
	@RequestMapping(method = RequestMethod.GET,value = "/hello")
	public void sayHello(HttpServletRequest request) {
		System.out.println("Hello Get method is calling"+ request);
		HttpSession session = request.getSession();
		System.out.println("session..." + session.getId());
		session.setAttribute("mykey", "this is mykey value..");
		String str = session.getAttribute("mykey").toString();
		System.out.println("value.." + str);
	
	}
	@RequestMapping(method = RequestMethod.GET,value = "/hello1")
	public void sayHello1() {
		System.out.println("Hello Get method is calling");
	}
	@RequestMapping(method = RequestMethod.GET,value = "/hello2")
	public void sayHello2(@RequestParam("name")String uname, @RequestParam("pass")String upass) {
		System.out.println("Hello Get method is calling "+uname+":"+upass);
	}
	
}