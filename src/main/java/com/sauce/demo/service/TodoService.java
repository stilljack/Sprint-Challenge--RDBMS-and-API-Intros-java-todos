package com.sauce.demo.service;

import com.sauce.demo.models.Todo;

public interface TodoService {
    Todo findTodoById(long id);

    Todo save(Todo todo, long userid);

    Todo update(Todo todo, long todoid);
}
