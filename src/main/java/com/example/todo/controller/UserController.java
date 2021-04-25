package com.example.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.request.AddUserRequest;
import com.example.todo.request.LoginRequest;
import com.example.todo.response.Response;
import com.example.todo.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping(path="/addUser")
	public Response addUser(@RequestBody AddUserRequest user) {
		return userService.addUser(user);
	}
	
	@PostMapping(path = "/login")
	public Response login(@RequestBody LoginRequest credentials) {
		return userService.login(credentials);
	}
	
}
