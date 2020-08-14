package com.milk.management.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Transactional(rollbackForClassName = "Throwable")
public class UserService {
	@Autowired
	UserRepository userRepo;
	

	public void delete(User user) {
		userRepo.delete(user);
	}

	public void update(User user) {
		userRepo.save(user);
	}

	public User create(User user) {
		user.setPassword(encoder().encode(user.getPassword()));
		return userRepo.save(user);
	}
	
	@GetMapping("/find/{email}")
	public User getUser(@PathVariable(name="email") String mailId) {
		System.err.print("Retriving ----");
		return userRepo.findUserByMailId(mailId);
	}
	
	public User getUserById(User user) {
		return userRepo.findUserById(user.getId());
	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
		return encoder;
	}
}
