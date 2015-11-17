/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acrostic;

import org.me.Lab2Lib.LibClass;

/**
 *
 * @author mfeist
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            //Output to print my name and section number.
            System.out.println("Name: Mathew Feist");
            System.out.println("Section: 2");
            //Calling the acrostic method and printing the result.
            String result = LibClass.acrostic(args);
            System.out.println("Result = " + result);
    }
}
