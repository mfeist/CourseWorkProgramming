package dicegame;

/**
 *
 * @author mfeist
 */
import java.util.Scanner;
public class DiceGame {

    public static void main(String[] args) {
        //instance variables.
        int number;
        String name;
        String choice;
        //Greeting message.
        System.out.println("Welcome to the Dice Game");
        //creating Scanner Objects.
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        Scanner scan3 = new Scanner(System.in);
        //output asking for the first input.
        System.out.print("Enter your ID number: ");
        number = scan1.nextInt();
        //output asking for the second input.
        System.out.print("Enter your name: ");
        name = scan2.next();
        //calling the Player and Dice class.
        Player player1 = new Player(number, name);
        Dice die = new Dice();
        
        //do-while loop to play the game.
        do
        {
            //output asking if player wants to roll the dice.
            System.out.print("Roll the dice? (y/n): ");
            choice = scan3.next();
            //roll the dice method.
            die.rollDice();
            //adding the total times the dice were rolled.
            player1.total ++;
            //displaying the results.
            System.out.println("Results: " + die.getSum());
            //if statement to determine whether the player won.
            if (die.getSum() == 7)
            {
                //calculates if the player won.
                player1.win ++;
                //ouput showing congrats.
                System.out.println("Congrats, you win!");
            }
            else
                //output for if the player lost.
                System.out.println("Sorry, you lose.");
            //conditions for the do while loop.
        } while (choice.equalsIgnoreCase("y"));
        //Output to display the overall results.
        System.out.println(player1.toString());
    }
}