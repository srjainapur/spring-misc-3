package com.java.spring.boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecondController {
	
	@RequestMapping(value="/second", method=RequestMethod.GET)
	public ModelAndView second() throws CustomException {
		System.out.println("Throwing Exception from Second Controller");
		throw new CustomException("Throwing Exception from SecondController");
	}
	
	@ExceptionHandler(CustomException.class)
	public ModelAndView handleCustomException(CustomException ce) {
		System.out.println("Handling CustomException");
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("exception", ce);
		return mv;
	}
}
