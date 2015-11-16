
/**
 * Test the SalesTax user-defined class.
 * 
 * @author  mfeist 
 * @version 04/16/2013
 */

import java.util.Scanner;
import java.text.DecimalFormat;
public class SalesTaxTest
{
    public static void main (String[] args)
    {
        SalesTax tax = new SalesTax();//tax constructor of salestax.
        Scanner scan = new Scanner(System.in);//scan constructor of scanner.
        DecimalFormat percent = new DecimalFormat ("#0.0%");//percent constructor of decimalformat.
        
        System.out.print("Enter a number for a given state: ");//output asking for input of a state.
        int x = scan.nextInt() - 1;//input a int type and making it the correct index position.
        while (x < 0 || x > 49)//while statement to verify number is a state.
        {
            System.out.print("Error. Input is not a valid state number (1-50): ");//error message and having user correct it.
            x = scan.nextInt() - 1;//putiting the new value.
        }
        System.out.println("The state with the highest tax average is: " + tax.getHighestAverage());//output for the state with highest tax average.
        
        int [] copy = tax.getLowestArray();//creating new array for the lowest rate.
        System.out.println("\nStates that have at least one year with less than .1% tax rate is: ");//output.
        for (int i = 0; i < copy.length; i++)
            System.out.print(copy[i] + "\t");//output for the new array with less than .001.
        System.out.println(" ");//new line.
        System.out.println("\nThe highest tax rate for state " + (x + 1)  + " was: " + percent.format(tax.getHighestRate(x)));//output for the given state with highest rate.
    }
}
