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
 * This is the binary search algorithm. It splits the value in the middle 
 * and will look for you value.
 */
public class BinarySearchAlgorithm {

    private static int middle = 0;
    private static long duration;
/**
 * 
 * @param array the data you are searching through
 * @param value the value in the data you are looking for
 * @param left the left most index in the array
 * @param right the right most index in the array
 * @return the position where the key was found
 */
    public static int binarySearch(int[] array, int value, int left, 
    int right) {

        long startTime = System.nanoTime();

        while (left <= right) {

            middle = (left + right) / 2;

            if (array[middle] == value) {
                return middle;
            } else if (array[middle] > value) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }

        }
        long endTime = System.nanoTime();
        duration = (endTime - startTime);
        return -1;

    }
/**
 * 
 * @return middle, the position where it was found
 */
    public static int getMiddle() {
        return middle;
    }
/**
 * 
 * @return duration, which is the time that it took for the search
 */
    public static long getDuration() {
        return duration;
    }
}
