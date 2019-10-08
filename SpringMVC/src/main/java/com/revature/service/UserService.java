package com.revature.service;

import java.util.List;
import com.revature.model.User;
import com.revature.respository.UserRepositoryImpl;

public class UserService {
		// Gets all users
		public List<User> getAllUsers(){
			return new UserRepositoryImpl().getAllUsers();
		}
		
		// Inserts a new user
		public void insertUser(User u) {
			new UserRepositoryImpl().insertUser(u);
		}
		
		// Get by user id
		public User getUserById(int id) {
			return new UserRepositoryImpl().getUserById(id);
		}
		
		// Get user by first name
		public User getUserByName(String firstname) {
			return new UserRepositoryImpl().getUserByName(firstname);
		}
		
		// Update user information
		public void updateUser(User u) {
			new UserRepositoryImpl().updateUser(u);
		}
		
		// Delete user by user name
		public void deleteUser(String username) {
			new UserRepositoryImpl().deleteUser(username);
		}
}
