package kz.aitu.oop.practice.endterm.repositories;

import kz.aitu.oop.practice.endterm.data.interfaces.IDB;
import kz.aitu.oop.practice.endterm.entities.Profile;
import kz.aitu.oop.practice.endterm.repositories.interfaces.IProfileRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
    //repository class where program connects to sql and executes given sql commands
public class ProfileRepository implements IProfileRepository {
    private final IDB db;

    public ProfileRepository(IDB db) { this.db = db; }

    @Override
    public boolean createProfile(Profile profile) { //This method creates new profile
        Connection con = null;
        try {
            con = db.getConnection(); //this line connects program with sql
            String sql = "INSERT INTO profile(profile_id, student_fname, student_lname, " +
                    "student_age, student_gender) VALUES (?,?,?,?,?)"; //string with
            //sql command
            PreparedStatement st = con.prepareStatement(sql); //this line prepares sql command to run

            st.setInt(1, profile.getId());
            st.setString(2, profile.getName());
            st.setString(3, profile.getSurname());
            st.setInt(4,profile.getAge());
            st.setString(5,profile.getGender());

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
    public Profile getProfile(int id) { // method that outputs stone by users given id
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT profile_id, student_fname, student_lname, student_age, student_gender" +
                    " FROM profile WHERE profile_id=?"; //string with sql command
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Profile profile = new Profile(rs.getInt("profile_id"),
                        rs.getString("student_fname"),
                        rs.getString("student_lname"),
                        rs.getInt("student_age"),
                        rs.getString("student_gender"));

                return profile;
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
    public List<Profile> getAllProfiles() { //method that output all specialists
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT profile_id, student_fname, student_lname, student_age, student_gender " +
                    " FROM profile";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Profile> profiles = new LinkedList<>(); //object that uses generics
            while (rs.next()) {
                Profile profile = new Profile(rs.getInt("profile_id"),
                        rs.getString("student_fname"),
                        rs.getString("student_lname"),
                        rs.getInt("student_age"),
                        rs.getString("student_gender"));

                profiles.add(profile); //we can add only profile to the list profiles because of the generics
            }

            return profiles;
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
        public Profile deleteProfileById(int id) {
            Connection con = null;
            try {
                con = db.getConnection();
                String sql = "DELETE FROM profile WHERE profile_id=?";
                PreparedStatement st = con.prepareStatement(sql);

                st.setInt(1, id);

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