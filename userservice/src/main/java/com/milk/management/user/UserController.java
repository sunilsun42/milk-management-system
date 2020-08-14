package com.milk.management.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service()
@Scope()

public class UserController {
	@Autowired
	UserService userService;

	@GetMapping()
	public User getUser(@PathVariable(name = "id") long id) {
		User user = new User();
		user.setId(id);
		return userService.getUserById(user);
	}

	@PostMapping("/create")
	public User createUser(@RequestBody User user) {

		return userService.create(user);

	}
}
