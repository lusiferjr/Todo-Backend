package com.example.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.model.Resolution;
import com.example.todo.model.SubResolution;

@Repository
public interface SubResolutionRespository extends JpaRepository<SubResolution,Long>{

}
