package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.CustomerInfo;
/*
 * In this controller we are going create(insert) customer.
 */
@Controller
@RequestMapping("/create")
public class CustomerController {
	/*
	 * In this method we are going to that url and it is diected to rest(CustomerRest)
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView customer(CustomerInfo cus) {
		//these url is used to direct to our rest their we will specify dao class .
		String url="http://localhost:8181/customerinfo/insert";
		RestTemplate restTemplate=new RestTemplate();
		String  status=restTemplate.postForObject(url, cus, String.class);
		//that message will be displayed in display.jsp 
		ModelAndView modelAndView=new ModelAndView("Display.jsp");
		modelAndView.addObject("obj",status);
    	return modelAndView;
		

//		
	
}
}

