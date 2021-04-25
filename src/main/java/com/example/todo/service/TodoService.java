package com.example.todo.service;

import org.springframework.stereotype.Service;

import com.example.todo.request.AddTodoRequest;
import com.example.todo.request.DeleteTodoRequest;
import com.example.todo.request.FetchTodoByUsernameRequest;
import com.example.todo.request.UpdateTodoRequest;
import com.example.todo.response.Response;

@Service
public interface TodoService {
	
	Response addTodo(AddTodoRequest todo);
	
	Response fetchTodoByUsername(FetchTodoByUsernameRequest user);
	
	Response updateTodo(UpdateTodoRequest todo);
	
	Response deleteTodo(DeleteTodoRequest todo);
	
}
