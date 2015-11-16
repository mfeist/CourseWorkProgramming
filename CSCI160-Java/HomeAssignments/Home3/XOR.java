
/**
 * Demonstrate knowlege of XOR.
 * 
 * @author mfeist 
 * @version 3/8/13
 */

import java.util.Scanner;

public class XOR
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner(System.in);//declared and instatiated an object.
        System.out.print("Enter a string of 1's and 0's: ");//output to recieve input.
        String value = scan.next();//entering the input as a string value.
        int index = 0;//declared and set index to 0.
        char digit1, digit2, answer;//declared as char values.
        String newValue = "";//declared newValue empty.
        
        while (value.length() >= 2)//condition for while.
        {
            digit1 = value.charAt(index);//to recieve the first digit of the value.
            digit2 = value.charAt(index + 1);//to receive the second digit of the value.
            newValue = value.substring(index + 2, value.length());//storing whats rest of the value as a newValue.
            if (digit1 == digit2)//condition for if statement.
                answer = '0';//setting to 0 if true.
            else
                answer = '1';//setting to 1 if false.
            value = answer + newValue;//storing the value to determine the rest of the statement.
        }
        System.out.println(value);//output to view if the end value is true or false.
    }
}
