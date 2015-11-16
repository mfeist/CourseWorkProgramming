
/**
 * User-Defined Employee class.
 * 
 * @author mfeist
 * @version 04/03/2013
 */
public class Employee
{
    private String firstName;//instance variable for first name.
    private String lastName;//instance variable for last name.
    private Date birthDate;//instance variabble for brithdate referencing Date class.
    private Date hireDate;//instance variable for hiredate referencing Date class.
    private static int countEmployee = 0;//static variable.
    
    public Employee()//default constructor.
    {
        firstName = "Unkown";
        lastName = "Unkown";
        birthDate = new Date();
        hireDate = new Date();
        countEmployee ++;
    }
    
    public Employee(String xFirstName, String xLastName, Date xBirthDate, Date xHireDate)//overloaded constructor.
    {
        firstName = xFirstName;
        lastName = xLastName;
        birthDate = xBirthDate;
        hireDate = xHireDate;
        countEmployee ++;
    }
    
    public static int getCountEmployee()//static to return the number of employees entered.
    {
        return countEmployee;
    }
    
    public String getFirstName()//get method to return first name.
    {
        return firstName;
    }
    
    public String getLastName()//get method to return last name.
    {
        return lastName;
    }
    
    public Date getBirthDate()//get method to return birthdate calling Date class.
    {
        return birthDate;
    }
    
    public Date getHireDate()//get method return hiredate calling Date class.
    {
        return hireDate;
    }
    
    public void setFirstName(String newFirstName)//set method to change first name.
    {
        firstName = newFirstName;
    }
    
    public void setLastName(String newLastName)//set method to change last name.
    {
        lastName = newLastName;
    }
    
    public String toString()//returns toString method.
    {
        return "Name: " + lastName + ", " + firstName + "\nbirthdate: " +  birthDate.toString() + "\ndate of hire: " + hireDate.toString();
    }
    
    public boolean equals (Object o)//equals method to determine if objects are equal.
    {
        if (!(o instanceof Employee))
            return false;
        else
        {
            Employee objEmployee = (Employee) o;
            if (firstName.equals(objEmployee.firstName) && lastName.equals(objEmployee.lastName) && birthDate.equals(objEmployee.birthDate) && hireDate.equals(objEmployee.hireDate))
                return true;
             else
                return false;
        }
    }
}
