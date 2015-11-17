/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Christopher Jordan-Denny
 * @author Mathew Feist
 * @author Taren McCullough
 * @Section 2
 * @version 1.0
 * 
 * This class will put random numbers in an array of length whatever you
 * want
 */
public class RandomNumbers {

    public static int[] unsortedArray;
    public static int[] sortedArray;
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    int n;

    public RandomNumbers() {
    }
/*
 * actually creates that array of length you choose
 */
    public void randomIntegerArray() {

        try {
            System.out.print
                    ("How many random numbers would you like to Generate: ");
            n = scan.nextInt();
        } catch (Exception e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
        unsortedArray = new int[n];
        sortedArray = new int[n];
        for (int i = 0; i < unsortedArray.length; i++) {
            //We want to start at 1 and not 0
            unsortedArray[i] = rand.nextInt(99000) + 1;
            sortedArray[i] = unsortedArray[i];
        }

    }
}
