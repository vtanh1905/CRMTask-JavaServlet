package com.vtanh1905.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vtanh1905.dto.UserRoleDto;
import com.vtanh1905.entity.User;
import com.vtanh1905.repository.UserRepository;
import com.vtanh1905.utils.JDBCConnection;
import com.vtanh1905.utils.PasswordHashing;

public class UserService {
	
	private UserRepository userRepository;
	private PasswordHashing passwordHashing;
	
	public UserService() {
		userRepository = new UserRepository();
		passwordHashing = new PasswordHashing();
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public List<UserRoleDto> findAllWithRole() {
		return userRepository.findAllWithRole();
	}

	public User findById(int userId) {
		return userRepository.findById(userId);
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public int save(User user) {
		User checkEmailExist = userRepository.findByEmail(user.getEmail());
		if(checkEmailExist != null) return -1;
		
		user.setPassword(passwordHashing.hasing(user.getPassword()));
		return userRepository.save(user);
	}

	public int update(User user, boolean changePassword) {
		User checkEmailExist = userRepository.findByEmail(user.getEmail());
		if(checkEmailExist != null && checkEmailExist.getId() != user.getId()) return -1;
		
		if(changePassword) {
			user.setPassword(passwordHashing.hasing(user.getPassword()));
		}
		
		return userRepository.update(user);
	}

	public int delete(int userId) {
		return userRepository.delete(userId);
	}
}
