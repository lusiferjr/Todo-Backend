package com.example.todo.service;

import org.springframework.stereotype.Service;

import com.example.todo.request.AddUserRequest;
import com.example.todo.request.LoginRequest;
import com.example.todo.response.Response;

@Service
public interface UserService {

	Response addUser(AddUserRequest user);

	Response login(LoginRequest credentials);
	
}
