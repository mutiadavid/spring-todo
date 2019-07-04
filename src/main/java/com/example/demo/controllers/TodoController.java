package com.example.demo.controllers;

import com.example.demo.requests.CreateToDoRequest;
import com.example.demo.responses.ToDoResponse;
import com.example.demo.services.contracts.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping(path = "api/todo")
@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity createToDo(@RequestBody CreateToDoRequest createToDoRequest){
        try {
            ToDoResponse response =  todoService.createToDo(createToDoRequest);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return  ResponseEntity.status(500).build();
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getTodo(@PathVariable UUID id) throws Exception {
        try {
            ToDoResponse todo = todoService.getTodo(id);
            return  ResponseEntity.ok(todo);
        }
        catch (Exception ex){
            throw ex;
        }
    }

    @GetMapping()
    public ResponseEntity getTodos() throws Exception {
        try {
            List<ToDoResponse> todo = todoService.getTodos();
            return  ResponseEntity.ok(todo);
        }
        catch (Exception ex){
            throw ex;
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteTodo(@PathVariable UUID id) throws Exception {
        try {
            todoService.deleteTodo(id);
            return  ResponseEntity.ok().build();
        }
        catch (Exception ex){
            throw ex;
        }
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity updateTodo(@PathVariable UUID id, @RequestBody CreateToDoRequest toDoRequest) throws Exception {
        try {
            ToDoResponse todo = todoService.updateTodo(id,toDoRequest);
            return  ResponseEntity.ok(todo);
        }
        catch (Exception ex){
            throw ex;
        }
    }
}
