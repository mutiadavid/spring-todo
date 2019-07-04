package com.example.demo.repositories;

import com.example.demo.data.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TodoRepository extends CrudRepository<Todo, UUID> {
}
