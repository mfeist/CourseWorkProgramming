
/**
 * Client class to test the user-defined class.
 * 
 * @author Micheal Feickert, Mathew Feist, Matthew Thomas 
 * @version 04/26/2013
 */

import java.util.Scanner;

public class ClientCards
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner(System.in);//calling a constructor.
        System.out.print("0: Diamonds" 
                        + "\n1: Hearts"
                        + "\n2: Clubs"
                        + "\n3: Spades");//output to show the user what to enter.
        System.out.print("\nEnter the value of the suit of trump: ");//output for the user to enter trump.
        int x = scan.nextInt();//making it an int value.
        Cards deck = new Cards(x);//calling the user-defined constructor.
        System.out.println("\nTrump suit is: " + deck.getTrump(x));//output for the trump.
        System.out.print("\nThe point value for each card is:");//output.
        System.out.println(deck.getDeck());//output for the string of each card.
        System.out.print("\nEnter a card suit: ");//output for user to enter a suit.
        String suit = scan.next();//making it a string value.
        System.out.println("The total point value for " + suit + " is: " + deck.getRowTotal(suit));//output for the row total for the suit entered.
    }
}
