package com.tracker.dao;

import java.sql.*;
import com.tracker.connection.ConnectionDB;

public class AssignmentDAO {

    public void assignEmployeeToProject(int empId, int projectId) {
        String sql = "INSERT INTO assignments VALUES (?, ?)";

        try (Connection con = ConnectionDB.getConnection1();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, empId);
            ps.setInt(2, projectId);
            ps.executeUpdate();

            System.out.println("Employee assigned to project");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getProjectsByEmployee(int empId) {
        String sql = """
            SELECT p.projectId, p.projectName, p.deadline
            FROM project p
            JOIN assignments a ON p.projectId = a.projectId
            WHERE a.empId = ?
        """;

        try (Connection con = ConnectionDB.getConnection1();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, empId); 
            ResultSet rs = ps.executeQuery();

            System.out.println("Projects for Employee ID " + empId + ":");
            while (rs.next()) {
                int projectId = rs.getInt("projectId");
                String projectName = rs.getString("projectName");
                String deadline = rs.getString("deadline");

                System.out.println("Project ID: " + projectId + ", Project Name: " + projectName + ", Deadline: " + deadline);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void getEmployeesByProject(int projectId) {
       
        String sql = """
            SELECT e.empId, e.name, e.designation
            FROM employee e
            JOIN assignments a ON e.empId = a.empId
            WHERE a.projectId = ?
        """;

        try (Connection con = ConnectionDB.getConnection1();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, projectId); 
            ResultSet rs = ps.executeQuery();

            System.out.println("Employees for Project ID " + projectId + ":");
            while (rs.next()) {
                
                int empId = rs.getInt("empId");
                String name = rs.getString("name");
                String designation = rs.getString("designation");

                System.out.println("Employee ID: " + empId + ", Name: " + name + ", Designation: " + designation);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


