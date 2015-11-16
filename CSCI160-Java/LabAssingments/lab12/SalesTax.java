
/**
 * Demonstrate knowledge of user defined arrays.
 * 
 * @author mfeist 
 * @version 04/16/2013
 */

public class SalesTax
{
    private double[][] rates;//instance variable.
    public SalesTax()//default constructor.
    {
        rates= new double [50] [10];//setting the boundaries for the array.
        for (int i = 0; i < rates.length; i++)//outer loop for the rows.
        {
            for (int j = 0; j < rates[i].length; j++)//inner loop for the colums.
            {
                do
                {
                    rates[i][j] = Math.random();//random number to fill the index.
                } while (rates[i][j] >= .06);//verifying that the tax rate is between 0.00 and 0.06.
            }
        }
    }
    
    private double getLowestRate( int i)//private to find the lowest rate.
    {
        double lowest = rates [0] [0];//declare and inititialize variable.
        for (int j = 1; j < rates[i].length; j++)//for loop to go through the columns.
        {
            if (rates [i][j] < lowest)//if statement to check if the element is the lowest.
                lowest = rates [i][j];//making the lowest.
        }
        return lowest;//returning the lowest element.
    }
    
    public int [] getLowestArray()//access method to return an array.
    {
        int [] temp = new int [rates.length];//declared single array.
        int count = 0;//a way to keep track of for loop.
        int index = 0;//declare and initialize variable.
        SalesTax temp2 = new SalesTax();//creating a temp salestax.
        for (int i = 0; i < rates.length; i++)//for loop to go through the rows of rates array.
        {
            double lowest1 = temp2.getLowestRate(i);//accessing the getLowestRate method and returning that to lowest.
            if (lowest1 < .001)//if statement to check if lowest is below condition.
            {
                index = i;//indexing the position.
                temp[count] = index;//adding that position to the temp  single array.
                count++;//adding how many times it cycles through if statement.
            }
        }
        int [] answer = new int [count];//making an array with the length of how many times it went through the if statement.
        for(int i = 0; i < answer.length; i++)//for loop to fill loop.
            answer[i] = temp[i];//filling elements.
        return answer;//returning the array with states less than .001.
    }
    
    public double getHighestRate(int i)//access for highest rate of a given state.
    {
        double highest = rates [i] [0];//assuming that the first rate is the highest value.
        for (int j = 1; j < rates[i].length; j++)//for loop to cycle through the columns.
        {
            if (rates [i][j] > highest)//if statement to check for the highest rate.
                highest = rates[i][j];//making the variable the highest rate.
        }
        return highest;//returning the highest rate.
    }
    
    private double getAverageTaxRateState(int x)//get method for a given state.
    {
        double sum = 0;//declare and initialize variable.
        for (int i = 0; i < rates[x].length; i++)
            sum += rates[x][i];//adding the rates in the loop.
        return sum/rates[x].length;//returning the average.
    }
    
    public int getHighestAverage()//get method
    {
        int index = 0;//declare and initialize variable.
        double max = getAverageTaxRateState(0);//declare and initialize variable and assuming 0 index is max element.
        for (int i = 0; i < rates.length; i++)
        {
            double current = getAverageTaxRateState(i);//declaring and initizling variable and setting the current element to current index.
            if (current > max)//if statement to check if current is greater than max.
            {
                max = current;//changing max to new max.
                index = i;//setting the index to current.
            }
        }
        return index;//returning index.
    }
}
