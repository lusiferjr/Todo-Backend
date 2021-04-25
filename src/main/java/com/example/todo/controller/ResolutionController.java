package com.example.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.request.AddResolutionRequest;
import com.example.todo.request.AddSubResolutionRequest;
import com.example.todo.request.FetchResolutionRequest;
import com.example.todo.response.Response;
import com.example.todo.service.ResolutionService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ResolutionController {

	@Autowired
	ResolutionService resolutionService;
	
	@PostMapping(path = "/addResolution")
	public Response addResolution(@RequestBody AddResolutionRequest resolution) {
		return resolutionService.addResolution(resolution);
	}
	
	@PostMapping(path = "/fetchResolution")
	public Response fetchResolution(@RequestBody FetchResolutionRequest resolution) {
		return resolutionService.fetchResolution(resolution);
	}
	
	@PostMapping(path = "/addSubResolution")
	public Response addSubResolution(@RequestBody AddSubResolutionRequest subResolution) {
		return resolutionService.addSubResolution(subResolution);
	}
	
}
