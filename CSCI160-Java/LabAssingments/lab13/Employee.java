
/**
 * User-Defined Super Class.
 * 
 * @author mfeist 
 * @version 05/01/2013
 */

import java.text.DecimalFormat;

public abstract class Employee
{
    DecimalFormat MONEY = new DecimalFormat("$#,###,##0.00");
    
    //instance varibles.
    private String firstName;
    private String lastName;
    private String sSN;
    
    //default constructor.
    public Employee()
    {
        firstName = "Unknown";
        lastName = "Unknown";
        sSN = "000000000";
    }
    
    //overloaded contructor.
    public Employee (String xFirstName, String xLastName, String xSSN)
    {
        firstName = xFirstName;
        lastName = xLastName;
        sSN = xSSN;
    }
    
    //mutator method for first name.
    public void setFirstName(String newFirstName)
    {
        firstName = newFirstName;
    }
    
    //mutator method for last name.
    public void setLastName(String newLastName)
    {
        lastName = newLastName;
    }
    
    //mutator method for ssn.
    public void setSSN(String newSSN)
    {
        sSN = newSSN;
    }
    
    //access method for first name.
    public String getFirstName()
    {
        return firstName;
    }
    
    //access method for last name.
    public String getLastName()
    {
        return lastName;
    }
    
    //access method for ssn.
    public String getSSN()
    {
        return sSN;
    }
    
    //toString method.
    public String toString()
    {
        return ("Employee: " + lastName + ", " + firstName + " SSN:" + sSN);
    }
    
    //abstract access method for earnings.
    public abstract double getEarnings();
}
