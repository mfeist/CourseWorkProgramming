
/**
 * Using User_defined class Coins.
 * 
 * @author mfeist 
 * @version 04/10/2013
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class CoinsTest
{
    public static void main (String [] args)
    {
        DecimalFormat pricePattern = new DecimalFormat("$#,###,##0.00");
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of quarters: ");//output for the number of quarters.
        int quarters = scan.nextInt();//making an int variable.
        System.out.print("Enter the number of dimes: ");//ouput for the number of dimes.
        int dimes = scan.nextInt();//making an int variable.
        System.out.print("Enter the number of nickels: ");//output for the number of nickels.
        int nickels = scan.nextInt();//making an int variable.
        System.out.print("Enter the number of pennies: ");//output for the number of pennies.
        int pennies = scan.nextInt();//making an int varable.
        
        Coins alpha = new Coins(quarters, dimes, nickels, pennies);
        
        System.out.print("Enter number of quarters added: ");//output for quarters added.
        int qAdd = scan.nextInt();//int variable.
        alpha.depositNumberOfQuarters(qAdd);//adding to quarters.
        System.out.print("Enter number of dimes added: ");//output for dimes added.
        int dAdd = scan.nextInt();//int variable.
        alpha.depositNumberOfDimes(dAdd);//adding to dimes.
        System.out.print("Enter number of nickels added: ");//output for nickels added.
        int nAdd = scan.nextInt();//int variable.
        alpha.depositNumberOfNickels(dAdd);//adding to nickels.
        System.out.print("Enter number of pennies added: ");//output for pennies added.
        int pAdd = scan.nextInt();//int variable.
        alpha.depositNumberOfPennies(pAdd);//adding to pennies.
        
        System.out.println("The number of quarters are " + alpha.getNumberOfQuarters());//output showing number of quarters.
        System.out.println("The number of dimes are " + alpha.getNumberOfDimes());//output showing number of dimes.
        System.out.println("The number of nickels are " + alpha.getNumberOfNickels());//output showing number of nickels.
        System.out.println("The number of pennies are " + alpha.getNumberOfPennies());//output showing number of pennies.
        
        System.out.print("Enter number of quarters taken away: ");//output for quarters minused.
        int qMinus = scan.nextInt();//int variable.
        alpha.withdrawNumberOfQuarters(qMinus);//taking away quarters.
        System.out.print("Enter number of dimes taken away: ");//output for dimes minused.
        int dMinus = scan.nextInt();//int variable.
        alpha.withdrawNumberOfDimes(dMinus);//taking away dimes.
        System.out.print("Enter number of nickels taken away: ");//output for nickels minused.
        int nMinus = scan.nextInt();//int variable.
        alpha.withdrawNumberOfNickels(nMinus);//taking away nickels.
        System.out.print("Enter number of pennies taken away: ");//output for pennies minused.
        int pMinus = scan.nextInt();//int variable.
        alpha.withdrawNumberOfPennies(pMinus);//taking away pennies.
        
        System.out.println(alpha.toString());//output for the toString method.
        System.out.println("The total amount is: " + pricePattern.format(alpha.getTotalAmount()));//to show total amount.
        System.out.println("The total value of the quarters are: " + pricePattern.format(alpha.getQuarterAmount()));//output for value of quarters.
        System.out.println("The total value of the dimes are: " + pricePattern.format(alpha.getDimeAmount()));//output for the value of dimes.
        System.out.println("The total value of the nickels are: " + pricePattern.format(alpha.getNickelAmount()));//output for the value of nickels.
        System.out.println("The total value of the pennies are: " + pricePattern.format(alpha.getPennyAmount()));//output for the value of pennies.
        
        System.out.print("Enter the number of quarters: ");//output for the number of quarters.
        int quarters2 = scan.nextInt();//making an int variable.
        System.out.print("Enter the number of dimes: ");//ouput for the number of dimes.
        int dimes2 = scan.nextInt();//making an int variable.
        System.out.print("Enter the number of nickels: ");//output for the number of nickels.
        int nickels2 = scan.nextInt();//making an int variable.
        System.out.print("Enter the number of pennies: ");//output for the number of pennies.
        int pennies2 = scan.nextInt();//making an int varable.
        
        Coins bravo = new Coins(quarters2, dimes2, nickels2, pennies2);
        
        if (alpha.equals(bravo))//if for equals method.
            System.out.println(alpha + " equals " + bravo);//output if it does equal.
        else
            System.out.println(alpha + " does not equal " + bravo);//output if it does not equal.
    }
}
