
/**
 * Create a java program to run for commision.
 * 
 * @author mfeist 
 * @version 2/15/2013
 */
import java.util.Scanner;
import java.text.DecimalFormat;

public class Realtor
{
    public static void main (String [] args)
    {
        System.out.println("This program calculates the cost to sell a home and the commission" +
                            "\npaid to an individual sales agent.");//output to view what is being accomplished.
        System.out.println("\nThe user is asked for the last name of the seller and the sales price.");//output for what will be asked for the input.
        DecimalFormat pricePattern = new DecimalFormat("$#,###.00");//instatiated a DecimalFormat object specifying format.
        Scanner scan = new Scanner(System.in);//instatiated a Scanner for system input.
        System.out.print("\nPlease enter the owner's last name > ");//output asking for the last name of the owner.
        String name1 = scan.next();//declaring name1 as a string for what was inputed.
        System.out.print("Please enter the sales price > ");//output asking for the sales price.
        double price1 = scan.nextDouble();//declaring price1 as a double for what was inputed.
        final double salesCommission = .06;//declaring a constant for the rate of a commissions of a house.
        final double agentPrice = .015;//declaring a constant for the rate for agent's price.
        double cost1 = price1 * salesCommission;//calculating the cost for the cost for the commision.
        double agent1 = price1 * agentPrice;//calculating the earnings for the agent.
        System.out.println("\nThe " + name1 + "'s home sold for " + pricePattern.format(price1));//output showing how much the owner sold the house for.
        System.out.println("The cost to sell the home was " + pricePattern.format(cost1));//output showing the commission.
        System.out.println("The selling or listing agent earned " + pricePattern.format(agent1));//output showing the earnings for the agent.
        
    }
}
