package com.revature.services;

import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.models.User;


public class UserServicesImpl implements UserServices{
	
	private UserDAO ud;
	public UserServicesImpl(UserDAO ud) {
		this.ud=ud;
	}
	
		public User login(String username, String password) {
			User u=ud.getUser(username, password);
			return u;
		}
		
		public List<User> findAll() {
			// TODO Auto-generated method stub
			return ud.getAll();
		}

	}


