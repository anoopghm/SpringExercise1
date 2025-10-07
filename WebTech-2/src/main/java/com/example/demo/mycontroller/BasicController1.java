package com.example.demo.mycontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/bs3")
@SessionAttributes({"myobj"})
public class BasicController1{
	@RequestMapping(method = RequestMethod.GET,value = "/basic")
	public String sayHelloBasic() {
		return "Home";
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/hello")
	public String sayHelloBasic(HttpServletRequest request, Model model) {
		 request.setAttribute("myobjrequest","this is request added value");
		 model.addAttribute("myobj","this is session value added in hello1");
		 model.addAttribute("myobjrequest2","this is request second value");
		 return "Home";
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/hello3")
	public ModelAndView sayHello3() {
		ModelAndView mandv = new ModelAndView();
		mandv.addObject("myobj","model and view object called..");
		mandv.setViewName("Home");
		return mandv;
	}
	
}

