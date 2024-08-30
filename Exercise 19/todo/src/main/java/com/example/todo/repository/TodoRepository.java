package com.example.todo.repository;

import com.example.todo.model.Todo;
import java.util.*;

public interface TodoRepository {
    ArrayList<Todo> getTodos();

    Todo getTodoById(int id);

    Todo addTodo(Todo todo);

    void deleteTodo(int id);

    Todo updateTodo(int totoId, Todo todo);
}