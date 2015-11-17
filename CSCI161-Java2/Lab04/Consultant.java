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
public class Consultant extends Employee {

    //scanner to obtain the input from the user.
    Scanner scan = new Scanner(System.in);
    //instance variables
    private int lengthOfContract;

    //default constructor.
    public Consultant() {
    }

    //set and get methods.
    public void getLengthOfContract() {
        System.out.println("Contract length: " + lengthOfContract);
    }

    public void setLengthOfContract() {
        System.out.print("Enter your length of contract: ");
        lengthOfContract = scan.nextInt();
    }

    public void getStartDate() {
    }

    public void setStartDate() {
    }

    public void getEndDate() {
    }

    public void setEndDate() {
    }

    //set method to call all the set methods.
    public void setConsultant() {
        super.setEmployee();
        setLengthOfContract();
    }

    //get method to call all the get methods.
    public void getConsultant() {
        super.getEmployee();
        getLengthOfContract();

    }
}
