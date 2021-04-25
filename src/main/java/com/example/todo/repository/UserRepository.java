package com.example.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.todo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

	@Query(value="Select * from users where username = :username and password = :password",nativeQuery = true)
	User login(String username, String password);
	
}
