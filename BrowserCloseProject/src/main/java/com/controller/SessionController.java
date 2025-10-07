package com.controller;

import com.model.User;
import com.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/form1")
public class SessionController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView loadform() {
        ModelAndView mandv = new ModelAndView("login");
        mandv.addObject("userObj", new User());
        return mandv;
    }

    @PostMapping("/login")
    public ModelAndView processForm(@Valid @ModelAttribute("userObj") User user,
                                    BindingResult result,
                                    HttpServletRequest request) {
        ModelAndView mandv = new ModelAndView();

        if (result.hasErrors()) {
            mandv.setViewName("login");
            return mandv;
        }

        try {
            boolean isValid = userService.checkUser(user.getUsername(), user.getUserpass());
            if (isValid) {
                mandv.addObject("myuser", user);
                userService.updateFlag(user.getUsername(), 1);
                request.getSession().setAttribute("username", user.getUsername());
                mandv.setViewName("welcome");
            }
        } catch (Exception e) {
            mandv.setViewName("login");
            mandv.addObject("error", "Invalid username or password");
        }
        return mandv;
    }
    
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username != null) {
            userService.updateFlag(username, 0);
            session.invalidate();
        }
        return "redirect:/form1/login";
    }
}
