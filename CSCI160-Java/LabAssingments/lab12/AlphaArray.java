
/**
 * Demonstrate knowledge of single arrays.
 * 
 * @author mfeist
 * @version 04/16/2013
 */
public class AlphaArray
{
    public static void main (String [] args)
    {
        double [] alpha = new double [50];//creating a single dimensional array with 50 elements.
        
        for (int i = 0; i < 25; i++)//for statment to populate the first 25 elements.
            alpha[i] = Math.pow(i, 2);//making the element squared of what the index is.
            
        for (int j = 25; j < 50; j++)//for statement for the last 25 elements.
            alpha[j] = j * 3;//making the elements 3 times the index.
        
        for (int i = 0; i < 50; i ++)//to display the array.
        {
            System.out.print(alpha[i] + " ");//prints the array.
            if (i % 10 == 9)//if statement so that 10 elements are displayed on a line.
                System.out.println();//prints a new line.
        }
    }
}
