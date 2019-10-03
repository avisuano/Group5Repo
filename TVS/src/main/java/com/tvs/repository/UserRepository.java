package com.tvs.repository;

import java.util.List;
import com.tvs.model.User;

public interface UserRepository {
	public List<User> getAllUsers(); //Get all users
	void insertUser(User u); //Insert new user
	User getUserById(int id); //Get user by ID
	User getUserByName(String firstname); //Get user by first name
	void updateUser(User u); //Update user information
	void deleteUser(String username); //Delete user information
}