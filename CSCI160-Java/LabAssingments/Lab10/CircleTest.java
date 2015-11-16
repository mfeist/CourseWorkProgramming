
/**
 * Demonstrate knowledge of using User-Defined Classes.
 * 
 * @author mfeist 
 * @version 03/26/2013
 */
import java.util.Scanner;

public class CircleTest
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");//output asking for the radius.
        double x = scan.nextDouble();//value that was entered stored as a double.
        Circle circle1 = new Circle(x);
        
        while (x < 0)//while statement in case the user entered a negative number.
        {
            System.out.println("You entered a negative number, please enter a positive radius: ");
            x = scan.nextDouble();
            circle1.setRadius(x);
        }
        
        System.out.println("The radius of the circle is: " + circle1.getRadius());//output stating the value of the radius.
        System.out.println("The area of the circle is: " + circle1.getArea());//output stating the value of the area.
        System.out.println("The perimeter of the circle is: " + circle1.getPerimeter());//output stating the value of the perimeter.
        
        System.out.print("Would you like to try again, YES or NO: ");//output asking if user wants to enter another value.
        String value = scan.next();//value as a string.
        String value1 = value.toUpperCase();//to make the string in all caps.
        
        final String SENTINEL = "YES";//sentinel value.
        
        while (value1.equals(SENTINEL))
        {
           System.out.print("Enter the radius of the circle: ");//output asking for radius.
           x = scan.nextDouble();//value stored as a double.
           circle1.setRadius(x);//changing the value of the radius.
           while (x < 0)//while statement to verify the number is positive.
           {
                System.out.println("You entered a negative number, please enter a positive radius: ");//stating the number is negative.
                x = scan.nextDouble();
                circle1.setRadius(x);
           }
           System.out.println("The radius of the circle is: " + circle1.getRadius());//output stating the radius of the circle.
           System.out.println("The area of the circle is: " + circle1.getArea());//output stating the area of the cirlce.
           System.out.println("The perimeter of the circle is: " + circle1.getPerimeter());//output stating the perimeter of the circle.
           System.out.print("Would you like to try again, YES or NO: ");//output asking if the user would like to enter another value.
           value = scan.next();//value is a string.
           value1 = value.toUpperCase();//makes the value all caps.
        }
        System.out.println("Goodbye");//output so the user knows the program is done.
    }
}
