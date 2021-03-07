package kz.aitu.oop.practice.assignment5.repositories;

import kz.aitu.oop.practice.assignment5.Main;
import kz.aitu.oop.practice.assignment5.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment5.entities.Stones;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IStoneRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
    //repository class where program connects to sql and executes given sql commands
public class StonesRepository implements IStoneRepository {
    private final IDB db;

    public StonesRepository(IDB db) { this.db = db; }

    @Override
    public boolean createStone(Stones stones) { //This method creates new stone
        Connection con = null;
        try {
            con = db.getConnection(); //this line connects program with sql
            String sql = "INSERT INTO stones(stone_cost, stone_weight, stone_name) VALUES (?,?,?)"; //string with
            //sql command
            PreparedStatement st = con.prepareStatement(sql); //this line prepares sql command to run

            st.setInt(1, stones.getCost());
            st.setInt(2, stones.getWeight());
            st.setString(3, stones.getName());


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
    public Stones getStone(int id) { // method that outputs stone by users given id
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT stone_id,stone_cost,stone_weight,stone_name FROM stones WHERE stone_id=?"; //string with sql command
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Stones stones = new Stones(rs.getInt("stone_id"),
                        rs.getInt("stone_cost"),
                        rs.getInt("stone_weight"),
                        rs.getString("stone_name"));

                return stones;
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
    public List<Stones> getAllStones() { //method that output all specialists
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT stone_id,stone_cost,stone_weight,stone_name FROM stones";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Stones> stoness = new LinkedList<>(); //object that uses generics
            while (rs.next()) {
                Stones stones = new Stones(rs.getInt("stone_id"),
                        rs.getInt("stone_cost"),
                        rs.getInt("stone_weight"),
                        rs.getString("stone_name"));

                stoness.add(stones); //we can add only stones to the list stoness because of the generics
            }

            return stoness;
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
    public int necklaceTotalCost() { //method to calculate total cost
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT stone_cost FROM stones"; //sql query to output total cost
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            int counter = 0;
            while (rs.next()) { //while loop to sum all salary of specialists in our project
                counter += rs.getInt("stone_cost");
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
    public int necklaceTotalWeight(){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT stone_weight FROM stones"; //sql query to output total cost
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            int counter = 0;
            while (rs.next()) { //while loop to sum all salary of specialists in our project
                counter += rs.getInt("stone_weight");
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

        private interface Calculate{
            int calc(int a, int b);
        }

        @Override
        public int operate() { //method with lambda expression
            Calculate calculate;
            calculate = (int x, int y) -> (x+y);
            return calculate.calc(necklaceTotalCost(),3000); //I set the price to assembly neckalce 3000 tenge
        }
    }