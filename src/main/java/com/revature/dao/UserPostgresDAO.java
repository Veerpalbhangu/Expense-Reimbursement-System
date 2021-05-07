package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class UserPostgresDAO implements UserDAO{
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();

	@Override
	public User getUser(String username, String password) throws UserNotFoundException{
		Connection conn=cf.getConnection();
		try {
		String sql="select * from ers_users where ers_username=? and ers_password=?;";
			PreparedStatement getUser=conn.prepareStatement(sql);
		getUser.setString(1, username);
		getUser.setString(2, password);
		
		ResultSet res=getUser.executeQuery();
		if(res.next()) {
			User user=new User();
			user.setUserID(res.getInt("ers_users_id"));
			user.setFirstName(res.getString("user_first_name"));
			user.setLastName(res.getString("user_last_name"));
			user.setPassword(res.getString("ers_password"));
			user.setRole(res.getInt("user_role_id"));
			user.setUsername(res.getString("ers_username"));
			user.setEmail(res.getString("user_email"));
			return user;
		}
		else {
			throw new UserNotFoundException("not found",404);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		Connection conn=cf.getConnection();
		List<User> allUsers=new ArrayList<>();
		try {
		String sql="select * from ers_users;";
		PreparedStatement getUser=conn.prepareStatement(sql);
		ResultSet res=getUser.executeQuery();
		
		while(res.next()) {
			User user=new User();
			user.setUserID(res.getInt("ers_users_id"));
			user.setFirstName(res.getString("user_first_name"));
			user.setLastName(res.getString("user_last_name"));
			user.setPassword(res.getString("ers_password"));
			user.setRole(res.getInt("user_role_id"));
			user.setUsername(res.getString("ers_username"));
			user.setEmail(res.getString("user_email"));
			allUsers.add(user);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allUsers;
	}

	
}
