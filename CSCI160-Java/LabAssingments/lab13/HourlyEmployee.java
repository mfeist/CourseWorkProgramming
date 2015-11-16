
/**
 * User-Defined sub-class.
 * 
 * @author mfeist
 * @version 05/01/2013
 */
public class HourlyEmployee extends Employee
{
    //instance variables.
    private double wage;
    private int hours;
    private final int fullTime = 40;
    private final double overTime = 1.5;
    
    //default construtor.
    public HourlyEmployee()
    {
        super();
        wage = 0.0;
        hours = 0;
    }
    
    //overloaded construtor.
    public HourlyEmployee(String fName, String lName, String sSN, double xWage, int xHours)
    {
        super(fName, lName, sSN);
        setWage(xWage);
        setHours(xHours);
    }
    
    //mutator method for wage.
    public void setWage(double newWage)
    {
        if(newWage >=0)
            wage = newWage;
        else
            System.err.println("Wages cannot be negative");
    }
    
    //mutator method for hours.
    public void setHours(int newHours)
    {
        if (newHours >=0)
            hours = newHours;
        else
            System.err.println("Hours cannot be negative");
    }
    
    //access method for wage.
    public double getWage()
    {
        return wage;
    }
    
    //access method for hours.
    public int getHours()
    {
        return hours;
    }
    
    //overriding toString method.
    public String toString()
    {
        return super.toString() + "; wages are: " + MONEY.format(wage) + " and hours are: " + hours;
    }
    
    //overriding acces earnings.
    public double getEarnings()
    {
        double earnings;
        if (hours <= fullTime)
            earnings = wage * hours;
        else
            earnings = (wage * fullTime) + ((wage * overTime) * (hours - fullTime));
        return earnings;
    }
}
