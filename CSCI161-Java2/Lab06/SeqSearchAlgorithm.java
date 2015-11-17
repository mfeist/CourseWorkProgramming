/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

/**
 *
 * @author Christopher Jordan-Denny
 * @author Mathew Feist
 * @author Taren McCullough
 * @Section 2
 * @version 1.0
 * 
 * This is the sequential search algorithm
 */
public class SeqSearchAlgorithm {

    private static int pos = 0;
    private static long duration;
/**
 * 
 * @param data this is the data that you are searching through
 * @param target this is the number you are looking for
 * @return the index where the target was found
 */
    public static int seqSearch(int[] data, int target) {

        long startTime = System.nanoTime();
        int found = 0;

        for (int i = 0; 
                i < RandomNumbers.unsortedArray.length && found != 1; i++) {
            if (target == data[i]) {
                pos = i;
                found = 1;
            }
        }

        long endTime = System.nanoTime();
        duration = (endTime - startTime);
        return pos;
    }
/**
 * 
 * @return The index where the target was found at
 */
    public static int getPos() {
        return pos;
    }
/**
 * 
 * @return the time it took to run
 */
    public static long getDuration() {
        return duration;
    }
}
