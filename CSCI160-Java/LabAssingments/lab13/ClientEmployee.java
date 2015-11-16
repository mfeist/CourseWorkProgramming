
/**
 * Client class to test the user-defined subclasses.
 * 
 * @author mfeist
 * @version 05/01/2013
 */

import java.util.ArrayList;
import java.util.Random;
import java.text.DecimalFormat;

public class ClientEmployee
{
    public static void main (String[] args)
    {
        //calling construtors.
        ArrayList<Employee> list = new ArrayList<Employee>();
        Random rand = new Random();
        DecimalFormat pricePattern = new DecimalFormat("$#,###,##0.00");
        
        //single arrays for first and last name.
        String [] fName = {"John", "Jane", "Mike", "Jeff", "Sam"};
        String [] lName = {"Jones", "Smith", "Johnson", "Doe"};

        //nested loop to polulate employee array.
        for (int i = 0; i < 10; i++)
        {
            int value = rand.nextInt(4);//generate a random number from 0-3.
            if (value == 0)//check, making this instance salary type.
            {
                String first = fName[rand.nextInt(5)];
                String last = lName[rand.nextInt(4)];
                String sSN = " ";
                for (int j = 0; j < 9; j++)
                {
                    int x = rand.nextInt(10);
                    sSN += x;
                }
                double salary = rand.nextInt(10000) + rand.nextDouble();
                Employee e = new SalariedEmployee(first, last, sSN, salary);
                list.add(e);
            }
            else if (value == 1)//check, making this instance hourly type.
            {
                String first = fName[rand.nextInt(5)];
                String last = lName[rand.nextInt(4)];
                String sSN = " ";
                for (int j = 0; j < 9; j++)
                {
                    int x = rand.nextInt(10);
                    sSN += x;
                }
                double wage = rand.nextInt(100) + rand.nextDouble();
                int hours = rand.nextInt(60) + 1;
                Employee e = new HourlyEmployee(first, last, sSN, wage, hours);
                list.add(e);
            }
            else if (value == 2)//check, making this instance commission type.
            {
                String first = fName[rand.nextInt(5)];
                String last = lName[rand.nextInt(4)];
                String sSN = " ";
                for (int j = 0; j < 9; j++)
                {
                    int x = rand.nextInt(10);
                    sSN += x;
                }
                double sales = rand.nextInt(100000) + rand.nextDouble();
                double commission = rand.nextDouble();
                Employee e = new CommissionEmployee(first, last, sSN, sales, commission);
                list.add(e);
            }
            else//making last number as base plus commission.
            {
                String first = fName[rand.nextInt(5)];
                String last = lName[rand.nextInt(4)];
                String sSN = " ";
                for (int j = 0; j < 9; j++)
                {
                    int x = rand.nextInt(10);
                    sSN += x;
                }
                double sales = rand.nextInt(100000) + rand.nextDouble();
                double commission = rand.nextInt(10) + rand.nextDouble();
                double salary = rand.nextInt(100000) + rand.nextDouble();
                Employee e = new BasePlusCommissionEmployee(first, last, sSN, sales, commission, salary);
                list.add(e);
            }
        }
        
        //for loop to display output for the array.
        for (Employee e: list)
        {
            System.out.println(e);
            System.out.println("The total earnings for the week is: " + pricePattern.format(e.getEarnings()) + "\n");
        }
    }
}
