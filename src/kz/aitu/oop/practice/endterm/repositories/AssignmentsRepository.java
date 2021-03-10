package kz.aitu.oop.practice.endterm.repositories;

import kz.aitu.oop.practice.endterm.data.interfaces.IDB;
import kz.aitu.oop.practice.endterm.entities.Assignments;
import kz.aitu.oop.practice.endterm.entities.Courses;
import kz.aitu.oop.practice.endterm.entities.Profile;
import kz.aitu.oop.practice.endterm.repositories.interfaces.IAssignmentsRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AssignmentsRepository implements IAssignmentsRepository {
    private final IDB db;

    public AssignmentsRepository(IDB db) { this.db = db; }

    @Override
    public boolean createAssignments(Assignments assignments) {
        Connection con = null;
        try {
            con = db.getConnection(); //this line connects program with sql
            String sql = "INSERT INTO assignments(asg_id, asg_name, asg_deadline, course_id) VALUES (?,?,?,?)"; //string with
            //sql command
            PreparedStatement st = con.prepareStatement(sql); //this line prepares sql command to run

            st.setInt(1, assignments.getAsg_id());
            st.setString(2, assignments.getAsg_name());
            st.setString(3, assignments.getAsg_deadline());
            st.setInt(4,assignments.getCourse_id());

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
    public Assignments getAssignments(int asg_id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT asg_id, asg_name, asg_deadline, course_id" +
                    " FROM assignments WHERE asg_id=?"; //string with sql command
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, asg_id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Assignments assignments = new Assignments(rs.getInt("asg_id"),
                        rs.getString("asg_name"),
                        rs.getString("asg_deadline"),
                        rs.getInt("course_id"));

                return assignments;
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
    public List<Assignments> getAllAssignments() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT asg_id, asg_name, asg_deadline, course_id" +
                    " FROM assignments";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Assignments> assignmentss = new LinkedList<>(); //object that uses generics
            while (rs.next()) {
                Assignments assignments = new Assignments(rs.getInt("asg_id"),
                        rs.getString("asg_name"),
                        rs.getString("asg_deadline"),
                        rs.getInt("course_id"));

                assignmentss.add(assignments); //we can add only courses to the list profiles because of the generics
            }

            return assignmentss;
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
    public Assignments deleteAssignmentById(int asg_id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM assignments WHERE asg_id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, asg_id);

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
