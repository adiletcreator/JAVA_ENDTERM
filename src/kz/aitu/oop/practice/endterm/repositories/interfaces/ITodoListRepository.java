package kz.aitu.oop.practice.endterm.repositories.interfaces;

import kz.aitu.oop.practice.endterm.entities.Exams;
import kz.aitu.oop.practice.endterm.entities.TodoList;

import java.util.List;

public interface ITodoListRepository {
    boolean createTodoList(TodoList todoList);
    TodoList getTodoList(int list_id);
    List<TodoList> getAllTodoList();
    TodoList deleteTodoListById(int list_id);
//    List<TodoList> getAllTodoListDataInfo(int profile_id);
}
