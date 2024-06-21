package com.sauce.demo.controllers;

import com.sauce.demo.models.Todo;
import com.sauce.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    //PUT /todos/todo/{todoid} - updates a todo based on todoid. Note: null boolean is not a thing so adjust accordingly.
    //
    //Hint: to change the user of the todo through this endpoint, try using code like this:
    //        if (todo.getUser() != null)
    //        {
    //            newTodo.setUser(userService.findUserById(todo.getUser().getUserid()));
    //        }
    //You can use the following as test data.
    //{
    //    "completed": true
    //}
    @PutMapping( value = "/todo/{todoid}", consumes = {"application/json"})
    public ResponseEntity<?> updateTodo(@RequestBody Todo updateTodo, @PathVariable long todoid) {
        todoService.update(updateTodo, todoid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
