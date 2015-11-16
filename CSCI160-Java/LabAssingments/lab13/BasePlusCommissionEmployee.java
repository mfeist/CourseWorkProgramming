
/**
 * User-Defined sub-class.
 * 
 * @author mfeist 
 * @version 05/01/2013
 */
public class BasePlusCommissionEmployee extends CommissionEmployee
{
    //instance variable.
    private double baseSalary;
    
    //default constructor.
    public BasePlusCommissionEmployee()
    {
        super();
        baseSalary = 0;
    }
    
    //overloaded constructor.
    public BasePlusCommissionEmployee(String fName, String lName, String sSN, double grossSales, double commissionRate, double xBaseSalary)
    {
        super(fName, lName, sSN, grossSales, commissionRate);
        setBaseSalary(xBaseSalary);
    }
    
    //mutator method.
    public void setBaseSalary(double newBaseSalary)
    {
        if (newBaseSalary >= 0)
            baseSalary = newBaseSalary;
        else
            System.err.println("Base salary cannot be negative.");
    }
    
    //access method.
    public double getBaseSalary()
    {
        return baseSalary;
    }
    
    //overiding toString method.
    public String toString()
    {
        return super.toString() + "; base salary is: " + MONEY.format(baseSalary);
    }
    
    //overriding getEarnings method.
    public double getEarnings()
    {
        return(getCommissionRate() * getGrossSales()) + baseSalary;
    }
}
