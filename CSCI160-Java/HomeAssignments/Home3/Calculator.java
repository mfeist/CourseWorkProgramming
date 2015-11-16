
/**
 * Write a simple "English language" calculator.
 * 
 * @author mfeist
 * @version 3/8/2013
 */
import java.util.Scanner;

public class Calculator
{
    public static void main (String [] args )
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter the first operand: ");
        int number1 = scan.nextInt();
        System.out.print("Enter the second operand: ");
        int number2 = scan.nextInt();
        
        System.out.println("\nOperations are: "
                            + "\n\t ADD or + for addition"
                            + "\n\t SUBTRACT or - for subtraction"
                            + "\n\t MULTIPLY or * for multipication"
                            + "\n\t DIVIDE or / for division");
        System.out.print("\nEnter your selection: ");
        String operation = scan.next();
        operation = operation.toUpperCase();
        
        switch (operation)
        {
            case "ADD":
             case "+":
              System.out.println("The sum is " + (number1 + number2));
              break;
            case "SUBTRACT":
             case "-":
              System.out.println("The difference is " + (number1 - number2));
              break;
            case "MULTIPLY":
             case "*":
              System.out.println("The product is " + (number1 * number2));
              break;
            case "DIVIDE":
             case "/":
              if (number2 == 0)
               System.out.println("Dividing by 0 is not allowed");
              else
               System.out.println("The quotient is " + (number1 / number2));
              break;
            default:
             System.out.println(operation + " is not valid.");
        }
    }
}
