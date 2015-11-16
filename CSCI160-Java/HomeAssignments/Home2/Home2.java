
/**
 * Homework assignment 2.
 * 
 * @author Mathew Feist 
 * @version 2/20/2013
 */
import java.text.DecimalFormat;
import java.util.Scanner;

public class Home2
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner(System.in);//instantiated Scanner.
        System.out.print("Enter the amount that you put into your investment without the $ sign > ");//Output asking for the input of investment amount.
        double investment = scan.nextDouble();//assinged the amount that was inputed to investment.
        System.out.print("Enter the interest rate as a decimal > ");//output asking for the input of the interest rate as a decimal.
        double rate = scan.nextDouble();//assinged the interesest rate to rate.
        DecimalFormat pricePattern = new DecimalFormat("$#0.00");//instantiated DecimalFormat for currency.
        double future5 = investment * Math.pow(1 + rate, 5);//calculated the future value after 5 years.
        double future10 = investment * Math.pow(1 + rate, 10);//calculated the future value after 10 years.
        double future20 = investment * Math.pow(1 + rate, 20);//calculated the future value after 20 years.
        System.out.println("\nThe amount you have in your investment after 5 years is " + pricePattern.format(future5) + ".");//output to view amount after 5 years.
        System.out.println("\nThe amount you have in your investment after 10 years is " + pricePattern.format(future10) + ".");//output to view amount after 10 years.
        System.out.println("\nThe amount you have in your investment after 20 years is " + pricePattern.format(future20) + ".");//output to view amount after 20 years.
    }
}
