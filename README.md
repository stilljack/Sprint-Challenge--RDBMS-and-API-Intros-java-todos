# java-todos

A student that completes this project shows that they can
* perform CRUD operations on an RDBMS using JPA and Hibernate.
* implement a data seeding class using JPA and Hibernate
* use JPA and Hibernate to perform advanced query operations on a RDBMS.
* add relationships between tables.

Specifically
* Seed Data
* CRUD Operations
* H2 Connections


## Introduction

This is a basic todo database scheme with users and a todo list.

## Instructions

Create a REST api com.sauce.demo.service to store and read data from H2 database. 
* com.sauce.demo.SeedData.java is a sample script that can be modified to populate the database 
* note that all new todos default to completed = false;

The table layouts are as follows:

* Note these are the minimum fields required. More is okay.

* TODOS
  * todoid primary key, not null long
  * description string, not null
  * datestarted datetime
  * completed boolean
  * userid foreign key (one user to many todos) not null 

* USERS
  * userid primary key, not null long
  * username string, not null unique
  * primaryemail string, not null unique
  * password string, not null. This will be stored in plain text for now.

* ROLES
  * roleid primary key, not null long
  * rolename string not null unique

* Notes:
  * USERS have a many to many relationship with ROLES. This should be done through a join table called USERROLES
  * USERS have a one to many relationship with TODOS.

Expose the following end points

* GET /users/users - return all of the users and their todos

* GET /users/user/{userid} - return the user and their todos based off of id

* POST /users/user - adds a user.
```
{
    "username": "hops",
    "password": "password",
    "primaryemail" : "hops@bunny.hop",
    "roles": [
    	{
    		"roleid": 2
    	},
    	{
    		"roleid": 3
        }
    ],
    "todos": [
        {
            "description": "Eat Carrots",
            "datestarted": "2019-08-16T01:44:18.089+0000"
        },
        {
            "description": "Bang on cage until everyone is awake",
            "datestarted": "2019-08-16T01:44:18.089+0000"
        }
    ]
}
```

* POST /users/todo/{userid} - adds a todo to the user.
```
{
    "description": "Have Fun",
    "datestarted": "2019-01-01T01:00"
}
```

* PUT /todos/todo/{todoid} - updates a todo based on todoid. Note: null boolean is not a thing so adjust accordingly.

  * Hint: to change the user of the todo through this endpoint, try using code like this:
```
        if (todo.getUser() != null)
        {
            newTodo.setUser(userService.findUserById(todo.getUser().getUserid()));
        }
```

  * You can use the following as test data.
```
{
    "completed": true
}
```

* DELETE /users/userid/{userid} - Deletes a user based off of their userid and deletes all their associated todos.



## Stretch goals

* Update the endpoints below:

  * GET /users/user/{userid}/todos - returns in datestarted order all of the todos that have not yet been completed for the user with the given id. In orders, what does this user still need to do?
  
  * Add in 100 more random users each with a random number of random todos.
  
