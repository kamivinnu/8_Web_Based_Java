package com.example.demo.rest;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/"})
public class MyRestController {
	
	public MyRestController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping({"/hi"})
	public String sayHi() {
		return "Welcome to Spring boot";
	}
	
	@GetMapping({"/bye"})
	public String sayBye() {
		return "See u Again";
	}
	
	@GetMapping({"/date"})
	public String getTodaysDate () {
		Date d = new Date();
		return "Todays Date: " + d;
	}
	
	@GetMapping({"/welcome"})
	public String welcome() {
		return "Welcome Again....";
	}	

}
