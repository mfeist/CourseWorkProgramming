
/**
 * Demonstrate knowledge of using User-Defined Classes.
 * 
 * @author mfeist 
 * @version 03/26/2013
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class LoanTest
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        DecimalFormat pricePattern = new DecimalFormat("$#,###,##0.00");//price format.
        DecimalFormat percentPattern = new DecimalFormat("#0.00%");//percent format.
        final String SENTINEL = "YES";//sentinel value for control of loop.
        String condition, condition1;//instantiate variables.
        
        do
        {
            System.out.print("Enter the day that the loan starts: ");//output asking for the day of the loan.
            int day = scan.nextInt();//declaring it an int variable.
            while (day < 0 || day > 31)//while statement to make sure the variable is a possible day.
            {
                System.out.print("Enter the day between 1 and 31: ");//output to reasking for input.
                day = scan.nextInt();//int variable.
            }
        
            System.out.print("Enter the month that the loan starts: ");//output for the month.
            int month = scan.nextInt();//making variable an int.
            while (month < 0 || month > 12)//check to make sure variable is a possible month.
            {
                System.out.print("Enter the month between 1 and 12: ");//to re-enter month.
                month = scan.nextInt();//variable as int.
            }
        
            System.out.print("Enter the year that the loan starts: ");//output for the year.
            int year = scan.nextInt();//value as an int.
            while (year < 0)//check to make sure value is a year.
            {
                System.out.print("Enter a positive value for the year: ");//output to e-enter value.
                year = scan.nextInt();//value as int.
            }
        
            Date date1 = new Date(day, month, year);
        
            String loanDate = date1.getMonth() + "/" + date1.getDay() + "/" + date1.getYear();//making the date.
        
            System.out.print("Enter the annual interest rate: ");//output for the annual interest rate.
            double aIR = scan.nextDouble();//value as a double.
            while (aIR < 0)//check to verify rate is a real number.
            {
                System.out.print("Enter a positive value for the annual interest rate: ");//output to re-enter value.
                aIR = scan.nextDouble();//value as a double.
            }
        
            System.out.print("Enter the number of years of the loan: ");//output for the years.
            int years = scan.nextInt();//value as int.
            while (years < 0)//check to verify years is a real number.
            {
                System.out.print("Enter a positive value for the number of years for the loan: ");//output to re-enter value.
                years = scan.nextInt();//value as an int.
            }
        
            System.out.print("Enter the loan amount: ");//output for loan amount.
            double loanAmount = scan.nextDouble();//value as a double.
            while (loanAmount < 0)//check to make sure value is a real number.
            {
                System.out.print("Enter a positive value for the loan amount: ");//output to re-enter value.
                loanAmount = scan.nextDouble();//value as a double.
            }
        
            Loan loan1 = new Loan(aIR, years, loanAmount, loanDate);
        
            System.out.println("Your loan starts on " + loan1.getLoanDate());//output for when the loan starts.
            System.out.println("The annual interest rate is " + percentPattern.format(loan1.getAnnualInterestRate()));//output for annual interest rate.
            System.out.println("The mortage amount is " + pricePattern.format(loan1.getLoanAmount()));//output showing loan amount.
            System.out.println("The monthly payments are " + pricePattern.format(loan1.getMonthlyPayment()));//output for monthly payments.
            System.out.println("The total payment over the time of the loan is " + pricePattern.format(loan1.getTotalPayment()));//output for total amount paid.
            System.out.println("The overpayment amount will be " + pricePattern.format(loan1.getOverPayment()));//output for the amount over paid.
            System.out.println("The percent that you will overpay will be " + percentPattern.format(loan1.getOverPercent()));//output for the percent that is overpaid.
            
            System.out.print("YES or NO: ");//asking if user wants to re-enter the info.
            condition = scan.next();//value as a string value.
            condition1 = condition.toUpperCase();//making the value into all caps.
        
        }while (condition1.equals(SENTINEL));//condition for do/while loop.
        System.out.println("Goodbye");//output showing the program has finished.
    }
}
