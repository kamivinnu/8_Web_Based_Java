package com.example.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.users.model.Notification;
import com.example.users.model.Post;
import com.example.users.model.User;

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/users/{uid}")
	public User getUsers(@PathVariable("uid") int id) {
	
		User user = new User(id, "ABC with user ID: "+id);
		
		// API calls using RestTemplate
		 
	Post post	= restTemplate.getForObject("http://localhost:9001/posts/1", Post.class);
	user.setPost(post);
		
	Notification notification	= restTemplate.getForObject("http://localhost:9002/notifications/1", Notification.class);
	user.setNotification(notification);
	
	return user;  // user details + post + notification
	}

}
