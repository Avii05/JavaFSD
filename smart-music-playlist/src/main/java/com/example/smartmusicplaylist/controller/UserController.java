package com.example.smartmusicplaylist.controller;

import com.example.smartmusicplaylist.model.User;
import com.example.smartmusicplaylist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping
	public User registerUser(@RequestBody User user){
		return userService.registerUser(user);
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id) {
		return userService.getUser(id);
	}
}
