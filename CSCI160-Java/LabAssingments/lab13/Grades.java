
/**
 * @author mfeist
 * @version 05/01/2013
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Grades
{
   public static void main (String [] args)
   {
       int grade = 0;//instantiate and declared object.
       int count = 0;//instantiate and declared object.
       int total = 0;//instantiate and declared object.
       double average = 0;//instantiate and declared object.
       int max = Integer.MIN_VALUE;//instantiate and declared object.
       int min = Integer.MAX_VALUE;//instantiate and declared object.
       int studentsPassed = 0;//instantiate and declared object.
       int studentsA = 0;//instantiate and declared object.
       int studentsB = 0;//instantiate and declared object.
       int studentsC = 0;//instantiate and declared object.
       int studentsD = 0;//instantiate and declared object.
       int studentsF = 0;//instantiate and declared object.
       
       try
       {
            Scanner file = new Scanner (new File("Grades.txt"));
            while (file.hasNext())//loop to obtain all the grades and condition for when to stop.
            {
                
                
                grade = file.nextInt();//obtains the next value from the text as an int.
           
                if (grade > max)//if statement to determine the maximum grade.
                    max = grade;//replaces the max if the grade is higher.
            
                if (grade < min)//if statement to determine the minimum grade.
                    min = grade;//replaces the min if the grade is lower.
           
                if (grade >= 60)//if statement for determining if students passed.
                    studentsPassed ++;//counts the number of students who passed.
           
                if (grade >= 90)//if statement to find out if student received an A.
                    studentsA ++;//counts the number of students who received an A.
           
                else if (grade >= 80)//else if statement to find out if student received a B.
                    studentsB ++;//counts the number of students who received a B.
           
                else if (grade >= 70)//else if statement to find out if student receieved a C.
                    studentsC ++;//counts the number of studetns who received a C.
           
                else if (grade >= 60)//else if statement to find out if student received a D.
                    studentsD ++;//counts the number of students who received a D.
           
                else//everything else that is not covered from the if/else if.
                    studentsF ++;//counts the number of students who received an F.
           
                total += grade;//adding up the total grade.
                count ++;//adding up the number of students.
            }
            file.close();
       }
       catch (FileNotFoundException fnfe)
       {
           System.out.println("Unable to find Grades.txt, exiting");
       }
       
       catch (NumberFormatException nfe)
       {
           System.out.println("Number is not able to have a zero for the denominator");
       }
        
       average = (double) (total)/count;//calulation to find the average.
       
       System.out.println("There are " + count + " students.");//output to view the number of students.
       System.out.println("The average grade is " + average);//output to view the average grade.
       System.out.println("The highest grade is " + max);//output to view the highest grade.
       System.out.println("The lowest grade is " + min);//output to view the lowerst grade.
       System.out.println("The number of students who passed is " + studentsPassed);//output to view the number of students who passed.
       System.out.println("The number of students who received an A is " + studentsA);//output to view the number of students who received an A.
       System.out.println("The number of students who received a B is " + studentsB);//output to view the number of students who received a B.
       System.out.println("The number of students who received a C is " + studentsC);//output to view the number of students who received a C.
       System.out.println("The number of students who received a D is " + studentsD);//output to view the number of students who received a D.
       System.out.println("The number of students who received an F is " + studentsF);//output to view the number of students who received an F.
   }
}
