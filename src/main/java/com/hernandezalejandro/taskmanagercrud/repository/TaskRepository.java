package com.hernandezalejandro.taskmanagercrud.repository;

import com.hernandezalejandro.taskmanagercrud.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long> {

}
