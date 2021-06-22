package com.example.restfulwebservices.controllers;

import com.example.restfulwebservices.beans.Todo;
import com.example.restfulwebservices.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@CrossOrigin("http://localhost:4200")
public class TodoController {
    private static final Logger logger= LoggerFactory.getLogger(TodoController.class);

    @Autowired
    private TodoService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable  String username){
    return todoService.findAll();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id)
    {
        return todoService.findById(id);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id)
    {
               Todo todo = todoService.deleteById(id);

               if(todo != null)
               {
                   return ResponseEntity.noContent().build();
               }
               return ResponseEntity.notFound().build();
    }


    /* Create a New Todo
    * @PathVariables: username
    * @RequestBody: todo
    *  Returns the URI of the created  object
    * */
    @PostMapping("/users/{username}/todos")
public ResponseEntity<Void> createTodo(@PathVariable String username,
                                       @RequestBody Todo todo){
//        android.util.Log.i(TAG, "createTodo: ");
        logger.info("createTodo Function was Called");
    Todo newTodo = todoService.save(todo);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newTodo.getId())
                .toUri();
    return ResponseEntity.created(uri).build();
}

//    Update a todo object
    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username,
                                           @PathVariable long id,
                                           @RequestBody Todo todo){
        Todo updatedTodo = todoService.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.ACCEPTED);
    }


}
