package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.CustomerInfo;
import com.example.demo.entity.ItemInfo;
/*
 * In this controller we are going add or insert items.
 */
@Controller
@RequestMapping("/item")
public class ItemController {
	//this method is used to add items
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView customer(ItemInfo item) {
		String url="http://localhost:8181/iteminfo/add";
		RestTemplate restTemplate=new RestTemplate();
		String  status=restTemplate.postForObject(url, item, String.class);
		//we will display message in Display.jsp using object.
		ModelAndView modelAndView=new ModelAndView("Display.jsp");
		modelAndView.addObject("obj",status);
    	return modelAndView;

}
}
