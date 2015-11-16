
/**
 * User-Defined sub-class.
 * 
 * @author mfeist
 * @version 05/01/2013
 */
public class SalariedEmployee extends Employee
{
    //intance variable.
    private double weeklySalary;
    
    //default constructor.
    public SalariedEmployee()
    {
        super();
        weeklySalary = 0.0;
    }
    
    //overloaded constructor.
    public SalariedEmployee(String fName, String lName, String sSN,double xWeeklySalary)
    {
        super(fName, lName, sSN);
        setWeeklySalary (xWeeklySalary);
    }
    
    //mutator method for weekly salary.
    public void setWeeklySalary(double newWeeklySalary)
    {
        if (newWeeklySalary >= 0)
            weeklySalary = newWeeklySalary;
        else
            System.err.println("Weekly salary connot be negative");
    }
    
    //access method for weekly salary.
    public double getWeeklySalary()
    {
        return weeklySalary;
    }
    
    //overriding method.
    public double getEarnings()
    {
        return weeklySalary;
    }
    
    //overriding toString method.
    public String toString()
    {
        return super.toString() + "; weekly salary is: " + MONEY.format(weeklySalary);
    }
}
