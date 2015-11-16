
/**
 * Demonstrate knowledge of User_Defined Classes with a Date class.
 * 
 * @author mfeist 
 * @version 03/26/2013
 */
public class Date
{
    private int day;//instance variable for the day.
    private int month;//instance variable for the month.
    private int year;//instance variable for the year.
    
    public Date (int xDay, int xMonth, int xYear)//construtor.
    {
        setDay (xDay);//set beginning value.
        setMonth (xMonth);//set beginning value.
        setYear (xYear);//set beinning value.
    }
    
    public int getMonth()//accessor method.
    {
        return month;//returns the value of the month.
    }
    
    public void setMonth(int newMonth)//mutator method.
    {
        if (newMonth >= 0)//check to see if number is positive.
            month = newMonth;//if positive, new value is stored.
        else
        {
            System.err.println("Month cannont be negative.");//error if negative and value not changed.
            System.err.println("Value not changed.");
        }
    }
    
    public int getYear()//accessor method.
    {
        return year;//returns the value of the year.
    }
    
    public void setYear(int newYear)//mutator method.
    {
        if (newYear >= 0)//check, to make sure value is positive.
            year = newYear;//if positive, new value is stored.
        else
        {
            System.err.println("Year cannot be negative.");//error if negative and value is not changed.
            System.err.println("Value not changed.");
        }
    }
   
    public int getDay()//accessor method.
    {
        return day;//returns the value of the day.
    }
    
    public void setDay(int newDay)//mutator method.
    {
        if (newDay >= 0)//check to make sure the value is positive.
            day = newDay;//if positive, new value is stored.
        else
        {
            System.err.println("Day cannot be negative.");//error is negative and value is not changed.
            System.err.println("Value not changed.");
        }
    }
}
