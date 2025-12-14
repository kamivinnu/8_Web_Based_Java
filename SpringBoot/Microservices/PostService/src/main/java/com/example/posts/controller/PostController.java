package com.example.posts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.posts.model.Post;

@RestController
@RequestMapping("/")
public class PostController {
	
	@GetMapping("/posts/{postid}")
	public Post getPosts(@PathVariable("postid") int id) {
		
		Post post = new Post(id, "This is Post Microservice with ID: "+id);
		
		return post;
	}

}
