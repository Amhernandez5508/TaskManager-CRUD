package com.hernandezalejandro.taskmanagercrud.service;

import com.hernandezalejandro.taskmanagercrud.model.Task;
import com.hernandezalejandro.taskmanagercrud.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
        @Autowired
        TaskRepository taskRepository;
        
        
        public List<Task> getAllTasks() {
                return taskRepository.findAll();
        }
        
        
        public Task getTaskById(Long id) {
                return taskRepository.getReferenceById(id);
        }
        
        
        public void addTask(Task task) {
                
                taskRepository.save(task);
        }
        
        
        public void updTask(Task task) {

               taskRepository.save(task);
        }

        
        public void rmTask(Long id) {
                taskRepository.deleteById(id);
        }
}
