package com.revature.models;

public class User {
	
	private int userID;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private int role;
	private String email;
	public User() {};
public User(String firstName, String lastName, String username, String password, String email, int role) {
	this.firstName=firstName;
	this.lastName=lastName;
	this.username=username;
	this.password=password;
	this.email=email;
	this.role=role;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getUserID() {
	return userID;
}
public void setUserID(int userID) {
	this.userID = userID;
}
public int getRole() {
	return role;
}
public void setRole(int role) {
	this.role = role;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
