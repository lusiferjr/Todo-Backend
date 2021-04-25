package com.example.todo.service;

import org.springframework.stereotype.Service;

import com.example.todo.request.AddResolutionRequest;
import com.example.todo.request.AddSubResolutionRequest;
import com.example.todo.request.FetchResolutionRequest;
import com.example.todo.response.Response;

@Service
public interface ResolutionService {

	Response addResolution(AddResolutionRequest resolution);
	
	Response addSubResolution(AddSubResolutionRequest subResolution);
	
	Response fetchResolution(FetchResolutionRequest resolution);
	
}
