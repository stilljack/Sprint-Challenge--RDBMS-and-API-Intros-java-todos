package com.sauce.demo.controllers;


import com.sauce.demo.models.Todo;
import com.sauce.demo.models.User;
import com.sauce.demo.service.RoleService;
import com.sauce.demo.service.TodoService;
import com.sauce.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private TodoService todoService;
    @Autowired
    private RoleService roleService;




    ///Expose the following end points
    //
    //GET /users/users - return all of the users and their todos
    @GetMapping(value = "/users",
            produces = {"application/json"})
    public ResponseEntity<?> allUsers() {
        List<User> myUsers = userService.findAll();
        return new ResponseEntity<>(myUsers, HttpStatus.OK);
    }

    //GET /users/user/{userid} - return the user and their todos based off of id
    @GetMapping(value = "/user/{userid}",
            produces = {"application/json"})
    public ResponseEntity<?> findUserById(@PathVariable long userid)
    {
        User myUser = userService.findUserById(userid);
        return new ResponseEntity<>(myUser, HttpStatus.OK);

    }
    //
    //{
    //    "username": "hops",
    //    "password": "password",
    //    "primaryemail" : "hops@bunny.hop",
    //    "roles": [
    //    	{
    //    		"roleid": 2
    //    	},
    //    	{
    //    		"roleid": 3
    //        }
    //    ],
    //    "todos": [
    //        {
    //            "description": "Eat Carrots",
    //            "datestarted": "2019-08-16T01:44:18.089+0000"
    //        },
    //        {
    //            "description": "Bang on cage until everyone is awake",
    //            "datestarted": "2019-08-16T01:44:18.089+0000"
    //        }
    //    ]
    //}
    //POST /users/user - adds a user.
    @PostMapping(value = "/user",
            consumes = {"application/json"})
    public ResponseEntity<?> addNewUser(@Valid
                                              @RequestBody
                                                      User newUser) {
        newUser = userService.save(newUser);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userid}")
                .buildAndExpand(newUser.getUserid())
                .toUri();

        responseHeaders.setLocation(newUserURI);

        return new ResponseEntity<>(null,
                responseHeaders,
                HttpStatus.CREATED);
    }
    //POST /users/todo/{userid} - adds a todo to the user.
    //{
    //    "description": "Have Fun",
    //    "datestarted": "2019-01-01T01:00"
    //}

    @PostMapping(value = "/todo/{userid}", consumes = {"application/json"})
    public ResponseEntity<?> addTodoToUser(@Valid @RequestBody Todo newTodo, @PathVariable long userid) {
        newTodo = todoService.save(newTodo, userid);
        return new ResponseEntity<>(HttpStatus.OK);
    }




/*
    @PutMapping(value = "/todo/update/{todoid} ", consumes = {"application/json"})
    public ResponseEntity<?> updateTodo(@RequestBody Todo todo, @PathVariable long todoid) {
        Todo myTodo = new Todo();
            if(todoService.findTodoById(todoid)!=null){
                myTodo=todoService.findTodoById(todoid);
            }
        if (todo.getUser() != null)
        {
            myTodo.setUser(userService.findUserById(todo.getUser().getUserid()));
        }
        myTodo.setCompleted(todo.isCompleted());
        myTodo.setDatetime(todo.getDatetime());
        myTodo.setDescription(todo.getDescription());;

            todoService.update(todo,todoid);

        return new ResponseEntity<>(HttpStatus.OK);

    }*/

    @DeleteMapping(value = "/userid/{userid}")
    public ResponseEntity<?> deleteUser(@PathVariable long userid) {
        userService.delete(userid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}







