package com.tracker.main;

import java.sql.Date;
import java.util.Scanner;

import com.tracker.dao.AssignmentDAO;
import com.tracker.dao.EmployeeDAO;
import com.tracker.dao.ProjectDAO;
import com.tracker.frame.Employee;
import com.tracker.frame.Project;

public class mainapp{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeDAO empDao = new EmployeeDAO();
        ProjectDAO projDao = new ProjectDAO();
        AssignmentDAO assignDao = new AssignmentDAO();

        int choice;

        do {
            System.out.println("\nWelcome to Employee Project Tracking System");
            System.out.println("1. Add Employee");
            System.out.println("2. Add Project");
            System.out.println("3. Assign Employee to Project");
            System.out.println("4. View Projects by Employee ID");
            System.out.println("5. View Employees by Project ID");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1: // Adding the employee details in the Employee table
                	
                    System.out.println("Enter Employee ID");
                    int empId = sc.nextInt();
                    sc.nextLine();
                    if(empId>0) {
                    System.out.println("Enter Employee Name");
                    String empName = sc.nextLine();
                    System.out.println("Enter Designation");
                    String designation = sc.nextLine();

                    Employee emp = new Employee(empId, empName, designation);
                    empDao.addEmployee(emp);
                    break;}
                    
                    else {
                    	System.out.println("This can't be the EmployeeID");
                    	break;
                    }

                case 2: // Adding the Project details in the Project table
                    System.out.println("Enter Project ID");
                    int projectId = sc.nextInt();
                    sc.nextLine();
                    if(projectId>0) {
                    System.out.println("Enter Project Name");
                    String projectName = sc.nextLine();
                    System.out.println("Enter DeadLine");
                    String dateInput = sc.nextLine();
                    Date deadline = Date.valueOf(dateInput);

                    Project project = new Project(projectId, projectName, deadline);
                    projDao.addProject(project);
                    break;}
                    
                    else {
                    	System.out.println("This can't be the ProjectID");
                    	break;
                    }


                case 3: // Mapping the Employee with a Project
                    System.out.println("Enter Employee ID and Project ID for mapping");
                    int assignEmpId = sc.nextInt();
                    int assignProjectId = sc.nextInt();

                    assignDao.assignEmployeeToProject(assignEmpId, assignProjectId);
                    break;

                case 4: // Fetching Project details by Employee ID
                    System.out.println("Enter Employee ID:");
                    int searchEmpId = sc.nextInt();

                    assignDao.getProjectsByEmployee(searchEmpId);
                    break;

                case 5: // Fetching the Employee details working in that particular Project
                    System.out.println("Enter Project ID:");
                    int searchProjectId = sc.nextInt();

                    assignDao.getEmployeesByProject(searchProjectId);
                    break;

                case 0: // Exiting the application
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}

