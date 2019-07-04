package com.example.demo.services.contracts;

import com.example.demo.requests.CreateToDoRequest;
import com.example.demo.responses.ToDoResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface TodoService {
    ToDoResponse createToDo(CreateToDoRequest createToDoRequest) throws  Exception;
    ToDoResponse getTodo(UUID id) throws Exception;
    ToDoResponse updateTodo(UUID id, CreateToDoRequest updateTodoRequest) throws  Exception;
    List<ToDoResponse> getTodos();
    void deleteTodo(UUID id) throws  Exception;
}
