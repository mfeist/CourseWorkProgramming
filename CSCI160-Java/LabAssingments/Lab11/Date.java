
/**
 * User-Defined Date Class.
 * 
 * @author mfeist 
 * @version 04/03/2013
 */
public class Date
{
    private int month;//instance variable for month.
    private int date;//instance variable for day.
    private int year;//instance variable for year.
    
    public Date ()//default constructor
    {
        month = 1;
        date = 1;
        year = 2001;
    }
    
    public Date (int xMonth, int xDate, int xYear)//overloaded constructor.
    {
        setMonth (xMonth);
        setDate (xDate);
        setYear (xYear);
    }
    
    public void setMonth(int newMonth)//set method for month.
    {
        if (newMonth >= 1 && newMonth <= 12)//verifying that the month is real.
            month = newMonth;//if true, value is changed.
        else
        {
            System.err.println("Month is invalid.");//if false, value is not changed.
            System.err.println("Value not changed.");
        }
    }
    
    public void setDate(int newDate)//set method for day variable.
    {
        switch (month)//switch to verify day variable is actual for month its in.
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (newDate >= 1 && newDate <= 31)//if for 31 days in a month
                    date = newDate;
                else
                {
                    System.err.println("Date is invalid.");
                    System.err.println("Value not changed.");
                }
                break;
            case 2:
                if (newDate >= 1 && newDate <= 28)//for february.
                    date = newDate;
                else
                {
                    System.err.println("Date is invalid.");
                    System.err.println("Value not changed.");
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (newDate >= 1 && newDate <= 30)//for 30 days in a month.
                    date = newDate;
                else
                {
                    System.err.println("Date is invalid.");
                    System.err.println("Value not changed.");
                }
                break;
           }
    }
    
    public void setYear(int newYear)//set year method.
    {
        if (newYear >= 0)//to make sure year is a real number.
            year = newYear;//if true, value is changed.
        else
        {
            System.err.println("Year cannont be negative.");//if false, value not changed.
            System.err.println("Value not changed.");
        }
    }
    
    public int getMonth()//get method for month.
    {
        return month;
    }
    
    public int getDate()//get method for day.
    {
        return date;
    }
    
    public int getYear()//get method for year.
    {
        return year;
    }
    
    public String toString()//toString method.
    {
        return month + "/" + date + "/" + year;
    }
    
    public boolean equals(Object o)//equals method.
    {
        if (!(o instanceof Date))
            return false;
        else
        {
            Date objDate = (Date) o;
            if (month == objDate.month && date == objDate.date && year == objDate.year)
                return true;
            else
                return false;
        }
    }
}
