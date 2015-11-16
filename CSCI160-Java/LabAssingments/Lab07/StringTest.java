
/**
 * Demonstrate knowledge of string class methods.
 * 
 * @author mfeist 
 * @version 2/15/2013
 */
import javax.swing.JOptionPane;
import java.util.Scanner;

public class StringTest
{
    public static void main (String [] args)
    {
        String greeting1 = new String("Hi");
        String greeting2 = new String("Hello World");
        
        System.out.println("The length in " + greeting1 + " is " + greeting1.length() + ".");
        System.out.println("The length in " + greeting2 + " is " + greeting2.length() + ".");
        
        int firstO = greeting2.indexOf('o');
        System.out.println("\nThe index of the first o in " + greeting2 + " is " + firstO + ".");
        
        int lastO = greeting2.lastIndexOf('o');
        System.out.println("\nThe index of the last o in " + greeting2 + " is " + lastO + ".");
        
        String greeting21 = greeting2.substring(5);
        System.out.println("\nThe concatentation and substring between " + greeting1 + " and " + greeting2 + " is "+ greeting1 + greeting21);
        
        String greeting2Lower = greeting2.toLowerCase();
        System.out.println("\n" + greeting2 + " converted to lower case is " + greeting2Lower + ".");
        
        String greeting2Upper = greeting2.toUpperCase();
        System.out.println("\n" + greeting2 + " converted to upper case is " + greeting2Upper + ".");
        
        Scanner scan = new Scanner(System.in);
        System.out.print("\nPlease enter your favorite idiom > ");
        String idiom = scan.nextLine();
        JOptionPane.showMessageDialog(null, idiom);
        
    }
}
