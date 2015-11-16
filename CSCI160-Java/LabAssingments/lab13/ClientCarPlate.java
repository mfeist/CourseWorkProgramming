
/**
 * Writing and reading an object.
 * 
 * @author mfeist 
 * @version 05/01/2013
 */

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;

public class ClientCarPlate
{
    public static void main (String[] args)
    {
        //instatiate the objects.
        CarPlate car1 = new CarPlate(123, "ND", "Red");
        CarPlate car2 = new CarPlate(456, "SD", "Orange");
        CarPlate car3 = new CarPlate(789, "FL", "Pink");
        
        try
        {
            FileOutputStream fos = new FileOutputStream ("carPlates.txt", false);
            //write the objects since false.
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //write objects to the file.
            oos.writeObject(car1);
            oos.writeObject(car2);
            oos.writeObject(car3);
            //release resources associated with the objects file.
            oos.close();
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("Unable to write the objects");
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        
        int count = 0;
        try
        {
            FileInputStream fis = new FileInputStream("carPlates.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            try
            {
                while (true)
                {
                    //read object, type cast returned to CarPlate
                    CarPlate temp = (CarPlate)ois.readObject();
                    //counting number of times going through file.
                    count++;
                    //print the CarPlate object read.
                    System.out.println(temp);
                }
            }//end of inner try block.
            catch (EOFException eofe)
            {
                System.out.println("End of the file reached");
            }
            catch (ClassNotFoundException cnfe)
            {
                System.out.println(cnfe.getMessage());
            }
            finally
            {
                System.out.println("Closing file");
                //release the file associated with the objects.
                ois.close();
            }
        }//end of out try block.
        catch (FileNotFoundException fnfe)
        {
            System.out.println("Unable to find objects");
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        //print the number of objects.
        System.out.println("There are " + count + " objects in the file.");
    }
}
