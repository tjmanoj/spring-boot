package com.example.todo;

import java.util.ArrayList;

public interface TodoRepository {
    ArrayList<Todo> getTodos();
    Todo getTodoById(int id);
    Todo addTodo(Todo todo);
    void deleteTodo(int id);
    Todo updateTodo(int totoId,Todo todo);
}
