package com.revature.dao;

import java.util.List;

import com.revature.models.User;

public interface UserDAO {
public User getUser(String username, String password);
public List<User> getAll();
}

