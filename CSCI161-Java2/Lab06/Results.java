/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

import java.util.Random;

/**
 *
 * @author Christopher Jordan-Denny
 * @author Mathew Feist
 * @author Taren McCullough
 * @Section 2
 * @version 1.0
 * 
 * This displays all the results. It has the times and positions of 
 * the sorted and unsorted array
 */
public class Results {

    QuickSort qsort = new QuickSort();
    Random rand = new Random();
    RandomNumbers rn = new RandomNumbers();
    private int[] keyArray = new int[100];
    private long[] time = new long[100];
/**
 * This is quick sorting the sorted array
 */
    public void qSort() {
        //sorts the array
        rn.randomIntegerArray();
        qsort.quickSort(RandomNumbers.sortedArray, 0
                , RandomNumbers.sortedArray.length - 1);
        
        //randomly picks numbers from the unsorted array to search for later
        for (int i = 0; i < keyArray.length; i++) {
            keyArray[i] = RandomNumbers.unsortedArray
                    [rand.nextInt(RandomNumbers.unsortedArray.length)];
            System.out.println("The key is: " + keyArray[i]);
        }
    }
    /*
     * This is the sequential search of the unsorted array
     */
    public void seqSearch(){ 
        long sum = 0;
        long average = 0;
        for(int i = 0; i < keyArray.length; i ++){
            SeqSearchAlgorithm.seqSearch
                    (RandomNumbers.unsortedArray,keyArray[i]);
            System.out.println("The key was found at position: " 
                    + SeqSearchAlgorithm.getPos());
            //time
            sum = sum + SeqSearchAlgorithm.getDuration();
            System.out.println
                    ("The sequential search for the unsorted array took: " 
                    + SeqSearchAlgorithm.getDuration());
        }
        average = sum/keyArray.length;
        System.out.println("The average time in nanoseconds was: " 
                + average + "\n");
    }
    /*
     * This is the binary search of the unsorted array
     */
    public void binSearch(){
        long sum = 0;
        long average = 0;
        for(int i = 0; i < keyArray.length; i++){
            BinarySearchAlgorithm.binarySearch(RandomNumbers.unsortedArray, 
                    keyArray[i], 0, RandomNumbers.unsortedArray.length - 1);
            System.out.println("The key was found at position: " 
                    + BinarySearchAlgorithm.getMiddle());
            //time
            sum = sum + BinarySearchAlgorithm.getDuration();
            System.out.println
                    ("The binary search for the unsorted array took: " 
                    + BinarySearchAlgorithm.getDuration());
        }
        average = sum/keyArray.length;
        System.out.println("The average time in nanoseconds was: " + average 
                + "\n");
    }
    /*
     * This is the binary search of the sorted array
     */
    public void binSortedSearch(){
        long sum = 0;
        long average = 0;
        for(int i = 0; i < keyArray.length; i++){
            BinarySearchAlgorithm.binarySearch(RandomNumbers.sortedArray, 
                    keyArray[i], 0, RandomNumbers.sortedArray.length - 1);
            System.out.println("The key was found at position: " 
                    + BinarySearchAlgorithm.getMiddle());
            //time
            sum = sum + BinarySearchAlgorithm.getDuration();
            System.out.println("The binary search for the sorted array took: " 
                    + BinarySearchAlgorithm.getDuration());
        }
        average = sum/keyArray.length;
        System.out.println("The average time in nanoseconds was: " 
                + average + "\n");
    }
    /**
     * This is the sequential search algorithm of the sorted array
     */
     public void seqSortSearch(){ 
        long sum = 0;
        long average = 0;
        for(int i = 0; i < keyArray.length; i ++){
            SeqSearchAlgorithm.seqSearch(RandomNumbers.sortedArray,keyArray[i]);
            System.out.println("The key was found at position: " 
                    + SeqSearchAlgorithm.getPos());
            //time
            sum = sum + SeqSearchAlgorithm.getDuration();
            System.out.println
                    ("The sequential search for the sorted array took: " 
                    + SeqSearchAlgorithm.getDuration());
        }
        average = sum/keyArray.length;
        System.out.println("The average time in nanoseconds was: " + average 
                + "\n");
    }
     /*
      * This prints the first and last 100 of the unsorted and sorted array
      */
     public void printArrays(){
         System.out.println("The unsorted first are: ");
         for(int i = 0; i<100; i++){
             System.out.print(RandomNumbers.unsortedArray[i] + ",\t");
         }
         System.out.println("\nThe unsorted last are: ");
         for(int i = RandomNumbers.unsortedArray.length - 100; 
                 i<RandomNumbers.unsortedArray.length; i++ ){
             System.out.print(RandomNumbers.unsortedArray[i] + ",\t");
         }
         System.out.println("\nThe sorted first are: ");
         for(int i = 0; i<100; i++){
             System.out.print(RandomNumbers.sortedArray[i] + ",\t");
         }
         System.out.println("\nThe sorted last are: ");
         for(int i = RandomNumbers.unsortedArray.length - 100; 
                 i<RandomNumbers.sortedArray.length; i++ ){
             System.out.print(RandomNumbers.sortedArray[i] + ",\t");
         }
         
     }
    
}
