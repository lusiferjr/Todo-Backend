package com.example.todo.serviceImpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import com.example.todo.request.AddTodoRequest;
import com.example.todo.request.DeleteTodoRequest;
import com.example.todo.request.FetchTodoByUsernameRequest;
import com.example.todo.request.UpdateTodoRequest;
import com.example.todo.response.Response;
import com.example.todo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService{

	@Autowired
	TodoRepository todoRepository;
	
	@Override
	public Response addTodo(AddTodoRequest request) {
		
		Todo todo = new Todo();
		Response response = new Response();
		
		todo.setUsername(request.getUsername());
		todo.setTitle(request.getTitle());
		todo.setDescription(request.getDescription());
		todo.setStatus(request.getStatus());
		todo.setTargetDate(request.getTargetDate());
		
		todo = todoRepository.save(todo);
		if (todo ==  null) {
			response.setError(true);
			response.setMessage("Todo not Added");
			response.setResponse(null);
		}
		else {
			response.setError(false);
			response.setMessage("Todo Added");
			response.setResponse(todo);
		}
		
		return response;
	}

	@Override
	public Response fetchTodoByUsername(FetchTodoByUsernameRequest user) {
		
		Response response = new Response();
		List<Todo> todo;
		todo = todoRepository.fetchTodoByUsername(user.getUsername());
		if(todo == null) {
			response.setError(true);
			response.setMessage("No todos found");
			response.setResponse(null);
		}
		else {
			response.setError(false);
			response.setMessage("Todos found");
			response.setResponse(todo);
		}
		return response;
	}

	@Override
	public Response updateTodo(UpdateTodoRequest request) {
		
		Response response = new Response();
		Todo todo = new Todo();
		
		Long id = request.getId();
		todo.setId(id);
		todo.setUsername(request.getUsername());
		todo.setTitle(request.getTitle());
		todo.setDescription(request.getDescription());
		todo.setStatus(request.getStatus());
		todo.setTargetDate(request.getTargetDate());
		
		try{
			todoRepository.updateTodo(request.getTitle(), request.getDescription(), request.getStatus(), request.getTargetDate(), id);
		}catch(Exception e) {
			System.out.println(e);
			response.setError(true);
			response.setMessage("Unable to update todo.");
		
			return response;
		}
		
		response.setError(false);
		response.setMessage("Todo Updated");
		response.setResponse(todoRepository.fetchTodoByUsername(request.getUsername()));
		
		return response;
	}

	@Override
	public Response deleteTodo(DeleteTodoRequest request) {
		
		Response response = new Response();
		Long id = request.getId();
		
		try{
			todoRepository.deleteTodo(id);
		}catch(Exception e) {
			response.setError(true);
			response.setMessage("Unable to Delete todo.");
		
			return response;
		}
		
		response.setError(false);
		response.setMessage("Todo Deleted");
		response.setResponse(todoRepository.fetchTodoByUsername(request.getUsername()));
		
		return response;
	}
	
}
