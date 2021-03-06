package com.testapp.HelloWorld.service;

import com.testapp.HelloWorld.dao.TodoDao;
import com.testapp.HelloWorld.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodoService {

    private final TodoDao todoDao;

    @Autowired
    public TodoService(@Qualifier("postgres") TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public Todo addTodo(Todo todo) {
        return todoDao.addTodo(todo);
    }

    public List<Todo> getAllTodos() {
        return todoDao.selectAllTodos();
    }

    public Optional<Todo> getTodoById(UUID id) {
        return todoDao.selectTodoById(id);
    }

    public void deleteTodo(UUID id) {
        todoDao.deleteTodoById(id);
    }

    public Optional<Todo> updateTodo(UUID id, Todo todo) {
        return todoDao.updateTodoById(id, todo);
    }

    public Optional<Todo> updateTodoTitle(UUID id, String title) {
        return todoDao.updateTodoTitleById(id, title);
    }

    public Optional<Todo> updateTodoCompleted(UUID id, Boolean completed) {
        return todoDao.updateTodoCompletedById(id, completed);
    }

}
