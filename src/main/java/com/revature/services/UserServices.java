package com.revature.services;

import java.util.List;

import com.revature.models.User;

public interface UserServices {
	public User login(String username, String password);
	public List<User> findAll();
	
}



