package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {
	@RequestMapping(value = {"","/"}, method = RequestMethod.GET)
	public String hello(ModelMap model) {
		model.addAttribute("message", "Message from HelloController");
		return "hello";
	}
	
	
}
