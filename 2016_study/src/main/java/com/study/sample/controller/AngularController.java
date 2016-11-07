package com.study.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AngularController {
	
	@RequestMapping("/sample/angularTest")
	public ModelAndView test() {
	  ModelAndView mv = new ModelAndView();
	  
	  mv.setViewName("/sample/angularTest");
	  return mv;
	}
}
