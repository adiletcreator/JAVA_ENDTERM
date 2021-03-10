package kz.aitu.oop.practice.endterm.data;

import kz.aitu.oop.practice.endterm.data.interfaces.IDB;

import java.sql.*;

public class StudentMS implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/StudentMS";
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "99uminat");

            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
