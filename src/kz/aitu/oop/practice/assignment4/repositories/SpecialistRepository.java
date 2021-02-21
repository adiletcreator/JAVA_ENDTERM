package kz.aitu.oop.practice.assignment4.repositories;

import kz.aitu.oop.practice.assignment4.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment4.entities.Specialist;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.ISpecialistRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
    //repository class where program connects to sql and executes given sql commands
public class SpecialistRepository implements ISpecialistRepository {
    private final IDB db;

    public SpecialistRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createSpecialist(Specialist specialist) { //This method creates new specialist
        Connection con = null;
        try {
            con = db.getConnection(); //this line connects program with sql
            String sql = "INSERT INTO specialists(name,surname,specialty, salary) VALUES (?,?,?,?)"; //string with
            //sql command
            PreparedStatement st = con.prepareStatement(sql); //this line prepares sql command to run

            st.setString(1, specialist.getName());
            st.setString(2, specialist.getSurname());
            st.setString(3, specialist.getSpecialty());
            st.setInt(4, specialist.getSalary());

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
    public Specialist getSpecialist(int id) { // method that outputs specialist by users given id
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,specialty, salary FROM specialists WHERE id=?"; //string with sql command
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Specialist specialist = new Specialist(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("specialty"),
                        rs.getInt("salary"));

                return specialist;
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
    public List<Specialist> getAllSpecialists() { //method that output all specialists
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,specialty, salary FROM specialists";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Specialist> specialists = new LinkedList<>();
            while (rs.next()) {
                Specialist specialist = new Specialist(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("specialty"),
                        rs.getInt("salary"));

                specialists.add(specialist);
            }

            return specialists;
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
    public int projectTotalCost() { //method to calculate total cost
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT salary FROM specialists"; //sql query to output total cost
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            int counter = 0;
            while (rs.next()) { //while loop to sum all salary of specialists in our project
                counter += rs.getInt("salary");
            }
            return counter;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public int getHPspecialist() { //method to output highest salary
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT salary from specialists";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            int total=-9999999;

            while (rs.next()) {
                if(rs.getInt("salary")>total){
                    total=rs.getInt("salary");
                }

            }return total;

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
        return 0;
    }
}
