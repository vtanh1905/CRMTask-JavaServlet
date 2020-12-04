package com.vtanh1905.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.vtanh1905.entity.User;
import com.vtanh1905.utils.PasswordHashing;

public class LoginService {
	
	private UserService userService;
	private PasswordHashing passwordHashing;
	
	public LoginService() {
		userService = new UserService();
		passwordHashing = new PasswordHashing();
	}

	public boolean login(String email, String password, HttpServletRequest req) {
		User user = userService.findByEmail(email);
		if(user == null) return false;
		if(!passwordHashing.compare(password, user.getPassword())) return false;
		
		HttpSession session = req.getSession();
		session.setAttribute("userLogin", user);
		return true;
	}
}
