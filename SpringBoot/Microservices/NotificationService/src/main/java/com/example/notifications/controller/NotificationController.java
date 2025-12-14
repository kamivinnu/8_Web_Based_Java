package com.example.notifications.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notifications.model.Notification;

@RestController
@RequestMapping("/")
public class NotificationController {
	
	@GetMapping("/notifications/{notifyid}")
	public Notification getNotifications(@PathVariable("notifyid") int id) {
		
		Notification notification = new Notification(id, "Post Created and notified with ID: "+id);
		
		return notification;
	}

}
