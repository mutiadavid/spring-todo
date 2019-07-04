package com.example.demo.services;

import com.example.demo.data.Todo;
import com.example.demo.repositories.TodoRepository;
import com.example.demo.requests.CreateToDoRequest;
import com.example.demo.responses.ToDoResponse;
import com.example.demo.services.contracts.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private  TodoRepository todoRepository;


    @Override
    public ToDoResponse createToDo(CreateToDoRequest createToDoRequest) throws  Exception{
        if (createToDoRequest != null){
            Todo todo = new Todo();
            todo.setDate(createToDoRequest.getDate());
            todo.setName(createToDoRequest.getName());
            todo.setDescription(createToDoRequest.getDescription());

            Todo result = todoRepository.save(todo);

            ToDoResponse response = new ToDoResponse();
            response.setId(result.getId());
            response.setDate(result.getDate());
            response.setName(result.getName());
            response.setDescription(result.getDescription());

            return response;
        }

        throw new Exception("CreateToDoRequest is null!");
    }

    @Override
    public ToDoResponse getTodo(UUID id) throws  Exception {
        Optional<Todo> todo = todoRepository.findById(id);

        if(todo.isPresent()){
            ToDoResponse response = new ToDoResponse();
            Todo t = todo.get();
            response.setId(t.getId());
            response.setDate(t.getDate());
            response.setDescription(t.getDescription());
            response.setName(t.getName());

            return  response;
        }

        throw  new Exception("Todo by Id: "+id.toString() +" Not Found");
    }

    @Override
    public ToDoResponse updateTodo(UUID id, CreateToDoRequest updateTodoRequest) throws  Exception{
        Optional<Todo> todo = todoRepository.findById(id);
        if(!todo.isPresent())
            throw new Exception("Todo by Id: "+id.toString() +" Not Found");

        Todo todoUpdate = todo.get();
        todoUpdate.setDescription(updateTodoRequest.getDescription());
        todoUpdate.setName(updateTodoRequest.getName());
        todoUpdate.setDate(updateTodoRequest.getDate());

        Todo updatedTodo = todoRepository.save(todoUpdate);
        ToDoResponse response = new ToDoResponse();
        response.setId(updatedTodo.getId());
        response.setDescription(updatedTodo.getDescription());
        response.setName(updatedTodo.getName());
        response.setDate(updatedTodo.getDate());

        return response;

    }

    @Override
    public List<ToDoResponse> getTodos() {
        List<ToDoResponse> toDoResponseList = new ArrayList<>();

        Iterable<Todo> todos = todoRepository.findAll();

        todos.forEach(todo -> {
            ToDoResponse response = new ToDoResponse();
            response.setDate(todo.getDate());
            response.setName(todo.getName());
            response.setDescription(todo.getDescription());
            response.setId(todo.getId());

            toDoResponseList.add(response);
        });

        return toDoResponseList;
    }

    @Override
    public void deleteTodo(UUID id) throws  Exception{
        Optional<Todo> todo = todoRepository.findById(id);
        if(!todo.isPresent())
            throw new Exception("Todo by Id: "+id.toString() +" Not Found");

        todoRepository.delete(todo.get());
    }
}
