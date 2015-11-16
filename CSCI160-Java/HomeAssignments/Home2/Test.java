
/**
 * Display your grade.
 * 
 * @author mfeist 
 */
import java.text.DecimalFormat;

public class Test
{
    public static void main(String [] args)
    {
        double grade = .895;
        DecimalFormat percent = new DecimalFormat("#.0%");
        System.out.println("Your grade is " + percent.format(grade));
    }
}
