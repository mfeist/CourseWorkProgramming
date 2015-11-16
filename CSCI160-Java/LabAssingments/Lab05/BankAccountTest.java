
/**
 * Demonstrate ability to use object references.
 * 
 * @author mfeist 
 * @version 2/5/2013
 */
public class BankAccountTest
{
    public static void main (String[] args)
    {
        BankAccount account1 = new BankAccount();//declared and instantiated the frist object reference.
        System.out.println("The initial balance of Account1 is $" + account1.getBalance() + ".");//display output for the initial account balance.
        account1.deposit(1000);//deposited 1000 into account1.
        System.out.println("The current balance of account1 after deposit is $" + account1.getBalance() + ".");//display output for account1 after deposit.
        account1.withdraw(250);//withdrew 250 from account1.
        System.out.println("The current balance of account1 after withdrawal is $" + account1.getBalance() + ".");//display output for account1 after withdrawal.
        BankAccount account2 = new BankAccount(500.0);//declared and instantiated second object reference with 500 in the account.
        System.out.println("The initial balance of account2 is $" + account2.getBalance() + ".");//display output for second account.
        account2.withdraw(200);//withdrew 2000 since 550 was more than the amount in the account, and an error was displayed.
        account2 = account1;//copied object reference account1 to object object reference account2.
        account1.deposit(50);//deposited 50 into account1.
        System.out.println("The current balance for account1 is $" + account1.getBalance()
                           + " and the current balance for account2 is $" + account2.getBalance() + ".");//displayed output for the two accounts.
    }
}
