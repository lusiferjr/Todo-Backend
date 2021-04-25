package com.example.todo.response;

public class Response {
	
	private String message;
	private boolean error;
	private Object response;
	

	public Response() {
		super();
		this.message = "Default message";
		this.error = true;
		this.response = null;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	
	
}
