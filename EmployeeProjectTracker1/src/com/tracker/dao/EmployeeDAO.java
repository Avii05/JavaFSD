package com.tracker.dao;

import java.sql.*;

import com.tracker.frame.Employee;
import com.tracker.connection.ConnectionDB;

public class EmployeeDAO {

    public void addEmployee(Employee emp) {
        String sql = "INSERT INTO employee VALUES (?, ?, ?)";

        try (Connection con = ConnectionDB.getConnection1();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, emp.getEmpId());
            ps.setString(2, emp.getName());
            ps.setString(3, emp.getDesignation());

            ps.executeUpdate();
            System.out.println("Employee added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Employee findById(int empId) {
        String sql = "SELECT * FROM employee WHERE empId=?";

        try (Connection con = ConnectionDB.getConnection1();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Employee(
                        rs.getInt("empId"),
                        rs.getString("name"),
                        rs.getString("designation")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

