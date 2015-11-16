
/**
 * Write a program for tempuratures.
 * 
 * @author mfeist
 * @version 2/24/2013
 */
import java.util.Scanner;

public class Temperature
{
   public static void main (String [] args)
   {
       Scanner scan = new Scanner(System.in);
       //instantiate and declare an object reference.
       
       System.out.print("Enter the temperature as a whole number > ");
       //output asking for a temperature.
       int temperature = scan.nextInt();
       //assinging what is inputed as an int variable.
       
       if (temperature >= 90 && temperature <= 110)
       //is statement declaring a condition.
        System.out.println("It is probably Summer");
        //output of the if statement.
        
       else if (temperature >= 70 && temperature < 90)
       //else if statement declaring a condition.
        System.out.println("It is probably spring");
        //output for the else if statement.
        
       else if (temperature >= 50 && temperature < 70)
       //elle if statement declaring a condition.
        System.out.println("It is probably fall");
        //output for the else if statement.
        
       else if (temperature >= -5 && temperature < 50)
       //else if statement declaring a condition.
        System.out.println("It is probably winter");
        //output for the else if statement.
        
       else if (temperature > 110 || temperature < -5)
       //else if statement declaring a condition.
        System.out.println("Outside the valid range.");
        //ouput for the else if statement.
   }
}
