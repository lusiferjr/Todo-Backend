package com.example.todo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.todo.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long>{

	@Query(value="Select * from todos where username = :name",nativeQuery = true)
	List<Todo> fetchTodoByUsername(String name);
	
	@Modifying
	@Transactional
	@Query(value = "Update todos set title = :title, description = :description, status = :status, target_date = :targetDate where id = :id", nativeQuery = true)
	int updateTodo(String title, String description, String status, String targetDate, Long id);
	
	@Modifying
	@Transactional
	@Query(value = "Delete from todos where id = :id", nativeQuery = true)
	int deleteTodo(Long id);
	
}
