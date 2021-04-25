package com.example.todo.request;

public class AddSubResolutionRequest {

	
	private String text;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Long getResolutionId() {
		return resolutionId;
	}
	public void setResolutionId(Long resolutionId) {
		this.resolutionId = resolutionId;
	}
	private Long resolutionId;
	
	
}
