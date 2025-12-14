package com.example.users.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private int userId;
	private String userName;
	
	private Post post;
	private Notification notification;
	
	public User(int userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}	
}
