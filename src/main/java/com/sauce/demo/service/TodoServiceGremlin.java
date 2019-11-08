package com.sauce.demo.service;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service(value = "todoService")
public class TodoServiceGremlin  implements  TodoService{
}
