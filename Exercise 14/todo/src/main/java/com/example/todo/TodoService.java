package com.example.todo;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class TodoService implements TodoRepository{
    private static HashMap<Integer, Todo> todoList = new HashMap<>();
    private int uniqueTodo = 6;
    public TodoService() {
        todoList.put(1, new Todo(1, "Watch Movie", "LOW", "TO DO"));
        todoList.put(2, new Todo(2, "Finish Project", "HIGH", "IN PROGRESS"));
        todoList.put(3, new Todo(3, "Buy Groceries", "MEDIUM", "TO DO"));
        todoList.put(4, new Todo(4, "Learning from NxtWave", "HIGH", "IN PROGRESS"));
        todoList.put(5, new Todo(5, "Go for a Run", "MEDIUM", "DONE"));

    }

    @Override
    public ArrayList<Todo> getTodos() {
        Collection<Todo> todos = todoList.values();
        return new ArrayList<>(todos);
    }

    @Override
    public Todo getTodoById(int id) {
        if(todoList.get(id) == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return todoList.get(id);
    }

    @Override
    public Todo addTodo(Todo todo) {
        todo.setId(uniqueTodo++);
        todoList.put(todo.getId(), todo);
        return todo;
    }

    @Override
    public Todo updateTodo(int todoId,Todo todo) {
        Todo oldTodo = todoList.get(todoId);
        if(oldTodo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if(todo.getTodo() != null){
            oldTodo.setTodo(todo.getTodo());
        }

        if(todo.getPriority() != null){
            oldTodo.setPriority(todo.getPriority());
        }

        if(todo.getStatus() != null){
            oldTodo.setStatus(todo.getStatus());
        }
        return oldTodo;
    }

    @Override
    public void deleteTodo(int id) {
        if(todoList.get(id) == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        todoList.remove(id);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
}
