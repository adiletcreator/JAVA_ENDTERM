package kz.aitu.oop.practice.endterm.repositories;

import kz.aitu.oop.practice.endterm.data.interfaces.IDB;
import kz.aitu.oop.practice.endterm.entities.Profile;
import kz.aitu.oop.practice.endterm.entities.University_Profile;
import kz.aitu.oop.practice.endterm.repositories.interfaces.IUniverity_ProfileRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class University_ProfileRepository implements IUniverity_ProfileRepository {
    private final IDB db;

    public University_ProfileRepository(IDB db) { this.db = db; }

    @Override
    public boolean createUniversity_Profile(University_Profile university_profile) {
        Connection con = null;
        try {
            con = db.getConnection(); //this line connects program with sql
            String sql = "INSERT INTO university_profile(unipr_id, fullname, phoneNumb, email, studyYear, " +
                    "universityName, profile_id) VALUES (?,?,?,?,?,?,?)"; //string with
            //sql command
            PreparedStatement st = con.prepareStatement(sql); //this line prepares sql command to run

            st.setInt(1, university_profile.getUnipr_id());
            st.setString(2, university_profile.getFullname());
            st.setString(3, university_profile.getPhoneNumb());
            st.setString(4,university_profile.getEmail());
            st.setInt(5,university_profile.getStudyYear());
            st.setString(6,university_profile.getUniversityName());
            st.setInt(7,university_profile.getProfile_id());

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
    public University_Profile getUniversity_Profile(int unipr_id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT unipr_id, fullname, phoneNumb, email, studyYear, universityName, " +
                    "profile_id FROM university_profile WHERE unipr_id=?"; //string with sql command
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, unipr_id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                University_Profile university_profile = new University_Profile(rs.getInt("unipr_id"),
                        rs.getString("fullname"),
                        rs.getString("phoneNumb"),
                        rs.getString("email"),
                        rs.getInt("studyYear"),
                        rs.getString("universityName"),
                        rs.getInt("profile_id"));

                return university_profile;
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
    public List<University_Profile> getAllUniversity_Profile() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT unipr_id, fullname, phoneNumb, email, studyYear, universityName, " +
                    "profile_id FROM university_profile";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<University_Profile> university_profiles = new LinkedList<>(); //object that uses generics
            while (rs.next()) {
                University_Profile university_profile = new University_Profile(rs.getInt("unipr_id"),
                        rs.getString("fullname"),
                        rs.getString("phoneNumb"),
                        rs.getString("email"),
                        rs.getInt("studyYear"),
                        rs.getString("universityName"),
                        rs.getInt("profile_id"));

                university_profiles.add(university_profile); //we can add only courses to the list profiles because of the generics
            }

            return university_profiles;
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
    public University_Profile deleteUniversity_ProfileById(int unipr_id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM university_profile WHERE unipr_id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, unipr_id);

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
