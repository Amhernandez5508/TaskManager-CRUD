package com.hernandezalejandro.taskmanagercrud.restcontroller;

import com.hernandezalejandro.taskmanagercrud.model.Task;
import com.hernandezalejandro.taskmanagercrud.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
public class TaskRestController {
        
        @Autowired
        TaskService taskService;
        
        
        // Devuelve todas las tareas.
        @GetMapping(value = "/")
        @Operation(summary = "Lista completa de tareas", description = "Devuelve la lista entera de tareas en formato JSON.")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "OK"),
                @ApiResponse(responseCode = "404", description = "Not found")})
        public @ResponseBody List<Task> getAllTasks() {
                
                return taskService.getAllTasks();
        }
        
        
        // Devuelve una tarea según ID.
        @GetMapping(value = "/{id}")
        @Operation(summary = "Obtener tarea por ID", description = "Devuelve una tarea por ID en formato JSON.")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "OK"),
                @ApiResponse(responseCode = "404", description = "Not found")})
        public @ResponseBody Task getTaskById(@PathVariable(value = "id") Long id) {
                
                return taskService.getTaskById(id);
        }
        
        
        // Agrega una tarea.
        @PostMapping(value = "/", produces = "applicattion/JSON")
        @Operation(summary = "Agregar tarea", description = "Agrega una tarea a la base de datos.")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "201", description = "Created"),
                @ApiResponse(responseCode = "409", description = "Conflict")})
        public @ResponseBody void addTask(@RequestBody Task task) {
                
                taskService.addTask(task);
        }
        

        // Actualiza una tarea segun su ID.
        @PutMapping(value = "/")
        @Operation(summary = "Actualizar tarea", description = "Actualiza una tarea en la base de datos.")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "201", description = "Created"),
                @ApiResponse(responseCode = "409", description = "Conflict")})
        public @ResponseBody void updTask(@RequestBody Task task) {

                taskService.updTask(task);
        }


        // Elimina una tarea segun su ID.
        @DeleteMapping(value = "/{id}")
        @Operation(summary = "Eliminar una tarea por ID", description = "Elimina una tarea de la base de datos segun su ID.")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "OK"),
                @ApiResponse(responseCode = "404", description = "Not Found")})
        public @ResponseBody void rmTask(Long id) {
                taskService.rmTask(id);
        }
}