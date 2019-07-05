package com.example.demo.controllers;

import com.example.demo.requests.CreateToDoRequest;
import com.example.demo.responses.ResponseClass;
import com.example.demo.responses.ToDoResponse;
import com.example.demo.services.TodoService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "api/todo")
@RestController
public class TodoController {


    private final TodoService todoService;
    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseClass createToDo(@RequestBody CreateToDoRequest createToDoRequest){
       ResponseClass responseClass=new ResponseClass();
        try {
            ToDoResponse response =  todoService.createToDo(createToDoRequest);
            responseClass.setResponseData(response);
            return responseClass;
        } catch (Exception e) {
            responseClass.setInternalServerError(e);
              return responseClass;
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseClass getTodo(@PathVariable UUID id) throws Exception {
           ResponseClass responseClass=new ResponseClass();
        try {
            ToDoResponse todo = todoService.getTodo(id);
            responseClass.setResponseData(todo);
            return  responseClass;
        }
        catch (Exception ex){
            responseClass.setInternalServerError(ex);
            return  responseClass;
        }
    }

    @GetMapping()
    public ResponseClass getTodos() throws Exception {
          ResponseClass responseClass=new ResponseClass();
        try {
            List<ToDoResponse> todo = todoService.getTodos();
               responseClass.setResponseData(todo);
            return  responseClass;
        }
        catch (Exception ex){
            responseClass.setInternalServerError(ex);
            return  responseClass;
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseClass deleteTodo(@PathVariable UUID id) throws Exception {
           ResponseClass responseClass=new ResponseClass();
        try {
            todoService.deleteTodo(id);
            responseClass.setResponseData("");
            return  responseClass;
        }
        catch (Exception ex){
            responseClass.setInternalServerError(ex);
            return  responseClass;
        }
    }
    @PutMapping(value = "/{id}")
    public ResponseClass updateTodo(@PathVariable UUID id, @RequestBody CreateToDoRequest toDoRequest) throws Exception {
           ResponseClass responseClass=new ResponseClass();
        try {
            ToDoResponse todo = todoService.updateTodo(id,toDoRequest);
            responseClass.setResponseData(todo);
            return  responseClass;
        }
        catch (Exception ex){
            responseClass.setInternalServerError(ex);
            return  responseClass;
        }
    }
}
