package kz.aitu.oop.practice.endterm.repositories;

import kz.aitu.oop.practice.endterm.data.interfaces.IDB;
import kz.aitu.oop.practice.endterm.entities.Exams;
import kz.aitu.oop.practice.endterm.entities.Profile;
import kz.aitu.oop.practice.endterm.repositories.interfaces.IExamsRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ExamsRepository implements IExamsRepository {
    private final IDB db;

    public ExamsRepository(IDB db) { this.db = db; }

    @Override
    public boolean createExams(Exams exams) {
        Connection con = null;
        try {
            con = db.getConnection(); //this line connects program with sql
            String sql = "INSERT INTO exams(exam_id, exam_name, exam_examinator, exam_topics, " +
                    "exam_date, course_id) VALUES (?,?,?,?,?,?)"; //string with
            //sql command
            PreparedStatement st = con.prepareStatement(sql); //this line prepares sql command to run

            st.setInt(1, exams.getExam_id());
            st.setString(2, exams.getExam_name());
            st.setString(3, exams.getExam_examinator());
            st.setString(4,exams.getExam_topics());
            st.setString(5,exams.getExam_day());
            st.setInt(6, exams.getCourse_id());

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
    public Exams getExams(int exam_id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT exam_id, exam_name, exam_examinator, exam_topics, exam_date, course_id" +
                    " FROM exams WHERE exam_id=?"; //string with sql command
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, exam_id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Exams exams = new Exams(rs.getInt("exam_id"),
                        rs.getString("exam_name"),
                        rs.getString("exam_examinator"),
                        rs.getString("exam_topics"),
                        rs.getString("exam_date"),
                        rs.getInt("course_id"));

                return exams;
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
    public List<Exams> getAllExams() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT exam_id, exam_name, exam_examinator, exam_topics, exam_date, course_id" +
                    " FROM exams";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Exams> examss = new LinkedList<>(); //object that uses generics
            while (rs.next()) {
                Exams exams = new Exams(rs.getInt("exam_id"),
                        rs.getString("exam_name"),
                        rs.getString("exam_examinator"),
                        rs.getString("exam_topics"),
                        rs.getString("exam_date"),
                        rs.getInt("course_id"));

                examss.add(exams); //we can add only courses to the list profiles because of the generics
            }

            return examss;
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
    public Exams deleteExamsById(int exam_id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM exams WHERE exam_id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, exam_id);

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
