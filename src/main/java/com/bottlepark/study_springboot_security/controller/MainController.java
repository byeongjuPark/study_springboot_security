package com.bottlepark.study_springboot_security.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {


    @GetMapping("/")
    public ModelAndView main(ModelAndView modelAndView){
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String username = null;
        if (principal instanceof UserDetails) {
        username = ((UserDetails)principal).getUsername();
        } else {
        username = principal.toString();
        }
        

        String viewName = "/WEB-INF/views/main.jsp";
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

    @GetMapping("/admin")   
    public ModelAndView admin(ModelAndView modelAndView){
        String viewName = "/WEB-INF/views/admin.jsp";
        modelAndView.setViewName(viewName);
        return modelAndView;
    }
}
