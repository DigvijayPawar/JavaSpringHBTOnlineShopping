package com.app.onlineshoping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler  {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHanderFoundException() {
		ModelAndView mav = new ModelAndView("error");
		
		mav.addObject("errorTitle","Page Is Not Constructed...!");
		mav.addObject("errorDescription","The Page You Are Looking For Is Not Available Now...!!!");
		mav.addObject("title","404 Error page");
		return mav;
	}
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {
		ModelAndView mav = new ModelAndView("error");
		
		mav.addObject("errorTitle","Product  Not Constructed...!");
		mav.addObject("errorDescription","The Product You Are Looking For Is Not Available Right Now...!!!");
		mav.addObject("title","Unavailable Product");
		return mav;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		ModelAndView mav = new ModelAndView("error");
		
		mav.addObject("errorTitle","Contact your administrator...!");
		
		/*only for dubugging your application dont use in production environment */
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		ex.printStackTrace(pw);
		
		
		mav.addObject("errorDescription",sw.toString());
		mav.addObject("title","Error");
		return mav;
	}
	
}	
