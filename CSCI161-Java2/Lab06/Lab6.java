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
 * This program take the length of an array and will calculate the time it
 * takes to search for 100 random keys in a sorted version of that array and
 * an unsorted version.
 */
public class Lab6 {
    private static RandomNumbers rn = new RandomNumbers();
    private static Results r = new Results();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        r.qSort();
        r.seqSearch();
        r.binSearch();
        r.binSortedSearch();
        r.seqSortSearch();
        r.printArrays();
    }
}
