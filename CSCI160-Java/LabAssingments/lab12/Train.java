
/**
 * Demonstrate knowledge of arrays.
 * 
 * @author mfeist 
 * @version 04/16/2013
 */

import java.util.ArrayList;

public class Train
{
    private ArrayList<Passenger> list;//arraylist.
    
    public Train ()//default constructor.
    {
        list = new ArrayList<Passenger>();
    }
    
    public void addName(Passenger p)//mutator method.
    {
        list.add(p);
    }
    
    public double getNumberFirstClass()//instance method to get the number of people on first class.
    {
        int count = 0;
        for (Passenger p : list)
        {
            if (p.getServiceClass() == 1)
            {
                count++;//adding everytime someone is first class.
            }
        }
        double average = (double) count/list.size();
        return average;
    }
    
    public double getTotalRevenue(double firstClassPrice, double secondClassPrice)//access method for the total revenue.
    {
        int count1 = 0;
        int count2 = 0;
        for (Passenger p : list)
        {
            if (p.getServiceClass() == 1)
                count1++;//adding everytime someone is firstclass.
            else
                count2++;//adding everytime someone is secondclass.
        }
        double totalRevenue = (count1 * firstClassPrice) + (count2 * secondClassPrice);//adding and multiplying the number of people in each class and how much the tickets are.
        return totalRevenue;
    }
    
    public boolean searchByName(String searchName)//access method to see if someone is on the train.
    {
        boolean check = true;
        for (Passenger p : list)
        {
            if (p.getName().equalsIgnoreCase(searchName))
                check = true;
            else
                check = false;
        }
        return check;
    }
    
    public String toString()//toString method.
    {
        String result = " ";
        for (Passenger p : list)
        {
            result += p.toString() + "\n";
        }
        return result;
    }
}
