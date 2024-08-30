package com.example.todo.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.example.todo.model.Todo;
import com.example.todo.model.TodoRowMapper;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TodoH2Service implements TodoRepository {
    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Todo> getTodos() {
        List<Todo> todos = db.query("Select * from TODOLIST", new TodoRowMapper());
        return new ArrayList<>(todos);
    }

    @Override
    public Todo getTodoById(int id) {
        try {
            return db.queryForObject("SELECT * FROM TODOLIST WHERE id =?", new TodoRowMapper(), id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Todo addTodo(Todo todo) {
        db.update("INSERT INTO TODOLIST(todo,priority,status) VALUES(?,?,?)", todo.getTodo(),
                todo.getPriority(), todo.getStatus());
        Todo savedTodo = db.queryForObject("select * from TODOLIST where todo = ?", new TodoRowMapper(),
                todo.getTodo());
        return savedTodo;
    }

    @Override
    public Todo updateTodo(int todoId, Todo todo) {
        try {
            if (todo.getTodo() != null) {
                db.update("Update TODOLIST set todo = ? where id=?", todo.getTodo(), todoId);
            }
            if (todo.getStatus() != null) {
                db.update("Update TODOLIST set status =? where id=?", todo.getStatus(), todoId);
            }
            if (todo.getPriority() != null) {
                db.update("Update TODOLIST set priority =? where id=?", todo.getPriority(), todoId);
            }
            return getTodoById(todoId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteTodo(int id) {
        try {
            db.update("DELETE FROM TODOLIST WHERE id =?", id);
            throw new ResponseStatusException(HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.OK);
        }
    }
}
