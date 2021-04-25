package com.example.todo.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.model.User;
import com.example.todo.repository.UserRepository;
import com.example.todo.request.AddUserRequest;
import com.example.todo.request.LoginRequest;
import com.example.todo.response.Response;
import com.example.todo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public Response addUser(AddUserRequest request) {
		
		User user = new User();
		Response response = new Response();
		
		Date currentDate = new Date( );
	    SimpleDateFormat ft = new SimpleDateFormat ("E dd.MM.yyyy 'at' hh:mm:ss a zzz");
		
		user.setUsername(request.getUsername());
		user.setPassword(request.getPassword());
		user.setFullname(request.getFullname());
		user.setEmail(request.getEmail());
		user.setAccountCreationDate(ft.format(currentDate));
		
		user = userRepository.save(user);
		if (user == null) {
			response.setError(true);
			response.setMessage("User Not Added");
			response.setResponse(null);
		}
		else {
			response.setError(false);
			response.setMessage("User Added Successfully");
			response.setResponse(user);
		}
		
		return response;
	}

	@Override
	public Response login(LoginRequest request) {
		
		Response response = new Response();
		User user = new User();
		
		user = userRepository.login(request.getUsername(), request.getPassword());
		if(user == null) {
			response.setError(true);
			response.setMessage("Invalid Credentials");
			response.setResponse(null);
		}
		else {
			response.setError(false);
			response.setMessage("Login Successfully");
			response.setResponse(user);
		}
		
		return response;
	}
	
}
