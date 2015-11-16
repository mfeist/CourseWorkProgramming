
/**
 * To determine if it is a leap year.
 * 
 * @author mfeist 
 * @version 2/24/2013
 */
import java.util.Scanner;

public class Years
{
    public static void main (String [] arg)
    {
        Scanner scan = new Scanner(System.in);
        //instantiate and declaring an object reference.
        
        System.out.print("Please enter a year > ");
        //output asking for a given year.
        int year = scan.nextInt();
        //assingning what was inputed as an int variable.
        
        if (year < 1582)
        //if statement declaring a condition.
            System.out.println("Error: " + year + " is before the Gregorian calendar was adopted.");
            //output for the if statement.
        else
        //the values that do not fall into the if statement will go into this else.
        {
            if (year % 4 != 0)
            //if statement declaring a condition.
            {
                System.out.println(year + " is not a leap year.");
                //output for the if statement.
            }
            else
            //the values that do not fall into the if statement will go into this else.
                if ((year % 400 != 0) && (year % 100 == 0))
                //if statement declaring a condition.
                {
                    System.out.println(year + " is not a leap year.");
                    //output for the if statement.
                }
                else
                //the values that do not fall into the if statement will go into this else.
                    System.out.println(year + " is a leap year.");
                    //output for the values that are a leap year.
        } 
    }
}
