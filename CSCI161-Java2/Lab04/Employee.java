/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab4;

/**
 *
 * @author Christopher Jordan-Denny, Mathew Feist, Taren McCullough
 */
import java.util.Scanner;

public class Employee {

    //Scanner to obtain input from user
    Scanner scan = new Scanner(System.in);
    //instance variables.
    private int idNumber;
    private String name;
    private int age;
    private char sex;
    private double salary;
    private String jobTitle;

    //default constructor.
    public Employee() {
    }

    //set and get methods.
    public void getID() {
        System.out.println("ID number: " + idNumber);
    }

    public void setID() {
        System.out.print("Enter your ID number: ");
        idNumber = scan.nextInt();
    }

    public void getName() {
        System.out.println("Name: " + name);
    }

    public void setName() {
        System.out.print("Enter your name: ");
        name = scan.next();
    }

    public void increment() {
    }

    public void Promote() {
    }

    public void setAge() {
        System.out.print("Enter your age: ");
        age = scan.nextInt();
    }

    public void getAge() {
        System.out.println("Age: " + age);
    }

    public void getSalary() {
    }

    //set method to call all the set methods.
    public void setEmployee() {
        setID();
        setName();
        setAge();
    }

    //get method to call all the get methods.
    public void getEmployee() {
        getID();
        getName();
        getAge();
    }
}
