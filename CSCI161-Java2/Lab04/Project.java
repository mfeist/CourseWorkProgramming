/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab4;

import java.util.Scanner;

/**
 *
 * @author Christopher Jordan-Denny, Mathew Feist, Taren McCullough
 */
public class Project {

    //instance variables.
    private int idNumber;
    private String projectName;
    private String projectManager;
    private String projectStartDate;
    private String projectStopDate;
    private int[] projectAssignmentArray = new int[10];
    //Scanner to obtain input from user.
    Scanner scan = new Scanner(System.in);

    //default constructor
    public Project() {
    }

    //set and get methods.
    public void setProjectManager() {
        System.out.print("Enter the Manager: ");
        projectManager = scan.next();
    }

    public void getProjectManager() {
        System.out.println("Manager: " + projectManager);
    }

    public void setProjectStartDate() {
        System.out.print("Enter the start date: ");
        projectStartDate = scan.next();
    }

    public void getProjectStartDate() {
        System.out.println("Start_Date: " + projectStartDate);
    }

    public void setID() {
        System.out.print("Enter ID #: ");
        idNumber = scan.nextInt();
    }

    public void getID() {
        System.out.println("ID: " + idNumber);
    }

    public void getProjectName() {
        System.out.println("Name: " + projectName);
    }

    public void setProjectName() {
        System.out.print("Enter Project Name: ");
        projectName = scan.next();
    }

    public void setProjectStopDate() {
        System.out.print("Enter the end date: ");
        projectStopDate = scan.next();
    }

    public void getProjectStopDate() {
        System.out.println("End_Date: " + projectStopDate);
    }

    //set method to call all the set methods.
    public void setProject() {
        setID();
        setProjectName();
        setProjectManager();
        setProjectStartDate();
        setProjectStopDate();
    }

    //get method to call all the get methods.
    public void getProject() {
        getID();
        getProjectName();
        getProjectManager();
        getProjectStartDate();
        getProjectStopDate();
    }
}
