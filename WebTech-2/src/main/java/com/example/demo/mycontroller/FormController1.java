package com.example.demo.mycontroller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/form1")
public class FormController1 {
   @RequestMapping(method = RequestMethod.GET, value="/register")
   public ModelAndView loadform() {
	   ModelAndView mandv = new ModelAndView();
	   mandv.addObject("userObj",new User());
	   mandv.setViewName("userform");
	   return mandv;
   }
   @RequestMapping(method = RequestMethod.POST, value = "/register")
	public ModelAndView processForm(@Valid @ModelAttribute("userObj") User user
			,BindingResult result) {
		ModelAndView mandv=new ModelAndView();		
		if(result.hasErrors()) {
			mandv.setViewName("userform");           
			 return mandv;
		}
		else {
			System.out.println("Username...:"+user.getUname());
			user.setUname(user.getUname()+"encora technologies...");
			mandv.addObject("myuser",user);
			mandv.setViewName("welcome");
			return mandv;
		}
	}
}
