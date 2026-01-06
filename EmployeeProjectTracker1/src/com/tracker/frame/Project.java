package com.tracker.frame;

import java.sql.Date;

public class Project {

    private int projectId;
    private String projectName;
    private Date deadline;

    public Project(int projectId, String projectName, Date deadline) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.deadline = deadline;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public Date getDeadline() {
        return deadline;
    }
}
