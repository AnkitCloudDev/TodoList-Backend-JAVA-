package com.example.restfulwebservices.services;

import com.example.restfulwebservices.beans.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();
    private static int idCounter = 0;

    static {
        todos.add(new Todo(++idCounter,"Learn to Dance","Ankit",new Date(),false));
        todos.add(new Todo(++idCounter,"Learn Angular","Ankit",new Date(),false));
        todos.add(new Todo(++idCounter,"Learn Guitar","Ankit",new Date(),false));
        todos.add(new Todo(++idCounter,"Learn to be Happy","Ankit",new Date(),false));

    }

    public List<Todo> findAll(){
        return todos;
    }

    public Todo deleteById(long id){
        Todo todo = findById(id);
        if(todo == null)
            return null;

//On Successful deletion return the object otherwise return null
        if(todos.remove(todo)) {
            return todo;
        }

        return null;

    }

//    To find a task in the list by ID
    public Todo findById(long id) {
        for(Todo todo: todos)
        {
            if(todo.getId()==id)
            {
                return todo;
            }
        }
        return null;

    }

/* Function to add todos to list of todos
*  @Params: a todo object
*  @Return: returns a todo object
* */
    public Todo save(Todo todo)
    {
        if(todo.getId() == -1)
        {
            todo.setId(++idCounter);
            todos.add(todo);
        }
        else
        {
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }


}
