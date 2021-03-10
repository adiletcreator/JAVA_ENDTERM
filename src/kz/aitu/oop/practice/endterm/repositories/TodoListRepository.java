package kz.aitu.oop.practice.endterm.repositories;

import kz.aitu.oop.practice.endterm.data.interfaces.IDB;
import kz.aitu.oop.practice.endterm.entities.Profile;
import kz.aitu.oop.practice.endterm.entities.TodoList;
import kz.aitu.oop.practice.endterm.repositories.interfaces.ITodoListRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class TodoListRepository implements ITodoListRepository {
    private final IDB db;

    public TodoListRepository(IDB db) { this.db = db; }

    @Override
    public boolean createTodoList(TodoList todoList) {
        Connection con = null;
        try {
            con = db.getConnection(); //this line connects program with sql
            String sql = "INSERT INTO todoList(list_id, task_name, task_deadline, " +
                    "profile_id) VALUES (?,?,?,?)"; //string with
            //sql command
            PreparedStatement st = con.prepareStatement(sql); //this line prepares sql command to run

            st.setInt(1, todoList.getList_id());
            st.setString(2, todoList.getTask_name());
            st.setString(3, todoList.getTask_deadline());
            st.setInt(4,todoList.getProfile_id());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public TodoList getTodoList(int list_id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT list_id, task_name, task_deadline, profile_id" +
                    " FROM todoList WHERE list_id=?"; //string with sql command
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, list_id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                TodoList todoList = new TodoList(rs.getInt("list_id"),
                        rs.getString("task_name"),
                        rs.getString("task_deadline"),
                        rs.getInt("profile_id"));

                return todoList;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<TodoList> getAllTodoList() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT list_id, task_name, task_deadline, profile_id" +
                    " FROM todoList";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<TodoList> todoListss = new LinkedList<>(); //object that uses generics
            while (rs.next()) {
                TodoList todoList = new TodoList(rs.getInt("list_id"),
                        rs.getString("task_name"),
                        rs.getString("task_deadline"),
                        rs.getInt("profile_id"));

                todoListss.add(todoList); //we can add only courses to the list profiles because of the generics
            }

            return todoListss;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public TodoList deleteTodoListById(int list_id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM todoList WHERE list_id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, list_id);

            st.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
