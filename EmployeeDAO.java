package com.afia577;

import java.sql.*;
import java.util.*;

public class EmployeeDAO {

    private String url = "jdbc:mysql://localhost:3306/24wh1a0577";
    private String user = "root";
    private String pass = "1234";

    // 🔹 Get Connection
    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, pass);
    }

    // 🔹 GET ALL
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();

        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setSalary(rs.getInt("salary"));
                list.add(e);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // 🔹 INSERT
    public void insertEmployee(Employee e) {
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO employee VALUES (?, ?, ?)"
            );

            ps.setInt(1, e.getId());
            ps.setString(2, e.getName());
            ps.setInt(3, e.getSalary());

            ps.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 🔹 DELETE
    public void deleteEmployee(int id) {
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM employee WHERE id=?"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 UPDATE
    public void updateEmployee(Employee e) {
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE employee SET name=?, salary=? WHERE id=?"
            );

            ps.setString(1, e.getName());
            ps.setInt(2, e.getSalary());
            ps.setInt(3, e.getId());

            ps.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}