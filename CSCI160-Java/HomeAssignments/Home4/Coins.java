
/**
 * User-Defined class for coins.
 * 
 * @author mfeist
 * @version 04/10/2013
 */

public class Coins
{
    private int numberOfQuarters;//instance variable.
    private int numberOfDimes;//instance variable.
    private int numberOfNickels;//instance variable.
    private int numberOfPennies;//instance variable.
    double quarterValue = .25;//constant for value of quarter.
    double dimeValue = .1;//constant for value of dime.
    double nickelValue = .05;//constant for value of nickel.
    double pennyValue = .01;//constant for value of penny.
    
    public Coins ()//default constructor.
    {
        numberOfQuarters = 0;
        numberOfDimes = 0;
        numberOfNickels = 0;
        numberOfPennies = 0;
    }
    
    public Coins (int xNumberOfQuarters, int xNumberOfDimes, int xNumberOfNickels, int xNumberOfPennies)//overloaded constructor.
    {
        numberOfQuarters = xNumberOfQuarters;
        numberOfDimes = xNumberOfDimes;
        numberOfNickels = xNumberOfNickels;
        numberOfPennies = xNumberOfPennies;
    }
    
    public int getNumberOfQuarters()//get method for quarters.
    {
        return numberOfQuarters;
    }
    
    public int getNumberOfDimes()//get method for dimes.
    {
        return numberOfDimes;
    }
    
    public int getNumberOfNickels()//get method for nickels.
    {
        return numberOfNickels;
    }
    
    public int getNumberOfPennies()//get method for penny.
    {
        return numberOfPennies;
    }
    
    public void depositNumberOfQuarters(int addNumberOfQuarters)//mutator method for adding quarters.
    {
        numberOfQuarters += addNumberOfQuarters;
    }
    
    public void depositNumberOfDimes(int addNumberOfDimes)//mutator method for adding dimes.
    {
        numberOfDimes += addNumberOfDimes;
    }
    
    public void depositNumberOfNickels(int addNumberOfNickels)//mutator method for adding nickels.
    {
        numberOfNickels += addNumberOfNickels;
    }
    
    public void depositNumberOfPennies(int addNumberOfPennies)//mutator method for adding pennies.
    {
        numberOfPennies += addNumberOfPennies;
    }
    
    public void withdrawNumberOfQuarters(int minusNumberOfQuarters)//mutator method for withdrawing quarters.
    {
        numberOfQuarters -= minusNumberOfQuarters;
    }
    
    public void withdrawNumberOfDimes(int minusNumberOfDimes)//mutator method for withdrawing dimes.
    {
        numberOfDimes -= minusNumberOfDimes;
    }
    
    public void withdrawNumberOfNickels(int minusNumberOfNickels)//mutator method for withdrawing nickels.
    {
        numberOfNickels -= minusNumberOfNickels;
    }
    
    public void withdrawNumberOfPennies(int minusNumberOfPennies)//mutator method for withdrawing pennies.
    {
        numberOfPennies -= minusNumberOfPennies;
    }
    
    public String toString()//toString method.
    {
        return "Number of quarters are: " + numberOfQuarters
                + "\nNumber of dimes are: " + numberOfDimes
                + "\nNumber of nickels are: " + numberOfNickels
                + "\nNumber of pennies are: " + numberOfPennies;
    }
    
    public boolean equals(Object o)//equals method.
    {
        if (!( o instanceof Coins))
            return false;
        else
        {
            Coins objCoins = (Coins) o;
            if (numberOfQuarters == objCoins.numberOfQuarters && numberOfDimes ==objCoins.numberOfDimes && numberOfNickels == objCoins.numberOfNickels && numberOfPennies == objCoins.numberOfPennies)
                return true;
            else
                return false;
        }
    }
    
    public double getTotalAmount()//get method for total value.
    {
        double totalAmount = (numberOfQuarters * quarterValue) + (numberOfDimes * dimeValue) + (numberOfNickels * nickelValue) + (numberOfPennies * pennyValue);
        return totalAmount;
    }
    
    public double getQuarterAmount()//get method for quarter value.
    {
        double quarterAmount = numberOfQuarters * quarterValue;
        return quarterAmount;
    }
    
    public double getDimeAmount()//get method for dime value.
    {
        double dimeAmount = numberOfDimes * dimeValue;
        return dimeAmount;
    }
    
    public double getNickelAmount()//get method for nickel value.
    {
        double nickelAmount = numberOfDimes * nickelValue;
        return nickelAmount;
    }
    
    public double getPennyAmount()
    {
        double pennyAmount = numberOfPennies * pennyValue;
        return pennyAmount;
    }
}
