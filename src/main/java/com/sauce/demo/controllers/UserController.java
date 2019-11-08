package com.sauce.demo.controllers;


import com.sauce.demo.models.User;
import com.sauce.demo.service.RoleService;
import com.sauce.demo.service.TodoService;
import com.sauce.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> allUsers()
    {
        List<User> myUsers = userService.findAll();
        return new ResponseEntity<>(myUsers, HttpStatus.OK);

    }
    //
    //GET /users/user/{userid} - return the user and their todos based off of id
    @GetMapping(value = "/user/{userid}",
            produces = {"application/json"})
    public ResponseEntity<?> findUserById(@PathVariable long userid)
    {
        User myUser = userService.findUserById(userid);
        return new ResponseEntity<>(myUser, HttpStatus.OK);

    }





    //
    //POST /users/user - adds a user.
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





    //POST /users/todo/{userid} - adds a todo to the user.
    //{
    //    "description": "Have Fun",
    //    "datestarted": "2019-01-01T01:00"
    //}
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
    //DELETE /users/userid/{userid} - Deletes a user based off of their userid and deletes all their associated todos.









}
