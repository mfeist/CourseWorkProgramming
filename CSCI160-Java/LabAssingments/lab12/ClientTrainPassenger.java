
/**
 * Write a description of class ClientTrainPassenger here.
 * 
 * @author mfeist
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.io.File;

public class ClientTrainPassenger
{
    public static void main (String [] args) throws IOException
    {
        DecimalFormat dollarPattern = new DecimalFormat("$#,##0.00");//formating for dollar pattern.
        File inputFile = new File ("Passenger.txt");//accessing the text file.
        Scanner scan = new Scanner(inputFile);//scanner class for the inputfile.
        Train train1 = new Train();//accessing the train class.
        Scanner scan2 = new Scanner(System.in);//second type of scanner class for input from user.
        DecimalFormat percentPattern = new DecimalFormat("0.0%");//formating for percent pattern.
        
        while(scan.hasNext())//while to get the info from the file.
        {
            String tempName = scan.next();//making first part a string.
            int tempClass = scan.nextInt();//making second part an int.
            Passenger passenger = new Passenger(tempName, tempClass);//adding input for to the passenger class.
            train1.addName(passenger);//adding to arraylist.
        }
        System.out.print("Enter the price of a first class ticket: ");//output asking for amount of first class ticket.
        double firstClassPrice = scan2.nextDouble();//making it a double value.
        System.out.print("Enter the price of a second class ticket: ");//output for the second class ticket amount.
        double secondClassPrice = scan2.nextDouble();//making it a double.
        System.out.println("\n" + percentPattern.format(train1.getNumberFirstClass()) + " of passengers are first class.");//output for the percent of first class passengers.
        System.out.println("The total revenue for the train is " + dollarPattern.format(train1.getTotalRevenue(firstClassPrice, secondClassPrice)) + ".");//total amount.
        
        System.out.print("\nEnter the name of a passenger to see if he/she is on the train: ");//output for a name.
        String name = scan2.next();
        if (train1.searchByName(name))//checking to see if name is on the train.
            System.out.println(name + " is on the train.");
        else
            System.out.println(name + " is not on the train.");
    }
}
