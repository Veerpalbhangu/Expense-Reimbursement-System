package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.dao.UserPostgresDAO;
import com.revature.models.Credentials;
import com.revature.models.User;
import com.revature.services.UserServices;
import com.revature.services.UserServicesImpl;
import com.fasterxml.jackson.databind.ObjectMapper;


public class UserController {
	
		private UserServices us = new UserServicesImpl(new UserPostgresDAO());
		
		private ObjectMapper om=new ObjectMapper();
		
		public UserController() {
			super();
		}
		
		public void userLogin(HttpServletRequest req, HttpServletResponse res) throws IOException{ 
			Credentials cred=om.readValue(req.getInputStream(), Credentials.class);
			User u=us.login(cred.getUsername(), cred.getPassword());
			
			if(u!=null) {
				System.out.println("user find");
			}
			res.setStatus(200);
			res.getWriter().write(om.writeValueAsString(u));
		}
		
		public void findAllUsers(HttpServletRequest req, HttpServletResponse res) throws IOException {

			List<User> allusers = us.findAll();
			res.setStatus(200);
			res.getWriter().write(om.writeValueAsString(allusers));
			
		}

}
