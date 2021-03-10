package kz.aitu.oop.practice.endterm.controllers;

import kz.aitu.oop.practice.endterm.entities.TodoList;
import kz.aitu.oop.practice.endterm.repositories.interfaces.ITodoListRepository;

import java.util.List;

public class TodoListController {
    private final ITodoListRepository repo;

    public TodoListController(ITodoListRepository repo) {
        this.repo = repo;
    }

    public String createTodoList(int list_id, String task_name, String task_deadline, int profile_id) {//method to create
        //profile in sql table

        TodoList todoList = new TodoList(list_id, task_name, task_deadline, profile_id);

        boolean created = repo.createTodoList(todoList);

        return (created ? "TodoList was created!" : "TodoList creation was failed!");
    }

    public String getTodoList(int id) { //method to get todoList by id
        TodoList todoList = repo.getTodoList(id);

        return (todoList == null ? "TodoList was not found!" : todoList.toString());
    }

    public String getAllTodoList() { //method to get all todoLists from table
        List<TodoList> todoList = repo.getAllTodoList();

        return todoList.toString();
    }
    public String deleteTodoList(int list_id) {
        TodoList todoList = repo.deleteTodoListById(list_id);
        return (todoList == null ? "TodoList has deleted" : "TodoList was not found!");
    }
}
