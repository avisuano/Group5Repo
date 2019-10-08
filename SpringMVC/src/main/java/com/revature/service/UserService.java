package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.User;
import com.revature.respository.UserRepository;

@Service("userService")
public class UserService {
	
		@Autowired
		UserRepository userRepository;
		// Gets all users
		public List<User> getAllUsers(){
			return userRepository.getAllUsers();
		}
		
		// Inserts a new user
		public void insertUser(User u) {
			userRepository.insertUser(u);
		}
		
		// Get by user id
		public User getUserById(int id) {
			return userRepository.getUserById(id);
		}
		
		// Get user by first name
		public User getUserByName(String firstname) {
			return userRepository.getUserByName(firstname);
		}
		
		// Update user information
		public void updateUser(User u) {
			userRepository.updateUser(u);
		}
		
		// Delete user by user name
		public void deleteUser(String username) {
			userRepository.deleteUser(username);
		}
}
