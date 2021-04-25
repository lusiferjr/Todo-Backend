package com.example.todo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.model.Resolution;
import com.example.todo.model.SubResolution;
import com.example.todo.repository.ResolutionRepository;
import com.example.todo.repository.SubResolutionRespository;
import com.example.todo.request.AddResolutionRequest;
import com.example.todo.request.AddSubResolutionRequest;
import com.example.todo.request.FetchResolutionRequest;
import com.example.todo.response.Response;
import com.example.todo.service.ResolutionService;

@Service
public class ResolutionServciceImpl implements ResolutionService{
	
	@Autowired
	ResolutionRepository resolutionRepository;
	
	@Override
	public Response addResolution(AddResolutionRequest request) {
		
		Resolution resolultion = new Resolution();
		Response response = new Response();
		
		resolultion.setResolution_text(request.getText());
		resolultion = resolutionRepository.save(resolultion);
		if (resolultion ==  null) {
			response.setError(true);
			response.setMessage("resolultion not Added");
			response.setResponse(null);
		}
		else {
			response.setError(false);
			response.setMessage("resolultion Added");
			response.setResponse(resolultion);
		}
		return response;
	}
	
	@Autowired
	SubResolutionRespository subResolutionRespository;
	public Response addSubResolution(AddSubResolutionRequest request) {
		SubResolution subResolutionn = new SubResolution();
		Response response = new Response();
		
		List<Resolution> resolution;
		resolution = resolutionRepository.fetchResolutionById(request.getResolutionId());
		if(resolution.size() > 0) {
			response.setError(true);
			response.setMessage("resolution not valid");
			response.setResponse(null);
		}
		else {
			subResolutionn.setSub_resolution_id(request.getResolutionId());
			subResolutionn = subResolutionRespository.save(subResolutionn);
			if (subResolutionn ==  null) {
				response.setError(true);
				response.setMessage("resolultion not Added");
				response.setResponse(null);
			}
			else {
				response.setError(false);
				response.setMessage("resolultion Added");
				response.setResponse(subResolutionn);
			}
		}
		
		return response;
	}
	
	
	@Override
	public Response fetchResolution(FetchResolutionRequest request) {
		
		Response response = new Response();
		
		List<Resolution> resolution;
		resolution = resolutionRepository.fetchResolutionById(request.getId());
		if (resolution.size() == 0) {
			response.setError(true);
			response.setMessage("resolution not found");
			response.setResponse(null);
		}
		else {
			response.setError(false);
			response.setMessage("resolution found");
			response.setResponse(resolution);
		}
		return response;
	}
}
