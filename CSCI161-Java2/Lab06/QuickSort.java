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
 * This is the quick sort algorithm that was implemented by Sameer Abufardeh
 */
public class QuickSort {
/*
 * 
 */
    public void quickSort(int[] a, int p, int r)
   {
        if(p<r)
        {
            int q = Partition(a, p,r);
            quickSort(a, p, q-1);
            quickSort(a, q+1, r);
        }
     }
/**
 * 
 * @param a the data that you are searching through
 * @param p the value that you are looking for
 * @param r the right most position of your array
 * @return the index where the value was found.
 */
     private int Partition(int[] a, int p, int r)
     {
         int x = a[r];

         int i = p-1;
         int temp=0;

         for(int j=p; j<r; j++)
         {
             if(a[j]<=x)
             {
                 i++;
                 temp = a[i];
                 a[i] = a[j];
                 a[j] = temp;
             }
         }

         temp = a[i+1];
         a[i+1] = a[r];
         a[r] = temp;
         return (i+1);
     }

}
