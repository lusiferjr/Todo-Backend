package com.example.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.request.AddTodoRequest;
import com.example.todo.request.DeleteTodoRequest;
import com.example.todo.request.FetchTodoByUsernameRequest;
import com.example.todo.request.UpdateTodoRequest;
import com.example.todo.response.Response;
import com.example.todo.service.TodoService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

	@Autowired
	TodoService todoService;
	
	@PostMapping(path = "/addTodo")
	public Response addTodo(@RequestBody AddTodoRequest todo) {
		return todoService.addTodo(todo);
	}
	
	@PostMapping(path = "/fetchTodoByUsername")
	public Response fetchTodoByUsername(@RequestBody FetchTodoByUsernameRequest user) {
		return todoService.fetchTodoByUsername(user);
	}
	
	@PutMapping(path = "/updateTodo")
	public Response updateTodo(@RequestBody UpdateTodoRequest todo) {
		return todoService.updateTodo(todo);
	}
	
	@DeleteMapping(path = "/deleteTodo")
	public Response deleteTodo(@RequestBody DeleteTodoRequest todo) {
		return todoService.deleteTodo(todo);
	}
}
