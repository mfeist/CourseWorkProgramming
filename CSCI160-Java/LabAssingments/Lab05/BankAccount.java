
/**
 * BankAccount class that represents a real world entity Bank Account. It supports deposit, withdrawal 
 * and checking balance operations.
 * 
 * @author mfeist 
 * @version 2/5/2013
 */
public class BankAccount
{
    //instance variable balance to store the balance amount information
    private double balance;

    /**
     * Default constructor for objects of class BankAccount which initializes balance to zero.
     */
    public BankAccount()
    {
        // initialise instance variables
        balance = 0;
    }

    /**
     * Constructor for objects of class BankAccount which initializes balance to amount.
     */
    public BankAccount(double amount)
    {
        balance = amount;
    }
    /**
     * getBalance() method returns the current balance
     * 
     * @param      no parameter
     * @return     double 
     */
    public double getBalance()
    {
       return balance;
    }
    
    /**
     * deposit() method adds the amount to the current balance
     * 
     * @param      double amount
     * @return     void 
     */
    public void deposit(double amount)
    {
        balance += amount;        
    }
    
    /**
     * withdraw() method reduces the current balance by amount
     * 
     * @param      double amount
     * @return     void 
     */
    public void withdraw(double amount)
    {
        if (amount > balance)
            throw new IllegalArgumentException("insufficient balance");
        else
            balance -= amount;
    }
}
