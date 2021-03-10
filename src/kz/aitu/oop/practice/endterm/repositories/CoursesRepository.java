package kz.aitu.oop.practice.endterm.repositories;

import kz.aitu.oop.practice.endterm.data.interfaces.IDB;
import kz.aitu.oop.practice.endterm.entities.Courses;
import kz.aitu.oop.practice.endterm.repositories.interfaces.ICoursesRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CoursesRepository implements ICoursesRepository {
    private final IDB db;

    public CoursesRepository(IDB db) { this.db = db; }

    @Override
    public boolean createCourses(Courses courses) {
        Connection con = null;
        try {
            con = db.getConnection(); //this line connects program with sql
            String sql = "INSERT INTO courses(course_id, course_name, course_instructor, " +
                    "course_credits, profile_id) VALUES (?,?,?,?,?)"; //string with
            //sql command
            PreparedStatement st = con.prepareStatement(sql); //this line prepares sql command to run

            st.setInt(1, courses.getCourse_id());
            st.setString(2, courses.getCourse_name());
            st.setString(3, courses.getCourse_instructor());
            st.setInt(4,courses.getCourse_credits());
            st.setInt(5,courses.getProfile_id());

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
    public Courses getCourses(int course_id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT course_id, course_name, course_instructor, course_credits, profile_id" +
                    " FROM courses WHERE course_id=?"; //string with sql command
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, course_id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Courses courses = new Courses(rs.getInt("course_id"),
                        rs.getString("course_name"),
                        rs.getString("course_instructor"),
                        rs.getInt("course_credits"),
                        rs.getInt("profile_id"));

                return courses;
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
    public List<Courses> getAllCourses() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT course_id, course_name, course_instructor, course_credits, profile_id" +
                    " FROM courses";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Courses> coursess = new LinkedList<>(); //object that uses generics
            while (rs.next()) {
                Courses courses = new Courses(rs.getInt("course_id"),
                        rs.getString("course_name"),
                        rs.getString("course_instructor"),
                        rs.getInt("course_credits"),
                        rs.getInt("profile_id"));

                coursess.add(courses); //we can add only courses to the list profiles because of the generics
            }

            return coursess;
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
    public Courses deleteCourseById(int course_id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM courses WHERE course_id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, course_id);

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

    public String getCredits(){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT course_name, course_credits" +
                    " FROM courses";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                creditsCalculator calculator = (tenge) -> tenge*11000;
                System.out.println("Credits of course " + rs.getString("course_name")+ " in tenge - " +
                        calculator.creditsInTenge(rs.getInt("course_credits")));

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
        return "";
    }


    public interface creditsCalculator{
        int creditsInTenge(int tenge);
    }
}
