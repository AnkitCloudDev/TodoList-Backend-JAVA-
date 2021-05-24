package com.example.restfulwebservices.controllers;

import com.example.restfulwebservices.beans.Todo;
import com.example.restfulwebservices.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable  String username){
    return todoService.findAll();
    }

    @DeleteMapping("/users/{username}/todos/{todoid}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long todoId)
    {
               Todo todo = todoService.deleteById(todoId);

               if(todo != null)
               {
                   return ResponseEntity.noContent().build();
               }
               return ResponseEntity.notFound().build();
    }


}
