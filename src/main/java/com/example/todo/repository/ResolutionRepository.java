package com.example.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.todo.model.Resolution;



@Repository
public interface ResolutionRepository extends JpaRepository<Resolution,Long>{

	@Query(value="Select * from resolution where resolution_id = :id",nativeQuery = true)
	List<Resolution> fetchResolutionById(Long id);
}
