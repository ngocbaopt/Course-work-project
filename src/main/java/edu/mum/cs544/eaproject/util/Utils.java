package edu.mum.cs544.eaproject.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.mum.cs544.eaproject.domain.Users;

public class Utils {

	public static Users encodePassword(Users user) {
		String password = user.getPassword();
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		user.setPassword(hashedPassword);
		return user;
	}
}
