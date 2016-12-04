package com.study.admin;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		logger.info("Login Page : {}",locale);
				
		return "/login";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
  public String main(Locale locale, Model model) {
    logger.info("Welcome home! The client locale is {}.", locale);
        
    return "/main.tiles";
  }
	@RequestMapping(value = "/member", method = RequestMethod.GET)
  public String member(Locale locale, Model model) {
    logger.info("Welcome home! The client locale is {}.", locale);
        
    return "/member/member.tiles";
  }
	
	@RequestMapping(value = "/catalog", method = RequestMethod.GET)
  public String catalog(Locale locale, Model model) {
    logger.info("Welcome home! The client locale is {}.", locale);
        
    return "/goods/catalog.tiles";
  }
}
