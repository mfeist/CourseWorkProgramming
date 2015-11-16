
/**
 * Write a program for monthly mortgage payments.
 * 
 * @author mfeist 
 * @version 2/24/2013
 */
import java.util.Scanner;
import java.text.DecimalFormat;

public class MorgagePayment
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner(System.in);
        //instantiate and declared object reference.
        DecimalFormat percentPattern = new DecimalFormat("#0.00%");
        //instantiate and declared object reference.
        DecimalFormat pricePattern = new DecimalFormat("$#,##0.00");
        //instantiate and declared object refenence.
        
        System.out.print("Enter the annual interest rate as a decimal > ");
        //output asking for interest rate.
        double annual = scan.nextDouble();
        //assinging what was inputed as a double variable.
        System.out.print("Enter the number of years  for the mortgage > ");
        //output asking for the mortgage.
        int years = scan.nextInt();
        //assinging what was inputed as an int variable.
        System.out.print("Enter the intial mortgage amount without the $ sign > ");
        //output asking for the initial amount.
        double initialAmount = scan.nextDouble();
        //assinging what was inputed as a doulbe variable.
        
        double mIR = (annual/12);
        //assinging and computing to find out monthly interest rate.
        double power = Math.pow((1 + mIR), (12 * years));
        //assinging and computiting to find out the power for monthly payments.
        double monthly = (mIR * initialAmount) / (1 - (1 / power));
        //assinging and computing to find out the montly payments.
        double totalAmount = (monthly * 12 * years);
        //assinging and computing to find out the total amount that will be paid.
        double overPayment = totalAmount - initialAmount;
        //assinging and computing to find out how much you will pay over the loan.
        double overPercent = overPayment / initialAmount;
        //assinging and computing to find out the percent that you will pay over.
        
        System.out.println("\nThe annual interest rate is " + percentPattern.format(annual));
        //output showing the annual interest rate as a percent.
        System.out.println("The mortgage amount is " + pricePattern.format(initialAmount));
        //output to show the mortgage amount in dollar format.
        System.out.println("The monthly payemts will be " + pricePattern.format(monthly));
        //output to show the monthly payments in dollar format.
        System.out.println("The total payment over " + years + " years will be " + pricePattern.format(totalAmount));
        //output to show the total amount paid in dollar format.
        System.out.println("The overpayemt will be " + pricePattern.format(overPayment));
        //output to show how much extra will be paid.
        System.out.println("The percentage that you will overpay will be " + percentPattern.format(overPercent));
        //output to show the percent of what will be overpaid.
    }
}
