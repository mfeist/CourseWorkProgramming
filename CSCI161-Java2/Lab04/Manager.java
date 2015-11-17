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
public class Manager extends Employee {

    //Scanner to obtain input from the user.
    Scanner scan = new Scanner(System.in);
    //instance variables.
    private double bonus;
    private int vacationDays;

    //default constructer
    public Manager() {
    }

    //set and get methods.
    public void getBonus() {
        System.out.println("Bonus: $" + bonus);
    }

    public void setBonus() {
        System.out.print("Enter your Bonus: ");
        bonus = scan.nextInt();
    }

    public void getVacationDays() {
        System.out.println("Number of vacation days: " + vacationDays);
    }

    public void setVacationDays() {
        System.out.print("Enter your vacation days: ");
        vacationDays = scan.nextInt();
    }

    //set method to call all of the set methods.
    public void setManager() {
        super.setEmployee();
        setBonus();
        setVacationDays();
    }

    //get method to call all the get methods.
    public void getManager() {
        super.getEmployee();
        getBonus();
        getVacationDays();
    }
}
