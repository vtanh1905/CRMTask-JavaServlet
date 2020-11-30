package com.vtanh1905.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashing {
	public String hasing(String password) {
		final int SALT = 10;
		return BCrypt.hashpw(password, BCrypt.gensalt(SALT));
	}
	
	public boolean compare(String password, String hashed) {
		if (BCrypt.checkpw(password, hashed)) return true;
		return false;
	}
}
