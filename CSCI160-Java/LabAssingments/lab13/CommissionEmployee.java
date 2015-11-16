
/**
 * User-Defined super and sub-class.
 * 
 * @author mfeist 
 * @version 05/01/2013
 */

import java.text.DecimalFormat;

public class CommissionEmployee extends Employee
{
    DecimalFormat percentPattern = new DecimalFormat("#0.0%");
    
    //instance variables.
    private double grossSales;
    private double commissionRate;
    
    //default constructor.
    public CommissionEmployee()
    {
        super();
        grossSales = 0.0;
        commissionRate = 0.0;
    }
    
    //overloaded constructor.
    public CommissionEmployee(String fName, String lName, String sSN, double xGrossSales, double xCommissionRate)
    {
        super(fName, lName, sSN);
        setGrossSales(xGrossSales);
        setCommissionRate(xCommissionRate);
    }
    
    //mutator method.
    public void setGrossSales(double newGrossSales)
    {
        if (newGrossSales >= 0)
            grossSales = newGrossSales;
        else
            System.err.println("Gross sales cannot be negative.");
    }
    
    //mutator method.
    public void setCommissionRate(double newCommissionRate)
    {
        if (newCommissionRate >= 0)
            commissionRate = newCommissionRate;
        else
            System.err.println("Commission rate cannot be negative.");
    }
    
    //access method.
    public double getGrossSales()
    {
        return grossSales;
    }
    
    //access method.
    public double getCommissionRate()
    {
        return commissionRate;
    }
    
    //overriding toString.
    public String toString()
    {
        return super.toString() + "; gross sales are: " + MONEY.format(grossSales) + " and commission rate is: " + percentPattern.format(commissionRate);
    }
    
    //overriding getEarnings.
    public double getEarnings()
    {
        double earnings = commissionRate * grossSales;
        return earnings;
    }
}
