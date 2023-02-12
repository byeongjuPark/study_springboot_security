package com.bottlepark.study_springboot_security.controller;

import java.util.Map;

import com.bottlepark.study_springboot_security.service.MemberWithAuthorityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MemberWithAuthorityController {

    
    @Autowired
    MemberWithAuthorityService memberWithAuthorityService;

    @RequestMapping(value = "/joinForm", method = RequestMethod.GET)
    public ModelAndView joinForm(ModelAndView modelAndView){
        String viewName = "/WEB-INF/views/member/joinForm.jsp";
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

    @RequestMapping(value = "/joinProc", method = RequestMethod.POST)
    public String joinProc(@RequestParam Map params, ModelAndView modelAndView){
        Object result = memberWithAuthorityService.insert(params);
        return "redirect:/";
    }
}
