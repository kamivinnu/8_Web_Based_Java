package com.example.thyme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DemoController {

	@GetMapping("/hello")
	public String sayHello() {
		return "hello";
	}
	
	@GetMapping("/date")
	public String getDate(Model model) {
		model.addAttribute("theDate", new java.util.Date());
		return "date";
	}
	
}
