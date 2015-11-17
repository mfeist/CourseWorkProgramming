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
public class Assignment {

    //Scanner for input from user.
    Scanner scan = new Scanner(System.in);
    //instance varaibles.
    private String startDate;
    private String endDate;

    //default constructor
    public Assignment() {
    }

    //set and get methods
    public void setStartDate() {
        System.out.print("Enter the start date: ");
        startDate = scan.next();
    }

    public void getStartDate() {
        System.out.println("Start_Date: " + startDate);
    }

    public void setEndDate() {
        System.out.print("Enter the end date: ");
        endDate = scan.next();
    }

    public void getEndDate() {
        System.out.println("End_Date: " + endDate);
    }

    //set method to call all the set methods of the class
    public void setAssignment() {
        setStartDate();
        setEndDate();
    }

    //get method to call all the get methods of the class.
    public void getAssignment() {
        getStartDate();
        getEndDate();
    }
}
