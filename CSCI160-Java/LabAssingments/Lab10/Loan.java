
/**
 * Demonstrate ability to write a User-Drfined Class for loans.
 * 
 * @author mfeist
 * @version 03/26/2013
 */
public class Loan
{
   private double annualInterestRate;//instance variable for annual interest rate.
   private int numberOfYears;//instance variable for number of years of the loan.
   private double loanAmount;//instance variable for the loan amount.
   private String loanDate;//instance variable for the loan date.
   double monthlyPayment;//declaring monthly payment.
   double totalPayment;//declaring total payment.
   double overPayment;//declaring overpayment.
   
   public Loan (double xAnnualInterestRate, int xNumberOfYears, double xLoanAmount, String xLoanDate)//construtor
   {
       setAnnualInterestRate (xAnnualInterestRate);//beginning value for the annual interest rate.
       setNumberOfYears (xNumberOfYears);//beginning value for the number of years.
       setLoanAmount (xLoanAmount);//beginning value for the loan amount.
       loanDate = xLoanDate;//beginning value for the loan date.
   }
   
   public double getAnnualInterestRate()//accessor method.
   {
       return annualInterestRate;//return annual interest rate.
   }
   
   public int getNumberOfYears()//accessor method.
   {
       return numberOfYears;//return the number of years of the loan.
   }
   
   public double getLoanAmount()//accessor method.
   {
       return loanAmount;//return loan amount.
   }
   
   public String getLoanDate()//accessor method.
   {
       return loanDate;//return the loan date.
   }
   
   public void setAnnualInterestRate(double newAnnualInterestRate)//mutator method.
   {
       if (newAnnualInterestRate >= 0.0)//check to verify value is positive.
        annualInterestRate = newAnnualInterestRate;//if value is positive, it is changed.
       else
       {
           System.err.println("Annual interest rate cannot be negative.");//if negative, error and not changed.
           System.err.println("Value not changed.");
       }
   }
   
   public void setNumberOfYears(int newNumberOfYears)//mutator method.
   {
       if (newNumberOfYears >= 0)//check to verify that its positive.
        numberOfYears = newNumberOfYears;//if positive, new value is stored.
       else
       {
           System.err.println("Number of years cannot be negative.");//if negative, error and not changed.
           System.err.println("Value not changed.");
       }
   }
   
   public void setLoanAmount(double newLoanAmount)//mutator method.
   {
       if (newLoanAmount >= 0.0)//check to verify value is positive.
        loanAmount = newLoanAmount;//if positive, value is changed.
       else
       {
           System.err.println("Loan amount cannot be negative.");//if negative, error and value is not changed.
           System.err.println("Value not changed.");
       }
   }
   
   public double getMonthlyPayment()//accessor method.
   {
       double mIR = annualInterestRate / 12;//calulates the monthly interest rate.
       double power = Math.pow((1 + mIR), (12 * numberOfYears));//calculates the power for the espression.
       monthlyPayment = (mIR * loanAmount) / (1 - (1 / power));//calculates the monthly payment.
       return monthlyPayment;//returns the monthly payment.
   }
   
   public double getTotalPayment()//accessor method.
   {
       totalPayment = monthlyPayment * 12 * numberOfYears;//calculates the total payment amount.
       return totalPayment;//return total payment.
   }
   
   public double getOverPayment()//accessor method.
   {
       overPayment = totalPayment - loanAmount;//calculates the overpayment amount.
       return overPayment;//returns the total payment.
   }
   public double getOverPercent()//accessor method.
   {
       double overPercent = overPayment / loanAmount;//calulates the overpercent.
       return overPercent;//returns overpercent.
   }
}
