
/**
 * Demonstrate knowledge of arrays.
 * 
 * @author mfeist 
 * @version 04/16/2013
 */
public class Passenger
{
    private String name;//instance variable.
    private int serviceClass;//instance variable.
    
    public Passenger(String xName, int xServiceClass)//constructor.
    {
        name = xName;//changing name.
        serviceClass = xServiceClass;//changing service class.
    }
    
    public int getServiceClass()//access method.
    {
        return serviceClass;
    }
    
    public String getName()//access method.
    {
        return name;
    }
    
    public void setServiceClass(int newServiceClass)//mutator method.
    {
        serviceClass = newServiceClass;
    }
    
    public void setName(String newName)//mutator method.
    {
        name = newName;
    }
    
    public String toString()//toString method.
    {
        return ("name: " + name + "\t" + "class: " + serviceClass);
    }
}
