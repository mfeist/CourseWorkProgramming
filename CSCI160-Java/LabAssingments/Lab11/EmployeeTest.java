
/**
 * Main class to test the User-Defined classes.
 * 
 * @author mfeist 
 * @version 04/03/2013
 */

import java.util.Scanner;

public class EmployeeTest
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner(System.in);//object reference.
        System.out.print("Enter the employee's first and last name: ");//output for the first and last name.
        String fName1 = scan.next();//to obtain the first name.
        String lName1 = scan.next();//to obtain the last name.
        
        System.out.print("Enter the month the employee was born: ");//output for the month the employee was born.
        int bMonth1 = scan.nextInt();//making it an int value.
        System.out.print("Enter the day the emplyee was born: ");//output for the day the employee was born.
        int bDay1 = scan.nextInt();//making it an int value.
        System.out.print("Enter the year the employee was born: ");//output for the year the employee was born.
        int bYear1 = scan.nextInt();//making it an int value.
        Date inputBirth1 = new Date(bMonth1, bDay1, bYear1);//object reference.
        
        System.out.print("Enter the month the employee was hired: ");//output for the month the employee was hired.
        int hMonth1 = scan.nextInt();//making it an int value.
        System.out.print("Enter the day the employee was hired: ");//output for the day the employee was hired.
        int hDay1 = scan.nextInt();//making it an int value.
        System.out.print("Enter the year the employee was hired: ");//output for the year the employee was hired.
        int hYear1 = scan.nextInt();//making it an int value.
        Date inputHire1 = new Date(hMonth1, hDay1, hYear1);//object reference.
        
        Employee employee1 = new Employee(fName1, lName1, inputBirth1, inputHire1);//object reference.
        
        System.out.println(employee1.toString());//output for the employees info as a string.
        
        System.out.print("Enter the employee's first and last name: ");//output for the first and last name.
        String fName2 = scan.next();//to obtain the first name.
        String lName2 = scan.next();//to obtain the last name.
        
        System.out.print("Enter the month the employee was born: ");//output for the month the employee was born.
        int bMonth2 = scan.nextInt();//making it an int value.
        System.out.print("Enter the day the emplyee was born: ");//output for the day the employee was born.
        int bDay2 = scan.nextInt();//making it an int value.
        System.out.print("Enter the year the employee was born: ");//output for the year the employee was born.
        int bYear2 = scan.nextInt();//making it an int value.
        Date inputBirth2 = new Date(bMonth2, bDay2, bYear2);//object reference.
        
        System.out.print("Enter the month the employee was hired: ");//output for the month the employee was hired.
        int hMonth2 = scan.nextInt();//making it an int value.
        System.out.print("Enter the day the employee was hired: ");//output for the day the employee was hired.
        int hDay2 = scan.nextInt();//making it an int value.
        System.out.print("Enter the year the employee was hired: ");//output for the year the employee was hired.
        int hYear2 = scan.nextInt();//making it an int value.
        Date inputHire2 = new Date(hMonth2, hDay2, hYear2);//object reference.
        
        Employee employee2 = new Employee(fName2, lName2, inputBirth2, inputHire2);//object reference.
        
        System.out.println(employee2.toString());//output for the employees info as a string.
        System.out.println("The current number of employee's entered is: " + employee1.getCountEmployee());//output stating the number of employees entered.
        if (employee1.equals(employee2))//if statement to determine whether the 2 employees are equal.
            System.out.println(employee1.getLastName() + ", " + employee1.getFirstName() + " equals " + employee2.getLastName() + ", " + employee2.getFirstName());//if true.
        else
            System.out.println(employee1.getLastName() + ", " + employee1.getFirstName() + " does not equal " + employee2.getLastName() + ", " + employee2.getFirstName());//if false.
    }
}
