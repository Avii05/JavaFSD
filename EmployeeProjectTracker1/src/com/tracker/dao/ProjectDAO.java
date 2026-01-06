package com.tracker.dao;

import java.sql.*;

import com.tracker.frame.Project;
import com.tracker.connection.ConnectionDB;

public class ProjectDAO {

    public void addProject(Project project) {
        String sql = "INSERT INTO project VALUES (?, ?, ?)";

        try (Connection con = ConnectionDB.getConnection1();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, project.getProjectId());
            ps.setString(2, project.getProjectName());
            ps.setDate(3, project.getDeadline());

            ps.executeUpdate();
            System.out.println("Project added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Project findById(int projectId) {
        String sql = "SELECT * FROM project WHERE projectId=?";

        try (Connection con = ConnectionDB.getConnection1();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, projectId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Project(
                        rs.getInt("projectId"),
                        rs.getString("projectName"),
                        rs.getDate("deadline")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
