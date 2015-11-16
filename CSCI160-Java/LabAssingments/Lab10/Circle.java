
/**
 * Demonstrate knowledge of User-Defined Class.
 * 
 * @author mfeist 
 * @version 03/26/2013
 */
public class Circle
{
    private double radius;//instance variable, radius.
    public Circle (double xRadius)//construtor
    {
        setRadius (xRadius);//allows client to beginning value for radius.
    }
    public double getRadius()//accessor method.
    {
        return radius;//return the value of the radius.
    }
    public void setRadius(double newRadius)//mutator method.
    {
        if (newRadius >= 0.0)//if/else statement to verify the value is positive.
            radius = newRadius;//if value is real number then new radius is stored.
        else
        {
            System.err.println("Radius cannon be negative.");//prints error message is negative.
            System.err.println("Value not changed.");
        }
    }
    public double getArea()//accessor method.
    {
        double area = Math.PI * radius * radius;//calculates the area.
        return area;//returns the value of the area
    }
    public double getPerimeter()//accessor method.
    {
        double perimeter = 2 * Math.PI * radius;//calculates the perimeter.
        return perimeter;//returns the value of the perimeter.
    }
}
